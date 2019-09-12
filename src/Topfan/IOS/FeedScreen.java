package Topfan.IOS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.ios.IOSDriver;

public class FeedScreen extends CommonFeature {

	private WebDriver driver;
	private WebElement element;
	private String loginExpectedText = "Please Login or Register and get following benefits.";

	public FeedScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private Map<String, String> getFirstCardFromAllCardsType(List<String> cardTypes) {
		Map<String, String> cardDetails = new HashMap<String, String>();
		element = IOSAppLocators.getInstance().getFeedCardsTopHeader(driver);
		for (String cardType : cardTypes) {
			Keywords.iOSScrollToAndClick(element, cardType);
			waitForActivityIndicator();
			List<WebElement> elements = IOSAppLocators.getInstance().getAllCardsOfFeed(driver);
			for (WebElement card : elements) {
				String cardTitle = Keywords.getAttributeVal(card, "name");
				if (!cardTitle.equals(" ") && !cardTitle.isEmpty()) {
					cardDetails.put(cardType, cardTitle);
					break;
				}
			}
		}
		return cardDetails;
	}

	private List<String> getAllTitles() {
		List<String> titles = new ArrayList<String>();
		List<WebElement> elements = IOSAppLocators.getInstance().getAllCardsOfFeed(driver);
		int i = 0;
		for (WebElement title : elements) {
			String text = Keywords.getAttributeVal(title, "name");
			if (text.matches("Earn ￼(.*?) EURO") || text.equals("@TopFan")) {
				element = IOSAppLocators.getInstance().getCardElement(driver, i);
				text = Keywords.getAttributeVal(element, "name");
			}
			titles.add(text);
			i++;
		}
		return titles;
	}

	private void verifyAllCardsInFeed(List<String> cardTypes, Map<String, String> cardDetails) {
		try {
			int attempt = 0;
			WebElement cards = IOSAppLocators.getInstance().getFeedCards(driver);
			while (attempt < 3) {
				List<String> titles = new ArrayList<String>();
				if (!cardTypes.isEmpty()) {
					titles = getAllTitles();
					for (String type : cardTypes) {
						if (titles.contains(cardDetails.get(type))) {
							String text = cardDetails.get(type);
							if (text.length() > 25)
								text = text.substring(0, 25);
							Keywords.iOSScrollTo(cards, text);
							DriverSession.getLastExecutionReportingInstance().teststepreporting(
									"<b>" + type + "</b> type card is present with title : " + cardDetails.get(type),
									"PASS", "Verifying presence of " + type + " type card");
							cardDetails.remove(type);
						}
					}
				}
				if (cardDetails.isEmpty())
					break;
				else {
					attempt++;
					String text;
					for (int i = (titles.size() - 1); i >= 0; --i) {
						if (!titles.get(i).equals(" ") && !titles.get(i).isEmpty()) {
							text = titles.get(i);
							if (text.length() > 25)
								text = text.substring(0, 25);
							Keywords.iOSScrollTo(cards, text);
							Thread.sleep(10000L);
							break;
						}
					}
				}
			}
			if (!cardDetails.isEmpty()) {
				for (String type : cardDetails.keySet())
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting(
									"<b>" + type + "</b> type card with Title : <b>" + cardDetails.get(type)
											+ "</b> is not present",
									"FAIL", "Verifying presence of " + type + " type card");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying all types of card", "FAIL",
					"Verifying presence of all types of card");
		}
	}

