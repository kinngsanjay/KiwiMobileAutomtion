package action.Topfan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import Topfan.CMS;
import Topfan.IOS.FeedScreen;
import Topfan.IOS.ForgotPasswordScreen;
import Topfan.IOS.HomeScreen;
import Topfan.IOS.IOSAppLocators;
import Topfan.IOS.LoginScreen;
import Topfan.IOS.ProfileScreen;
import Topfan.IOS.RegistrationScreen;
import Topfan.IOS.SignInScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class IOSAppAction extends CommonAppAction {

	private String email;

	public WebElement element;

	public IOSAppAction(AppiumDriver<MobileElement> lastExecutionDriver) {
		super(lastExecutionDriver);
	}

	public void login(String userName, String password) {
		Keywords.acceptAlert();
		if (!checkLoggedInState(true)) {
			LoginScreen login = new LoginScreen(DriverSession.getLastExecutionDriver());
			login.clickLoginButton();
			SignInScreen signIn = new SignInScreen(DriverSession.getLastExecutionDriver());
			signIn.enterUsername(userName);
			signIn.enterPassword(password);
			signIn.clickLoginButton();
			Keywords.acceptAlert();
		}
	}

	private boolean checkLoggedInState(boolean logInProfile) {
		HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
		boolean state = home.checkLoggedInState(logInProfile);
		return state;
	}

	public void login() throws Exception {
		String userName = DriverSession.getTestCaseData().get("Username");
		String password = DriverSession.getTestCaseData().get("Password");
		login(userName, password);
		if (checkLoggedInState(false)) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User : <b>" + userName + "</b> successfully logged In", "PASS", "User Should log in");
		} else {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User no able to logged In", "FAIL",
					"User Should log in");
			throw new Exception();
		}
	}

	public void verifyCardsInCarousel(int count) throws Exception {
		HomeScreen home = new HomeScreen(driver);
		Set<String> titles = home.getTitleOfCurrentCard(count);
		Boolean flag = true;
		for (String cardType : CMS.allCardDetails.keySet()) {
			String cardTitle = CMS.allCardDetails.get(cardType).get("title");
			if (!titles.contains(cardTitle)) {
				flag = false;
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						cardTitle + " of " + cardType + " do not appears on screen", "FAIL",
						cardTitle + " of " + cardType + " should appear in carousel");
			}
		}
		if (flag) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"All types of card appears inside carousel", "PASS",
					"All types of cards should appear in carousel");
		}
	}

	public void registerWithoutMandatoryFields() throws Exception {
		Keywords.acceptAlert();
		LoginScreen reg = new LoginScreen(DriverSession.getLastExecutionDriver());
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
				"<b>TESTCASE 1 - REGISTRATION WITHOUT MANDATORY FILEDS</b>");
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		reg.clickRegisterButton();
		RegistrationScreen register = new RegistrationScreen(DriverSession.getLastExecutionDriver());
		register.enterUsername();
		register.enterPassword();
		register.clickGetStartedButton();
		register.verifyMandatoryMsg();
		killApp();
		relaunchApp();
	}

	public void registerWithLowerAge() throws Exception {
		Keywords.acceptAlert();
		LoginScreen reg = new LoginScreen(DriverSession.getLastExecutionDriver());
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
				"<b>TESTCASE 2 - REGISTRATION WITH LOWER AGE THAN ALLOWED</b>");
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		reg.clickRegisterButton();
		RegistrationScreen register = new RegistrationScreen(DriverSession.getLastExecutionDriver());
		register.enterUsername();
		register.enterPassword();
		register.enterLocation();
		register.enterEmail();
		register.selectGender();
		SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
		String dateFormat = format.format(Keywords.getChangedDate(-400));
		String[] dmy = dateFormat.split("-");
		register.selectBirthdate(dmy[0], dmy[1], dmy[2]);
		register.clickGetStartedButton();
		register.verifyLowerAgeMsg();
		killApp();
		relaunchApp();
	}

	public void verifyUserRegisterd() {
		HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
		home.verifyFreshUserLogIn();
	}

	public void registerWithAllowedAge() throws Exception {
		Keywords.acceptAlert();
		LoginScreen reg = new LoginScreen(DriverSession.getLastExecutionDriver());
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
				"<b>TESTCASE 3 - REGISTRATION WITH ALLOWED AGE</b>");
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		reg.clickRegisterButton();
		RegistrationScreen register = new RegistrationScreen(DriverSession.getLastExecutionDriver());
		register.enterUsername();
		register.enterPassword();
		register.enterLocation();
		String email = register.enterEmail();
		register.selectBirthdate("10", "July", "1991");
		register.selectGender();
		register.clickGetStartedButton();
		verifyUserRegisterd();
		writeUserData(email);
		killApp();
		relaunchApp();
	}

	public void registerWithOnlyMandatoryFields() throws Exception {
		Keywords.acceptAlert();
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		LoginScreen reg = new LoginScreen(DriverSession.getLastExecutionDriver());
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
				"<b>TESTCASE 4 - REGISTRATION WITH ONLY MANDATORY FIELDS</b>");
		reg.clickRegisterButton();
		RegistrationScreen register = new RegistrationScreen(DriverSession.getLastExecutionDriver());
		register.enterUsername();
		register.enterPassword();
		email = register.enterEmail();
		register.clickGetStartedButton();
		verifyUserRegisterd();
		killApp();
		relaunchApp();
	}

	public void logOut() throws Exception {
		if (checkLoggedInState(false)) {
			HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
			home.clickOnMenu("Profile");
			ProfileScreen profile = new ProfileScreen(DriverSession.getLastExecutionDriver());
			profile.clickSettigsGear();
			profile.clickLogOut();
		}
	}

	public void verifyForgotPassword() throws Exception {
		Keywords.acceptAlert();
		DriverSession.setReporting(false);
		logOut();
		DriverSession.setReporting(true);
		LoginScreen reg = new LoginScreen(DriverSession.getLastExecutionDriver());
		DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 5 STARTED</b>", "INFO",
				"<b>TESTCASE 5 - VERIFY FORGOT PASSWORD FUNCTIONALITY</b>");
		reg.clickLoginButton();
		SignInScreen signIn = new SignInScreen(DriverSession.getLastExecutionDriver());
		signIn.clickForgotPassword();
		ForgotPasswordScreen fps = new ForgotPasswordScreen(DriverSession.getLastExecutionDriver());
		fps.enterEmail(email);
		fps.clickSubmit();
		String password = topfanChangePassword(email);
		fps.clickDone();
		login(email, password);
	}

	public void verifyAddedFeed() {
		HomeScreen home = new HomeScreen(DriverSession.getLastExecutionDriver());
		home.verifyFeedSection(cms.feedTitle);
	}

	public void verifyFeedSection() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY FEED SECTION ON HOME SCREEN</b>");
			login();
			killApp();
			String feedID = launchAndAddFeed();
			relaunchApp();
			verifyAddedFeed();
			deleteAddedFeed(feedID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCTASection() {
		try {
			Keywords.acceptAlert();
			login();
			killApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY CTA SECTION ON HOME SCREEN</b>");
			for (int row = 1; row <= 4; ++row) {
				addCTACard(row);
				relaunchApp();
				verifyCTACard(row);
				killApp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void verifyCTACard(int row) {
		HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
		screen.verifyCTASection(row, cms.CTACards);
	}

	public void verifyStatusBar() {
		try {
			cms.navigateToEditHomeScreen();
			cms.activateStatusBar();
			relaunchApp();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFY PRESENCE OF STATUS BAR</b>");
			if (checkLoggedInState(false)) {
				DriverSession.setReporting(false);
				logOut();
				LoginScreen ls = new LoginScreen(DriverSession.getLastExecutionDriver());
				ls.clickSkipForNow();
				DriverSession.setReporting(true);
			}
			HomeScreen screen = new HomeScreen(DriverSession.getLastExecutionDriver());
			screen.verifyStatusBarFor(true);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - VERIFY ABSENCE OF STATUS BAR</b>");
			DriverSession.setReporting(false);
			screen.clickOnMenu("Profile");
			login();
			DriverSession.setReporting(true);
			screen.verifyStatusBarFor(false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cms.closeCMS();
		}
	}

	public void verifyCarousel() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY CARDS ON CAROUSEL</b>");
			login();
			killApp();
			int cardCount = addCardsInCarousel();
			relaunchApp();
			verifyCardsInCarousel(cardCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cms.destroyAllAddedCards();
			cms.closeCMS();
		}
	}

	public void verifyCarouselSequence() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY SEQUENCE OF CARDS IN CAROUSEL</b>");
			login();
			killApp();
			ArrayList<String> carouselCards = getHomeScreenCarouselCards();
			relaunchApp();
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifySequenceInCarousel(carouselCards);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cms.closeCMS();
		}
	}

	public void verifyFeedSequence() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY SEQUENCE OF FEEDS IN HOMESCREEN</b>");
			login();
			killApp();
			cms.showMainFeed(false);
			ArrayList<String> feedCards = getHomeScreenFeedCards();
			relaunchApp();
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifySequenceInFeed(feedCards);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cms.reverseMainFeedState();
			cms.closeCMS();
		}
	}

	public void verifyAllCardsFromFeed() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY APPEARANCE OF ALL TYPES OF CARDS IN FORUM FEED</b>");
			login();
			FeedScreen fs = new FeedScreen(DriverSession.getLastExecutionDriver());
			fs.clickOnMenu(2);
			fs.verifyAllSectionForCards();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLikeFromFeed() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY LIKE BUTTON ON FORUM FEED</b>");
			logOut();
			readLoginDetails();
			String username = DriverSession.getUserName();
			String password = DriverSession.getPassword();
			login(username, password);
			FeedScreen fs = new FeedScreen(DriverSession.getLastExecutionDriver());
			fs.clickOnMenu(2);
			fs.verifyLikeButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCommentFromFeed() {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE STARTED</b>", "INFO",
					"<b>TESTCASE - VERIFY LIKE BUTTON ON FORUM FEED</b>");
			login();
			FeedScreen fs = new FeedScreen(DriverSession.getLastExecutionDriver());
			fs.clickOnMenu(2);
			fs.verifyLikeButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyLikeFromGuestUser() {
		try {
			LoginScreen ls = new LoginScreen(DriverSession.getLastExecutionDriver());
			if (checkLoggedInState(false)) {
				logOut();
			}
			ls.clickSkipForNow();
			FeedScreen fs = new FeedScreen(DriverSession.getLastExecutionDriver());
			fs.clickOnMenu(2);
			fs.verifyLikeWithGuestUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchApp(WebDriver driver) throws Exception {
		try {
			setUp(driver);
 			DriverSession.getLastExecutionReportingInstance().teststepreporting("App Launched", "PASS",
					"App should Launch");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception occured...while launching app", "FAIL", "App should Launch.");
			throw e;
		}
	}
}
