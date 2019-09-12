package Topfan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.GlobalParam;
import com.utilities.Keywords;

import action.Topfan.CommonAppAction;

public class CMS {

	WebDriver driver;
	WebElement element;
	public static LinkedHashMap<String, LinkedHashMap<String, String>> allCardDetails = new LinkedHashMap<String, LinkedHashMap<String, String>>();
	LinkedHashMap<String, String> cardDetails;
	public List<String> enabledFeedIDs, CTACards;
	public String baseUrl, feedTitle;
	private boolean mainFeedState, hamburgerIconState, cmsLaunchState = false, flagFeed = true;
	private String[] feedTitles;
	private boolean flagHamburger = true;
	private boolean tempFeedState, flagTempFeed = true;
	private boolean isHeaderLogoCheckboxPresent = false;
	private boolean headerLogoCheckboxState, flagHeaderLogoCheckbox = true;
	private int socialIdentityRow;
	private boolean cardEnabledState, flagCardEnabled = true;
	private boolean cardFeaturedState, flagCardFeatured = true;
	private AccessLevel minAccessLevel;
	private boolean coinAccessState;

	public CMS(String browserName) {
		if (!cmsLaunchState) {
			switch (browserName.toLowerCase()) {
			case "chrome":
				String driverPath = System.getProperty("user.dir") + GlobalParam.slash + "libs";
				System.setProperty("webdriver.chrome.driver", driverPath + GlobalParam.slash + "chromedriver");
				driver = new ChromeDriver();
				break;
			case "firefox":
			default:
				driver = new FirefoxDriver();
				break;
			}
			driver.manage().window().maximize();
			baseUrl = CommonAppAction.masterProp.getProperty("baseUrl");
		}
	}

	public void navigateToEditHomeScreen() {
		driver.get(baseUrl + "/clients/19/home_screen/edit");
	}

	public void login(String username, String password) {
		if (!cmsLaunchState) {
			driver.get(baseUrl);
			element = CMSLoactors.getInstance().emailFieldCMS(driver);
			Keywords.typeText(element, username);
			element = CMSLoactors.getInstance().passwordFieldCMS(driver);
			Keywords.typeText(element, password);
			element = CMSLoactors.getInstance().loginButtonCMS(driver);
			Keywords.click(element);
			cmsLaunchState = true;
		}
	}

	public void closeCMS() {
		if (cmsLaunchState == true) {
			driver.quit();
			cmsLaunchState = false;
		}
	}

	public void navigateToEditCarouselByCardID(String cardID) {
		driver.get(baseUrl + "/clients/19/carousel_feeds/" + cardID + "/edit");
	}

	public void navigateFromBaseURL(String url) {
		driver.get(baseUrl + url);
	}

	public void navigateToCreateNewCarousel(String url) {
		driver.get(url + "/new");
	}

	public void navigateToEditCardUrl(String url) {
		driver.get(baseUrl + url + "/edit");
	}

	public void navigateToClientHome() {
		driver.get(baseUrl + "/clients/19");
	}

	public void navigateFromCurrentToSection(String url) {
		driver.get(driver.getCurrentUrl() + "/" + url);
	}