	public void verifyAllSectionForCards() {
		try {
			waitForActivityIndicator();
			List<String> cardTypes = getAllTitleTypes();
			Map<String, String> cardDetails = getFirstCardFromAllCardsType(cardTypes);
			Keywords.iOSScrollToAndClick(element, "All");
			waitForActivityIndicator();
			verifyAllCardsInFeed(cardTypes, cardDetails);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying all types of card", "FAIL",
					"Verifying presence of all types of card");
		}
	}

	public void verifyLikeButton() {
		try {
			boolean finalFlag = false;
			waitForActivityIndicator();
			List<WebElement> elements = IOSAppLocators.getInstance().getAllCardsOfFeed(driver);
			mainLoop: for (int i = 0; i < elements.size(); ++i) {
				List<WebElement> buttons = IOSAppLocators.getInstance().getCardButtonElements(driver, i);
				if (buttons.size() > 1) {
					List<WebElement> texts = IOSAppLocators.getInstance().getCardStaticTexts(driver, i);
					boolean flag = false;
					String value;
					for (WebElement text : texts) {
						value = Keywords.getText(text);
						if (value.contains("Like")) {
							flag = false;
							break;
						} else {
							flag = true;
						}
					}
					if (flag) {
						int count = 0;
						for (WebElement button : buttons) {
							if (count == 0) {
								Keywords.iOSScrollInTableWithIndex(0, i);
								count++;
							}

							// if (Keywords.getText(button).trim().equals("icon
							// av play")) {
							// break;
							// }

							// if (Keywords.getText(button).trim().equals("icon
							// like")) {
							if (button.getSize().width == 40 && button.getSize().height == 37
									&& button.getLocation().x <= 0) {
								DriverSession.getLastExecutionReportingInstance().teststepreporting(
										"Appearance of card before clicking Like Button", "INFO",
										"Verifying Like Button on any card");
								Keywords.click(button);
								Thread.sleep(5000L);
								if (DriverSession.getStepResult())
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like Button clicked successfully", "PASS", "Should click on Like Button");
								else
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like Button not clicked", "FAIL", "Should click on Like Button");
								texts = IOSAppLocators.getInstance().getCardStaticTexts(driver, i);
								flag = false;
								for (WebElement text : texts) {
									value = Keywords.getText(text);
									System.out.println(value);
									if (value.contains("1 Like")) {
										// Keywords.iOSScrollInTableWithIndex(0,
										// i);
										DriverSession.getLastExecutionReportingInstance().teststepreporting(
												"Like Button is working as expected", "PASS",
												"Verifying Like Button on any card");
										flag = true;
										finalFlag = true;
										break mainLoop;
									} else {
										flag = false;
									}
								}
								if (!flag) {
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like Button is not working as expected", "FAIL",
											"Verifying Like Button on any card");
									finalFlag = true;
									break mainLoop;
								}
								break;
							}
						}
					}
				}
			}
			if (!finalFlag) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to verify Like Button in " + elements.size() + " cards", "INFO",
						"Verifying Like Button on any card");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured... while verifying Like Button", "FAIL", "Verifying Like Button on any card");
		}
	}

	private List<String> getAllTitleTypes() {
		List<String> cardTypes = new ArrayList<String>();
		List<WebElement> types = IOSAppLocators.getInstance().getFeedCardsTitle(driver);
		for (int i = 1; i < types.size(); ++i) {
			cardTypes.add(Keywords.getAttributeVal(types.get(i), "name"));
		}
		return cardTypes;
	}

	public void verifyLikeWithGuestUser() {
		try {
			List<WebElement> elements = IOSAppLocators.getInstance().getAllCardsOfFeed(driver);
			if(elements.size()>0) {
				for (int i = 0; i < elements.size(); ++i) {
					List<WebElement> buttons = IOSAppLocators.getInstance().getCardButtonElements(driver, i);
					if (buttons.size() > 1) {
						for (WebElement button : buttons) {
							if (Keywords.getText(button).trim().equals("icon like")) {
								Keywords.click(button);
								if (DriverSession.getStepResult())
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like Button clicked successfully", "PASS", "Should click on Like Button");
								else
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like Button not clicked", "FAIL", "Should click on Like Button");
								Thread.sleep(5000L);
								WebElement loginTextElement = IOSAppLocators.getInstance().getLoginText(driver);
								String loginText = Keywords.getAttributeVal(loginTextElement, "name");
								if(loginText.equals(loginTextElement)) 
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like button is working as expected", "PASS", "Verifying Like Button with Guest User");
								else
									DriverSession.getLastExecutionReportingInstance().teststepreporting(
											"Like button is not working as expected", "FAIL", "Verifying Like Button with Guest User");
							}
						}
					}
				}
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"There are no cards in Feed", "FAIL", "Verifying Like Button with Guest User");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured... while verifying Like Button", "FAIL", "Verifying Like Button with Guest User");
		}
	}

}
