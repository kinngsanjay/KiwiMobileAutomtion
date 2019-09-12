package Topfan.IOS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class HomeScreen extends CommonFeature {
	private WebDriver driver;
	private WebElement element;

	public HomeScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void swipe() {
		try {
			@SuppressWarnings("unchecked")
			IOSDriver<MobileElement> Driver = (IOSDriver<MobileElement>) DriverSession.getLastExecutionDriver();
			IOSElement element = (IOSElement) Driver
					.findElement(By.xpath("//UIAImage[@name='video_frame_bg']/following-sibling::UIAImage[1]"));
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			TouchAction action = new TouchAction(Driver);
			action.moveTo(x + 200, y).longPress(element).perform();
			// action.moveTo(x+200,y).longPress(element).waitAction(10000).perform();
			action.release();
			// element.swipe(SwipeElementDirection.RIGHT,100,50, 2000);
			// Driver.swipe(100, 222, 150, 222, 1500);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public Set<String> getTitleOfCurrentCard(int count) throws Exception {
		waitForLoaderToStop();
		Set<String> titles = new HashSet<String>();
		try {
			element = IOSAppLocators.getInstance().getCarousel(driver);
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			int width = element.getSize().getWidth();
			int attempt = 0;
			for (int i = 0; i < count; ++i) {
				String title = IOSAppLocators.getInstance().getCardsTitleFromHomeScreen(driver);
				if (titles.contains(title) && attempt < 10) {
					attempt++;
					count++;
					Thread.sleep(2000L);
				} else {
					titles.add(title);
					((IOSDriver<MobileElement>) driver).swipe(x + 20, y + 100, width - 20, y + 100, 1000);
				}
				Thread.sleep(1000L);
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while getting card names", "FAIL",
					"All types of cards should appear in carousel");
			throw e;
		}
		return titles;
	}

	public ArrayList<String> getTitleCurrentCard(int count) throws InterruptedException {
		LinkedHashSet<String> titles = new LinkedHashSet<String>();
		Thread.sleep(2000L);
		long startTime, timeLapse;
		for (int i = 0; i < count + 1; ++i) {
			startTime = System.currentTimeMillis();
			String title = IOSAppLocators.getInstance().getCardsTitleFromHomeScreen2(driver);
			titles.add(title);
			timeLapse = System.currentTimeMillis() - startTime;
			Thread.sleep(4500 - timeLapse);
		}
		return new ArrayList<String>(titles);
	}

	public ArrayList<String> getTitleOfAllFeeds() {
		LinkedHashSet<String> titles = new LinkedHashSet<String>();
		List<WebElement> visibleFeeds;
		boolean flag = true;
		do {
			try {
				Keywords.waitForPage(driver, 5);
				visibleFeeds = IOSAppLocators.getInstance().getAllVisibleFeeds(driver);
			} catch (Exception e) {
				break;
			}
			for (WebElement feed : visibleFeeds) {
				titles.add(Keywords.getAttributeVal(feed, "name"));
			}
			element = IOSAppLocators.getInstance().getFeedRightArrow(driver);
			if (element.isDisplayed()) {
				Keywords.click(element);
				flag = true;
			} else
				flag = false;
		} while (flag);
		Keywords.waitForPage(driver, 60);
		return new ArrayList<String>(titles);
	}

	public void verifySequenceInCarousel(ArrayList<String> carouselCards) {
		try {
			ArrayList<String> appTitles = new ArrayList<String>();
			ArrayList<String> titles = getTitleCurrentCard(carouselCards.size());
			int index = carouselCards.indexOf(titles.get(0));
			for (int i = 0; i < titles.size(); ++i) {
				appTitles.add(carouselCards.get(index));
				index++;
				if (index == carouselCards.size())
					index = 0;
			}
			if (appTitles.equals(titles)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Carousel sequence verified successfully", "PASS", "Carousel Sequence should be verified");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Sequence in carousel is incorrect",
						"FAIL", "Carousel Sequence should be verified");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying carousel sequence", "FAIL",
					"Carousel Sequence should be verified");
		}
	}

	public void verifySequenceInFeed(ArrayList<String> feedCards) {
		try {
			ArrayList<String> titles = getTitleOfAllFeeds();
			boolean flag = true;

			if (feedCards.isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"There are no feed cards enabled from CMS", "INFO", "Verifying Feed Sequence");
				if (!titles.isEmpty())
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("There are cards present in the app", "FAIL", "Verifying Feed Sequence");
				return;
			} else if (titles.isEmpty()) {
				if (!feedCards.isEmpty()) {
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("There are no feed cards in the app", "FAIL", "Verifying Feed Sequence");
				}
				return;
			}

			if (feedCards.size() == titles.size())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feeds count verified", "PASS",
						"Verifying count of Feed Sequence");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feeds count are not equal", "FAIL",
						"Verifying count of Feed Sequence");

			for (int i = 0; i < feedCards.size(); ++i) {
				if (i < titles.size()) {
					if (!feedCards.get(i).equals(titles.get(i))) {
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Actual Feed : " + titles.get(i), "FAIL", "Expected Feed : " + feedCards.get(i));
						flag = false;
					}
				} else {
					DriverSession.getLastExecutionReportingInstance().teststepreporting(
							feedCards.get(i)+" Feed is not appearing", "FAIL", "Verifying Feed Sequence" );
					flag = false;
				}
			}
			if(flag) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feeds sequence verified successfully", "PASS",
						"Verifying Feed Sequence");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying carousel sequence", "FAIL",
					"Carousel Sequence should be verified");
		}
	}

	public String getDescriptionOfCurrentCard() {
		element = IOSAppLocators.getInstance().getCardDescriptionFromHomeScreen(driver);
		return element.getAttribute("name");
	}

	public String getCardTypeOfCurrentCard() {
		element = IOSAppLocators.getInstance().getCardTypeFromHomeScreen(driver);
		return element.getAttribute("name");
	}

	public void verifyFeedSection(String feed) {
		try {
			element = IOSAppLocators.getInstance().fetFirstFeedSection(driver);
			String feedTitle = element.getAttribute("name").trim();
			if (feedTitle.equals(feed))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feed verified successfully",
						"PASS", "Verifying created feed in the feed section");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Created Feed do not appears",
						"FAIL", "Verifying created feed in the feed section");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured while verifying feed", "FAIL", "Verifying created feed in the feed section");
		}
	}

	public boolean checkLoggedInState(boolean logIfProfile) {
		try {
			Keywords.waitForPage(driver, 10);
			element = IOSAppLocators.getInstance().getMenu(driver, "Profile");
			WebElement currentScreen = IOSAppLocators.getInstance().getCurrenScreen(driver);
			String screenName = Keywords.getAttributeVal(currentScreen, "label");
			Keywords.click(element);
			element = IOSAppLocators.getInstance().getMyProfileHeader(driver);
			element = IOSAppLocators.getInstance().getMenu(driver, screenName);
			Keywords.click(element);
			return true;
		} catch (Exception e) {
			if (!logIfProfile) {
				try {
					element = IOSAppLocators.getInstance().getCrossOnLogin(driver);
					Keywords.click(element);
				} catch (Exception e2) {
				}
			}
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyStatusBarFor(boolean expected) {
		try {
			Keywords.waitForPage(driver, 5);
			element = IOSAppLocators.getInstance().getStatusBar(driver);
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is appearing",
						"PASS", "Status Logo bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is appearing",
						"FAIL", "Status Logo bar should not appear");
		} catch (Exception e) {
			if (expected)
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is not appearing",
						"FAIL", "Status Logo bar should appear");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Status Logo bar is not appearing",
						"PASS", "Status Logo bar should not appear");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyCTASection(int row, List<String> titles) {
		try {
			boolean flag = true;
			List<WebElement> cardsCTA = IOSAppLocators.getInstance().getALLCTACard(driver);
			if (cardsCTA.size() == (row * 3)) {
				element = IOSAppLocators.getInstance().getCTAFromIndex(driver, 1);
				Keywords.scrollVerticalOverElement(element);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Count : <b>" + cardsCTA.size() + "</b> verified successfully", "PASS",
						"Verify count of CTA Card");
				for (int i = 1; i <= (row * 3); ++i) {
					element = IOSAppLocators.getInstance().getCTAFromIndex(driver, i);
					String CTATitle = element.getAttribute("name").trim();
					if (!titles.get(i - 1).equals(CTATitle)) {
						flag = false;
						DriverSession.getLastExecutionReportingInstance().teststepreporting(
								"Card : <b>" + titles.get(i - 1) + "</b> do not appears", "FAIL", "Verify CTA Cards");
					}
				}
				if (flag) {
					DriverSession.getLastExecutionReportingInstance()
							.teststepreporting("All CTA Cards verified successfully", "PASS", "Verify CTA Cards");
				}
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Card Count do not match", "FAIL",
						"Verify count of CTA Card");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured while verifying CTA Cards", "FAIL", "Verify CTA Cards");
		}
	}
}