	public void removeAllCardsFromCarousel() {
		try {
			navigateToEditHomeScreen();
			List<WebElement> elements = CMSLoactors.getInstance().getAllCardsFromCMS(driver);
			if (elements.size() != 0) {
				List<String> cardIDs = new ArrayList<String>();
				for (WebElement card : elements) {
					cardIDs.add(card.getAttribute("id").replace("carousel_feed_", ""));
				}
				for (String cardID : cardIDs) {
					navigateToEditCarouselByCardID(cardID);
					element = CMSLoactors.getInstance().showCardOnScreenFromCMS(driver);
					if (element.isSelected())
						Keywords.click(element);
					element = CMSLoactors.getInstance().updateCarouselButtonOnCMS(driver);
					Keywords.click(element);
				}
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Exception Occured...while removing all cards", "PASS",
						"All types of carousel card should be removed from CMS");
			}
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"All card successfully removed from CMS", "FAIL",
					"All types of carousel card should be removed from CMS");
		}
	}

	public Map<CarouselType, String> getAllCarouselURLs() {
		List<CarouselType> carousels = Arrays.asList(CarouselType.values());
		Map<CarouselType, String> carouselUrls = new LinkedHashMap<CarouselType, String>();
		for (CarouselType carousel : carousels) {
			element = CMSLoactors.getInstance().getURLFromCarousel(driver, carousel);
			carouselUrls.put(carousel, element.getAttribute("href"));
		}
		return carouselUrls;
	}

	public void addAllTypesOfCard() {
		Map<CarouselType, String> carouselUrls = getAllCarouselURLs();
		for (CarouselType carousel : carouselUrls.keySet()) {
			String url = carouselUrls.get(carousel);
			navigateFromBaseURL(url);
			element = CMSLoactors.getInstance().getFirstCardFromCarousel(driver);
			String cardUrl = element.getAttribute("href");
			navigateToEditCardUrl(cardUrl);
			element = CMSLoactors.getInstance().showCardOnScreenFromCMS(driver);
			if (!element.isSelected())
				Keywords.click(element);
		}
	}

	private void fillTitleAndDescription(String name) {
		String randomData = Keywords.getRandomData();
		cardDetails = new LinkedHashMap<String, String>();
		element = CMSLoactors.getInstance().getTitleFromAddCarousel(driver);
		String title = name + "Title" + randomData;
		Keywords.typeText(element, title);
		cardDetails.put("title", title);
		element = CMSLoactors.getInstance().getDescriptionFromAddCarousel(driver);
		String desc = name + "Desc" + randomData;
		Keywords.typeText(element, desc);
		cardDetails.put("description", desc);
	}

	private String getDateToEnter(String date, int value) throws ParseException {
		Date currentDate = new Date();
		Date finalDate;
		Calendar c = new GregorianCalendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		if (date.equals("auto")) {
			c.setTime(currentDate);
			c.add(Calendar.DATE, value);
			finalDate = c.getTime();
			Keywords.typeText(element, format.format(finalDate));
		} else {
			finalDate = format.parse(date);
		}
		date = format.format(finalDate);
		return date;
	}

	public void createChallengeTypeCard() {
		try {
			driver.get(baseUrl + "/brands/8/challenges/new");
			fillTitleAndDescription("Challenge");
			element = CMSLoactors.getInstance().getChallengeBGColorFromAddCarousel(driver);
			Keywords.typeText(element, CommonAppAction.masterProp.getProperty("challenge_BG_Color"));
			element = CMSLoactors.getInstance().getChallengePointValueFromAddCarousel(driver);
			Keywords.typeText(element, CommonAppAction.masterProp.getProperty("challenge_Point_value"));
			element = CMSLoactors.getInstance().getChallengeTotalCompletionFromAddCarousel(driver);
			Keywords.typeText(element, CommonAppAction.masterProp.getProperty("challenge_Total_Completion"));
			element = CMSLoactors.getInstance().getChallengeCompletionPerUserFromAddCarousel(driver);
			Keywords.typeText(element, CommonAppAction.masterProp.getProperty("challenge_Completion_Per_User"));
			element = CMSLoactors.getInstance().getChallengeStartDateFromAddCarousel(driver);
			String strtDate = CommonAppAction.masterProp.getProperty("challenge_Start_Date");
			Keywords.typeText(element, getDateToEnter(strtDate, -1));
			element = CMSLoactors.getInstance().getChallengeEndDateFromAddCarousel(driver);
			String endDate = CommonAppAction.masterProp.getProperty("challenge_End_Date");
			Keywords.typeText(element, getDateToEnter(endDate, 1));
			String client = CommonAppAction.masterProp.getProperty("challenge_Card_Client");
			element = CMSLoactors.getInstance().getChallengeClientAddCarousel(driver, client);
			Keywords.click(element);
			element = CMSLoactors.getInstance().createButtonFromAddCarousel(driver);
			Keywords.click(element);
			Thread.sleep(5000L);
			cardDetails.put("cardUrl", Keywords.getCurrentUrl(driver));
			allCardDetails.put("Challenges", cardDetails);
			driver.get(baseUrl + "/clients/19/client_challenges");
			String title = cardDetails.get("title");
			int attempt = 0, start = 0, end = 500;
			while (attempt < 10) {
				try {
					Keywords.waitForPage(driver, 5);
					element = CMSLoactors.getInstance().getViewFromChallengesPage(driver, title);
					break;
				} catch (Exception e) {

					Keywords.scrollDownPixels(driver, start, end);
					start = end;
					end = start + 500;
					attempt++;
				}
			}
			Keywords.waitForPage(driver, 60);
			driver.get(element.getAttribute("href") + "/edit");
			cardDetails.put("editCardUrl", driver.getCurrentUrl());
			element = CMSLoactors.getInstance().showCardOnScreenFromCMS(driver);
			Keywords.click(element);
			element = CMSLoactors.getInstance().getIsEnabledCheckbox(driver);
			element.click();
			element = CMSLoactors.getInstance().createButtonFromAddCarousel(driver);
			Keywords.click(element);
			Thread.sleep(10000L);
		} catch (Exception e) {
			e.printStackTrace();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add Challenge type carousel",
					"FAIL", "All types of carousel card should be added from CMS");
		}
	}

	public void createAllTypesOfCard() {
		createChallengeTypeCard();
		navigateToClientHome();
		Boolean flag = true;
		Map<CarouselType, String> carouselUrls = getAllCarouselURLs();
		for (CarouselType carousel : carouselUrls.keySet()) {
			try {
				String url = carouselUrls.get(carousel);
				navigateToCreateNewCarousel(url);
				fillTitleAndDescription(carousel.name());
				switch (carousel) {
				case Audio:
					break;
				case Videos:
					element = CMSLoactors.getInstance().getVideoURLFromAddCarousel(driver);
					Keywords.typeText(element, CommonAppAction.masterProp.getProperty("video_Card_Url"));
					break;
				case GIFs:
					element = CMSLoactors.getInstance().getGIFImageFromAddCarousel(driver);
					Keywords.typeText(element, System.getProperty("user.dir") + GlobalParam.slash + "TestRepository"
							+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "GIFs.gif");
					break;
				case Virtual:
				case Comics:
				case Articles:
				case Rewards:
				case Merchandise:
					if (Arrays.asList(CarouselType.Merchandise, CarouselType.Articles, CarouselType.Comics)
							.contains(carousel)) {
						if (carousel == CarouselType.Merchandise) {
							element = CMSLoactors.getInstance().getProductPriceFromAddCarousel(driver);
							Keywords.typeText(element, CommonAppAction.masterProp.getProperty("product_Card_price"));
						}
						element = CMSLoactors.getInstance().getURLFromAddCarousel(driver);
						Keywords.typeText(element, CommonAppAction.masterProp.getProperty("url_all_card"));
					} else if (carousel == CarouselType.Rewards) {
						element = CMSLoactors.getInstance().getRewardPointCostFromAddCarousel(driver);
						Keywords.typeText(element, CommonAppAction.masterProp.getProperty("reward_Point_Cost"));
						element = CMSLoactors.getInstance().getStockWarningQtyFromAddCarousel(driver);
						Keywords.typeText(element, CommonAppAction.masterProp.getProperty("reward_Stock_Warning_Qty"));
					} else {
						element = CMSLoactors.getInstance().getVirtualURLFromAddCarousel(driver);
						Keywords.typeText(element, CommonAppAction.masterProp.getProperty("virtual_Card_Url"));
					}
				default:
					element = CMSLoactors.getInstance().getZoomedImageFromAddCarousel(driver);
					element = CMSLoactors.getInstance().getZoomedImageOnId(driver, element.getAttribute("id"));
					Keywords.typeText(element, GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
							+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + carousel.name() + ".jpg");
					element = CMSLoactors.getInstance().getFeedImageCheckBoxFromAddCarousel(driver);
					Keywords.click(element);
					break;
				}
				element = CMSLoactors.getInstance().showCardOnScreenFromCMS(driver);
				Keywords.click(element);
				element = CMSLoactors.getInstance().createButtonFromAddCarousel(driver);
				Keywords.click(element);
				cardDetails.put("cardUrl", Keywords.getCurrentUrl(driver));
				allCardDetails.put(carousel.name(), cardDetails);
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to add " + carousel + " type carousel", "FAIL",
						"All types of carousel card should be added");

			}
		}
		if (flag) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"All types of card successfully added. Total: " + allCardDetails.size(), "PASS",
					"All types of carousel card should be added from CMS");
		}
	}

	public void destroyAllAddedCards() {
		Boolean flag = true;
		for (String cardDetails : allCardDetails.keySet()) {
			try {
				String url = allCardDetails.get(cardDetails).get("cardUrl");
				driver.get(url);
				element = CMSLoactors.getInstance().destroyButtonForCard(driver);
				Keywords.click(element);
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				flag = false;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to remove card type: " + cardDetails + ", card title:"
								+ allCardDetails.get(cardDetails).get("title"),
						"FAIL", "All " + allCardDetails.size() + " added carousel card should be removed");
			}
		}
		if (flag)
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"All types of card successfully removed from CMS", "PASS",
					"All " + allCardDetails.size() + " added carousel card should be removed");
	}

	public int getCarouselCardsCount() {
		navigateToEditHomeScreen();
		int size = CMSLoactors.getInstance().getCarouselsFromHomeScreen(driver).size();
		return size;
	}

	public int getFeedCardsCount() {
		navigateToClientHome();
		navigateFromCurrentToSection("featured_feeds");
		int size = CMSLoactors.getInstance().getFeedsFromHomeScreen(driver).size();
		return size;
	}

	private void disableAllFeed() {
		enabledFeedIDs = new ArrayList<String>();
		List<String> feedID = new ArrayList<String>();
		List<WebElement> feeds = CMSLoactors.getInstance().getAllFeeds(driver);
		for (WebElement feed : feeds) {
			feedID.add(feed.getAttribute("href"));
		}
		for (String id : feedID) {
			driver.get(id + "/edit");
			element = CMSLoactors.getInstance().getFeatureFeed(driver);
			if (element.isSelected()) {
				enabledFeedIDs.add(id);
				Keywords.click(element);
			}
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
	}

	public void showMainFeed(boolean b) {
		navigateToEditHomeScreen();
		element = CMSLoactors.getInstance().getMainFeedCheckbox(driver);
		boolean change = false;
		if (b) {
			if (flagFeed) {
				if (element.isSelected()) {
					mainFeedState = false;
					Keywords.click(element);
					change = true;
					flagFeed = false;
				} else {
					mainFeedState = true;
				}
			} else {
				Keywords.click(element);
				change = true;
				flagFeed = true;
			}
		} else {
			if (flagFeed) {
				if (element.isSelected()) {
					mainFeedState = false;
				} else {
					mainFeedState = true;
					Keywords.click(element);
					change = true;
					flagFeed = false;
				}
			} else {
				Keywords.click(element);
				change = true;
				flagFeed = true;
			}
		}
		if (change) {
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
	}

	public String addFeedTopic() {
		try {
			navigateToClientHome();
			navigateFromCurrentToSection("featured_feeds");
			disableAllFeed();
			showMainFeed(false);
			navigateFromBaseURL("/clients/19/featured_feeds/new");
			element = CMSLoactors.getInstance().getFeedTitle(driver);
			feedTitle = "Feed" + Keywords.getRandomData();
			Keywords.typeText(element, feedTitle);
			element = CMSLoactors.getInstance().getFeedHeroImage(driver);
			Keywords.typeText(element, System.getProperty("user.dir") + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "FeedHero.jpg");
			element = CMSLoactors.getInstance().getFeedAvatarImage(driver);
			Keywords.typeText(element, System.getProperty("user.dir") + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "FeedAvatar.jpg");
			element = CMSLoactors.getInstance().getContentTypeFilterCheckbox(driver);
			Keywords.click(element);
			element = CMSLoactors.getInstance().getCreateFeed(driver);
			Keywords.click(element);
			element = CMSLoactors.getInstance().getFeedWithTitle(driver, feedTitle);
			return Keywords.getAttributeVal(element, "href");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to add a feed topic", "FAIL",
					"Feed topic must be added");
			throw e;
		}
	}

	public void reverseFeedChanges() {
		for (String id : enabledFeedIDs) {
			driver.get(id + "/edit");
			element = CMSLoactors.getInstance().getFeatureFeed(driver);
			Keywords.click(element);
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
		reverseMainFeedState();
	}

	public void deleteFeed(String id) {
		driver.get(id);
		element = CMSLoactors.getInstance().destroyButtonForCard(driver);
		Keywords.click(element);
		driver.switchTo().alert().accept();
	}

	public void addCTACard(int row) throws InterruptedException {
		CTACards = new ArrayList<String>();
		String ctaTitle;
		element = CMSLoactors.getInstance().getCTASize(driver);
		Keywords.selectText(element, "0x0");
		Alert a = new WebDriverWait(driver, 2).until(ExpectedConditions.alertIsPresent());
		if (a != null)
			driver.switchTo().alert().accept();
		Keywords.selectText(element, row + "x3");
		for (int i = 0; i < (row * 3); ++i) {
			element = CMSLoactors.getInstance().getCTATitle(driver, ((4 * i) + 1));
			ctaTitle = "CTATitle" + i;
			Keywords.typeText(element, ctaTitle);
			CTACards.add(ctaTitle);
			element = CMSLoactors.getInstance().getCTAImage(driver, ((4 * i) + 1));
			Keywords.typeText(element, GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "CTAImage.jpg");
			element = CMSLoactors.getInstance().getCTAContentTypeRadioBtn(driver, ((2 * i) + 1));
			Keywords.click(element);
			element = CMSLoactors.getInstance().getCTAContentTypeField(driver, ((2 * i) + 1));
			Keywords.selectByIndex(element, Keywords.getRandomInteger(14) + 1);
		}
		element = CMSLoactors.getInstance().getUpdate(driver);
		Keywords.click(element);
	}

	public void activateStatusBar() {
		element = CMSLoactors.getInstance().getStatusBar(driver);
		if (!element.isSelected()) {
			Keywords.click(element);
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
	}

	public ArrayList<String> getHSCarouselCardDetails() {
		int count = getCarouselCardsCount();
		ArrayList<String> carouselDetails = new ArrayList<String>();
		for (int i = 1; i <= count; ++i) {
			element = CMSLoactors.getInstance().getHSCarouselCard(driver, i);
			String title = Keywords.getText(element);
			carouselDetails.add(title.substring(title.indexOf(":") + 2));
		}
		return carouselDetails;
	}

	public ArrayList<String> getHSFeedCardDetails() {
		int count = getFeedCardsCount();
		ArrayList<String> feedDetails = new ArrayList<String>();
		String url = driver.getCurrentUrl();
		for (int i = 1; i <= count; ++i) {
			element = CMSLoactors.getInstance().getHSFeedCard(driver, i);
			String title = Keywords.getText(element);
			Keywords.click(element);
			navigateFromCurrentToSection("edit");
			element = CMSLoactors.getInstance().getFeatureFeed(driver);
			if (element.isSelected())
				feedDetails.add(title);
			driver.navigate().to(url);
		}
		return feedDetails;
	}

	public void reverseMainFeedState() {
		showMainFeed(mainFeedState);
	}

	// Aakar's code for Android - Could be refine

	public ArrayList<String> getCarouselSequence() {
		navigateToEditHomeScreen();
		ArrayList<String> cardsOnCarousel = new ArrayList<String>();
		List<WebElement> elements = CMSLoactors.getInstance().getCarouselsFromHomeScreen(driver);
		for (WebElement element : elements) {
			element = CMSLoactors.getInstance().getCarouselItem(DriverSession.getLastExecutionDriver(), element);
			cardsOnCarousel.add(element.getText());
		}
		return cardsOnCarousel;
	}

	public String[] addFeedTopics(int feedCount) {
		navigateToClientHome();
		navigateFromCurrentToSection("featured_feeds");
		disableAllFeed();
		String[] feedIDs = new String[feedCount];
		feedTitles = new String[feedCount];
		for (int i = 0; i < feedCount; i++) {
			navigateFromBaseURL("/clients/19/featured_feeds/new");
			element = CMSLoactors.getInstance().getFeedTitle(driver);
			String newFeedTitle = "Feed" + Keywords.getRandomData();
			feedTitles[i] = newFeedTitle;
			Keywords.typeText(element, newFeedTitle);
			element = CMSLoactors.getInstance().getFeedHeroImage(driver);
			Keywords.typeText(element, System.getProperty("user.dir") + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "FeedHero.jpg");
			element = CMSLoactors.getInstance().getFeedAvatarImage(driver);
			Keywords.typeText(element, System.getProperty("user.dir") + GlobalParam.slash + "TestRepository"
					+ GlobalParam.slash + "TopfanImages" + GlobalParam.slash + "FeedAvatar.jpg");
			element = CMSLoactors.getInstance().getCreateFeed(driver);
			Keywords.click(element);
			element = CMSLoactors.getInstance().getFeedWithTitle(driver, newFeedTitle);
			feedIDs[i] = Keywords.getAttributeVal(element, "href");
		}

		return feedIDs;
	}

	public String[] getFeedTitles() {
		return feedTitles;
	}

	public void showHamburgerIcon(boolean b, boolean reverse) {
		navigateFromBaseURL("/clients/19/edit");
		element = CMSLoactors.getInstance().getHamburgerIconCheckBox(driver);
		boolean change = false;
		if (b) {
			if (flagHamburger) {
				if (element.isSelected()) {
					hamburgerIconState = true;
				} else {
					hamburgerIconState = false;
					Keywords.click(element);
					change = true;
					flagHamburger = false;
				}
			} else {
				Keywords.click(element);
				flagHamburger = true;
				change = true;
			}
		} else {
			if (flagHamburger) {
				if (element.isSelected()) {
					hamburgerIconState = true;
					Keywords.click(element);
					change = true;
					flagHamburger = false;
				} else {
					hamburgerIconState = false;
				}
			} else {
				Keywords.click(element);
				flagHamburger = true;
				change = true;
			}
		}
		try {
			element = CMSLoactors.getInstance().getHeaderLogoCheckbox(driver);
			isHeaderLogoCheckboxPresent = true;
			if (reverse) {
				if (enableHeaderLogoCheckbox(headerLogoCheckboxState)) {
					change = true;
				}
			} else {
				if (enableHeaderLogoCheckbox(true)) {
					change = true;
				}
			}

		} catch (Exception e) {
			isHeaderLogoCheckboxPresent = false;
		}
		if (change) {
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
	}

	public boolean enableHeaderLogoCheckbox(boolean b) {
		if (isHeaderLogoCheckboxPresent) {
			element = CMSLoactors.getInstance().getHeaderLogoCheckbox(driver);
			boolean change = false;
			if (b) {
				if (flagHeaderLogoCheckbox) {
					if (element.isSelected()) {
						headerLogoCheckboxState = true;
					} else {
						headerLogoCheckboxState = false;
						Keywords.click(element);
						change = true;
						flagHeaderLogoCheckbox = false;
					}
				} else {
					Keywords.click(element);
					flagHeaderLogoCheckbox = true;
					change = true;
				}
			} else {
				if (flagHeaderLogoCheckbox) {
					if (element.isSelected()) {
						headerLogoCheckboxState = true;
						Keywords.click(element);
						change = true;
						flagHeaderLogoCheckbox = false;
					} else {
						headerLogoCheckboxState = false;
					}
				} else {
					Keywords.click(element);
					flagHeaderLogoCheckbox = true;
					change = true;
				}
			}
			return change;
		} else {
			return false;
		}
	}

	public void reverseHamburgerIconState() {
		showHamburgerIcon(hamburgerIconState, true);
	}

	public String enableFeedTopic(boolean b) {
		navigateFromBaseURL("/clients/19/featured_feeds");
		element = CMSLoactors.getInstance().getFirstFeedTopic(driver);
		String feedTopic = element.getText();
		Keywords.click(element);
		element = CMSLoactors.getInstance().getEditFeedButton(driver);
		Keywords.click(element);
		showTempFeed(b);
		return feedTopic;
	}

	public void showTempFeed(boolean b) {
		element = CMSLoactors.getInstance().getFeatureFeed(driver);
		boolean change = false;
		if (b) {
			if (flagTempFeed) {
				if (element.isSelected()) {
					tempFeedState = true;
				} else {
					tempFeedState = false;
					Keywords.click(element);
					change = true;
					flagTempFeed = false;
				}
			} else {
				Keywords.click(element);
				flagTempFeed = true;
				change = true;
			}
		} else {
			if (flagTempFeed) {
				if (element.isSelected()) {
					tempFeedState = true;
					Keywords.click(element);
					change = true;
					flagTempFeed = false;
				} else {
					tempFeedState = false;
				}
			} else {
				Keywords.click(element);
				flagTempFeed = true;
				change = true;
			}
		}
		if (change) {
			element = CMSLoactors.getInstance().getUpdate(driver);
			Keywords.click(element);
		}
	}

	public void reverseTempFeedState() {
		enableFeedTopic(tempFeedState);
	}

	public String setCardAccess(String cardType, AccessLevel tempAccessLevel, boolean reverse) {
		String url = null;
		String itemLocator = null;
		switch (cardType.toLowerCase().trim()) {
		case "videos":
			url = "/clients/19/videos";
			itemLocator = CMSLoactors.getInstance().getVideoLocator();
			break;
		case "audio":
			url = "/clients/19/audio_tracks";
			itemLocator = CMSLoactors.getInstance().getAudioLocator();
			break;
		case "articles":
			url = "/clients/19/articles";
			itemLocator = CMSLoactors.getInstance().getArticleLocator();
			break;
		case "challenges":
			url = "/clients/19/client_challenges";
			itemLocator = CMSLoactors.getInstance().getChallengeLocator();
			break;
		case "product":
			url = "/clients/19/products";
			itemLocator = CMSLoactors.getInstance().getProductLocator();
			break;
		case "rewards":
			url = "/clients/19/rewards";
			itemLocator = CMSLoactors.getInstance().getRewardLocator();
			break;
		case "social":
			url = "/clients/19/social_identities";
			itemLocator = CMSLoactors.getInstance().getSocialLocator();
			break;
		case "discussions":
			url = "/clients/19/discussions";
			itemLocator = CMSLoactors.getInstance().getDiscussionLocator();
			break;
		case "photos":
			url = "/clients/19/photos";
			itemLocator = CMSLoactors.getInstance().getPhotoLocator();
			break;
		case "comic":
			url = "/clients/19/comics";
			itemLocator = CMSLoactors.getInstance().getComicLocator();
			break;
		case "polls":
			url = "/clients/19/polls";
			itemLocator = CMSLoactors.getInstance().getPollLocator();
			break;
		case "quizzes":
			url = "/clients/19/quizzes";
			itemLocator = CMSLoactors.getInstance().getQuizLocator();
			break;
		case "gif":
			url = "/clients/19/gifs";
			itemLocator = CMSLoactors.getInstance().getGifLocator();
			break;
		case "virtual reality":
			url = "/clients/19/virtual_realities";
			itemLocator = CMSLoactors.getInstance().getVirtualRealityLocator();
			break;
		default:
			break;
		}
		if (url != null) {
			navigateFromBaseURL(url);
			if (cardType.toLowerCase().trim().equals("social")) {
				socialIdentityRow = clickSocialRowWithNonZeroItems();
			}
		}
		String cardTitle;
		if (cardType.toLowerCase().trim().equals("challenges")) {
			element = CMSLoactors.getInstance().getFirstItemFromChallengeTable(driver);
			cardTitle = element.getText();
			element = CMSLoactors.getInstance().getFirstItemFromTable(driver, itemLocator);
		} else {
			element = CMSLoactors.getInstance().getFirstItemFromTable(driver, itemLocator);
			cardTitle = element.getText();
		}

		element.click();
		navigateToEditCardUrl(driver.getCurrentUrl().trim().substring(28));
		if (!reverse) {
			boolean change = false;
			if (enableCard(true)) {
				change = true;
			}
			if (featureCard(true)) {
				change = true;
			}
			if (setCardAccessCheckbox(tempAccessLevel)) {
				change = true;
			}
			if (change) {
				element = CMSLoactors.getInstance().getUpdate(driver);
				Keywords.click(element);
			}
		} else {
			boolean change = false;
			if (enableCard(cardEnabledState)) {
				change = true;
			}
			if (featureCard(cardFeaturedState)) {
				change = true;
			}
			if (revertCardAccessCheckbox(tempAccessLevel)) {
				change = true;
			}
			if (change) {
				element = CMSLoactors.getInstance().getUpdate(driver);
				Keywords.click(element);
			}
		}
		return cardTitle;
	}

	private boolean revertCardAccessCheckbox(AccessLevel tempAccessLevel) {
		boolean change = false;
		if (setCoinAccess(coinAccessState)) {
			change = true;
		}
		if (minAccessLevel != null) {
			if (!minAccessLevel.equals(tempAccessLevel)) {

				element = getAccessLevelCheckboxButton(tempAccessLevel);
				if (element.isSelected()) {
					Keywords.click(element);
					change = true;
				}

				element = getAccessLevelCheckboxButton(minAccessLevel);
				if (!element.isSelected()) {
					Keywords.click(element);
					change = true;
				}
			}

		} else {
			element = getAccessLevelCheckboxButton(tempAccessLevel);
			if (element.isSelected()) {
				Keywords.click(element);
				change = true;
			}
		}
		return change;
	}

	private boolean setCardAccessCheckbox(AccessLevel tempAccessLevel) {
		boolean change = false;
		if (setCoinAccess(false)) {
			change = true;
		}
		minAccessLevel = getAccessLevel();
		if (minAccessLevel != null && !minAccessLevel.equals(tempAccessLevel)) {
			change = true;
		}

		element = getAccessLevelCheckboxButton(tempAccessLevel);
		if (element != null) {
			if (!element.isSelected()) {
				Keywords.click(element);
				if (minAccessLevel != tempAccessLevel) {
					change = true;
				}
			}
		}
		return change;
	}

	private boolean setCoinAccess(boolean b) {
		boolean change = false;
		element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 6);
		if (b) {
			if (!element.isSelected()) {
				coinAccessState = false;
				Keywords.click(element);
				change = true;
			}
		} else {
			if (element.isSelected()) {
				coinAccessState = true;
				Keywords.click(element);
				change = true;
			}
		}
		return change;
	}

	private WebElement getAccessLevelCheckboxButton(AccessLevel tempAccessLevel) {
		WebElement element = null;
		switch (tempAccessLevel) {
		case Bronze:
			element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 5);
			break;
		case Silver:
			element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 4);
			break;
		case Gold:
			element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 3);
			break;
		case Platinum:
			element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 2);
			break;
		case Vip:
			element = CMSLoactors.getInstance().getSingleAccessLevelCheckbox(driver, 1);
		default:
			break;
		}
		return element;
	}

	private AccessLevel getAccessLevel() {
		List<WebElement> elements = CMSLoactors.getInstance().getAccessLevelCheckboxes(driver);
		for (int i = 4; i >= 0; i--) {
			element = elements.get(i);
			if (element.isSelected()) {
				Keywords.click(element);
				if (minAccessLevel == null) {
					return AccessLevel.values()[i];
				}
			}
		}
		return null;
	}

	private boolean enableCard(boolean b) {
		element = CMSLoactors.getInstance().getCardIsEnabledCheckbox(driver);
		boolean change = false;
		if (b) {
			if (flagCardEnabled) {
				if (element.isSelected()) {
					cardEnabledState = true;
				} else {
					cardEnabledState = false;
					Keywords.click(element);
					change = true;
					flagCardEnabled = false;
				}
			} else {
				Keywords.click(element);
				flagCardEnabled = true;
				change = true;
			}
		} else {
			if (flagCardEnabled) {
				if (element.isSelected()) {
					cardEnabledState = true;
					Keywords.click(element);
					change = true;
					flagCardEnabled = false;
				} else {
					cardEnabledState = false;
				}
			} else {
				Keywords.click(element);
				flagCardEnabled = true;
				change = true;
			}
		}
		return change;
	}

	private boolean featureCard(boolean b) {
		element = CMSLoactors.getInstance().getCardIsFeaturedCheckbox(driver);
		boolean change = false;
		if (b) {
			if (flagCardFeatured) {
				if (element.isSelected()) {
					cardFeaturedState = true;
				} else {
					cardFeaturedState = false;
					Keywords.click(element);
					change = true;
					flagCardFeatured = false;
				}
			} else {
				Keywords.click(element);
				flagCardFeatured = true;
				change = true;
			}
		} else {
			if (flagCardFeatured) {
				if (element.isSelected()) {
					cardFeaturedState = true;
					Keywords.click(element);
					change = true;
					flagCardFeatured = false;
				} else {
					cardFeaturedState = false;
				}
			} else {
				Keywords.click(element);
				flagCardFeatured = true;
				change = true;
			}
		}
		return change;
	}

	private int clickSocialRowWithNonZeroItems() {
		List<WebElement> elements = CMSLoactors.getInstance().getSocialIdentitiesItems(driver);
		for (int i = 0; i < elements.size(); i++) {
			element = elements.get(i);
			if (Integer.valueOf(element.getText()) > 0) {
				Keywords.click(element);
				return ++i;
			}
		}
		return -1;
	}
	// End of Android code from Aakar

	public boolean setFanWallStatus(boolean state) {
		try {
			boolean currentState;
			navigateFromBaseURL("/clients/19/edit");
			element = CMSLoactors.getInstance().getFanWallState(driver);
			if (element.isSelected()) {
				if (!state) {
					element.click();
				}
				currentState = true;
			} else {
				if (state) {
					element.click();
				}
				currentState = false;
			}
			element = CMSLoactors.getInstance().getUpdate(driver);
			element.click();
			return currentState;
		} catch (Exception e) {
			throw e;
		}
	}

	public String changeFanWallText(String newFanWallText) {
		try {
			String currentText;
			navigateFromBaseURL("/clients/19/fan_wall/260/edit");
			element = CMSLoactors.getInstance().getFanWallText(driver);
			currentText = element.getAttribute("value").trim();
			element.clear();
			element.sendKeys(newFanWallText);
			element = CMSLoactors.getInstance().getUpdate(driver);
			element.click();
			return currentText;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean setPhotosLockedState(boolean lockPhotos) {
		try {
			boolean currentState;
			navigateFromBaseURL("/clients/19/edit");
			element = CMSLoactors.getInstance().getPhotosLockedState(driver);
			if (element.isSelected()) {
				if (!lockPhotos) {
					element.click();
				}
				currentState = true;
			} else {
				if (lockPhotos) {
					element.click();
				}
				currentState = false;
			}
			element = CMSLoactors.getInstance().getUpdate(driver);
			element.click();
			return currentState;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void linkChallengeCardToFeedTopic(String editCardUrl) throws Exception{
		try{
			driver.get(editCardUrl);
			element = CMSLoactors.getInstance().getFeedTopicDropdown(driver);
			Keywords.selectByVisibleText(element, feedTitle);
			Thread.sleep(5000L);
			element.sendKeys(Keys.ENTER);
			element = CMSLoactors.getInstance().getCardIsFeaturedCheckbox(driver);
			Keywords.click(element);
			Keywords.click(element);
			element.sendKeys(Keys.ENTER);
			Thread.sleep(10000L);
		}catch(Exception e){
			throw e;
		}
	}
}
