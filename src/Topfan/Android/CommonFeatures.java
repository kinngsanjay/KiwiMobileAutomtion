package Topfan.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.Keywords;

import action.Topfan.CommonAppAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CommonFeatures extends CommonAppAction {

	private WebDriver driver;

	@SuppressWarnings("unchecked")
	public CommonFeatures(WebDriver driver) {
		super((AndroidDriver<MobileElement>) DriverSession.getLastExecutionDriver());
		this.driver = driver;
	}

	public boolean checkBackButton(WebDriver driver) {
		try {
			Keywords.waitForPage(driver, 10);
			AndroidAppLocators.getInstance().getBackButton(driver);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void verifyFreshUserLogIn() {
		try {
			Thread.sleep(5000L);
			Keywords.acceptAlert();
			AndroidAppLocators.getInstance().getSkipButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User logged in successfully", "PASS",
					"User should log in");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User not logged in", "FAIL",
					"User should log in");
		}
	}

	public void clickBackButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getBackButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Back button found and clicked successfully", "PASS", "Back button should be clickable");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Back button not found", "FAIL",
						"Back button should be clickable");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on back button", "FAIL", "Back button should be clickable");
		}
	}

	public void clickFeedButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getFeedButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				// by =
				// AndroidAppLocators.getInstance().getLocatorOfProgressBar();
				// waitForProgressBarToBeInvisible(by);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Feed Button successfully clicked",
						"PASS", "Feed Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Feed Button found but not successfully clicked", "FAIL", "Feed Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...as Feed Button not found", "FAIL", "Feed Button should be clicked");
		}
	}

	public void clickHomeButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getHomeButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Home Button successfully clicked",
						"PASS", "Home Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Home Button found but not successfully clicked", "FAIL", "Home Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...as Home Button not found", "FAIL", "Home Button should be clicked");
		} 
	}

	public void waitForLoaderToStop(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {

		}
	}

	public void waitForProgressBarToBeInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), 15);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitTillClickable(By by) {
		WebDriverWait wait = new WebDriverWait(DriverSession.getLastExecutionDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public boolean isTabLayoutVisible() {
		try {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 10);
			driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tab_layout"));
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			Keywords.waitForPage(DriverSession.getLastExecutionDriver(), 30);
		}
	}

	public void clickProfileButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getProfileButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Profile button found and clicked successfully", "PASS", "Profile button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Profile button not found", "FAIL",
						"Profile button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on profile button", "FAIL", "Profile button should be clicked");
		}
	}

	@SuppressWarnings("unchecked")
	public static void scrollDownFrame(WebDriver driver) { // ##U
		try {
			WebElement element = AndroidAppLocators.getInstance().getFrame(driver);
			int frameHeight = element.getSize().height;
			element = AndroidAppLocators.getInstance().getActionBar(driver);
			int actionBarHeight = element.getSize().height;
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int statusBarHeight = element.getSize().height;
			int statusBarWidth = element.getSize().width;
			((AppiumDriver<AndroidElement>) driver).swipe(statusBarWidth / 2,
					statusBarHeight + actionBarHeight + frameHeight - 50, statusBarWidth / 2,
					statusBarHeight + actionBarHeight + 50, 4000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	public static void scrollUpFrame(WebDriver driver) { // ##U
		try {
			WebElement element = AndroidAppLocators.getInstance().getFrame(driver);
			int frameHeight = element.getSize().height;
			element = AndroidAppLocators.getInstance().getActionBar(driver);
			int actionBarHeight = element.getSize().height;
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int statusBarHeight = element.getSize().height;
			int statusBarWidth = element.getSize().width;
			((AppiumDriver<AndroidElement>) driver).swipe(statusBarWidth / 2, statusBarHeight + actionBarHeight + 50,
					statusBarWidth / 2, statusBarHeight + actionBarHeight + frameHeight - 50, 4000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	public static void scrollDownQuizScreen(WebDriver driver) {
		try {
			WebElement element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int statusBarHeight = element.getSize().height;
			int halfStatusBarWidth = (element.getSize().width) / 2;
			element = AndroidAppLocators.getInstance().getQuestionScreenHeader(driver);
			int questionScreenHeaderHeight = element.getSize().height;
			element = AndroidAppLocators.getInstance().getFrame(driver);
			int frameHeight = element.getSize().height;
			((AppiumDriver<AndroidElement>) driver).swipe(halfStatusBarWidth, statusBarHeight + frameHeight - 50,
					halfStatusBarWidth, statusBarHeight + questionScreenHeaderHeight + 50, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickForumButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getForumButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Forum Button successfully clicked",
						"PASS", "Forum Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forum Button found but not successfully clicked", "FAIL", "Forum Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...as Forum Button not found", "FAIL", "Forum Button should be clicked");
			throw e;
		}
	}

	public void clickActivityButton() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getActivityButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Activity Button successfully clicked", "PASS", "Activity Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Activity Button found but not successfully clicked", "FAIL",
						"Activity Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...as Activity Button not found", "FAIL", "Activity Button should be clicked");
			throw e;
		}
	}

	public int getBadgeCount() {
		try {
			WebElement element = AndroidAppLocators.getInstance().getActivityBadgeText(driver);
			return Integer.parseInt(Keywords.getText(element));
		} catch (Exception e) {
			return 0;
		}
	}

	public void verifyBadgeCount(int count) {
		killApp();
		relaunchApp();
		clickActivityButton();
		clickBackButton();
		int actualCount = getBadgeCount();
		if (actualCount == count)
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Badge count is appearing correct",
					"PASS", "Verifying badge account");
		else
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Badge count is appearing incorrect. Expected :" + count + " Actual :" + actualCount, "FAIL",
					"Verifying badge account");
	}

	@SuppressWarnings("unchecked")
	public void scrollDownProfileScreen(WebDriver driver) {
		try {
			WebElement element = AndroidAppLocators.getInstance().getDrawerLayoutProfileScreen(driver);
			int layoutHeight = element.getSize().height;
			int startY = element.getLocation().getY() + layoutHeight;
			int endY = element.getLocation().getY();
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int statusBarWidth = element.getSize().width;
			((AppiumDriver<AndroidElement>) driver).swipe(statusBarWidth / 2, startY - 50, statusBarWidth / 2,
					endY + 50, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void scrollDownForumScreen(WebDriver driver) {
		try {
			WebElement element = AndroidAppLocators.getInstance().getDrawerLayoutProfileScreen(driver);
			int layoutHeight = element.getSize().height;
			int startY = element.getLocation().getY() + layoutHeight;
			int endY = element.getLocation().getY();
			element = AndroidAppLocators.getInstance().getDeviceStatusBar(driver);
			int statusBarWidth = element.getSize().width;
			((AppiumDriver<AndroidElement>) driver).swipe(statusBarWidth / 2, startY - 100, statusBarWidth / 2,
					endY + 100, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyProfileScore(int a, int b) {
		if (a == b) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Profile Score is successfuly validated", "PASS", "Verifying the profile score");
		} else {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Profile Score is not successfuly validated", "FAIL", "Verifying the profile score");
		}
	}

	public void verifyUserStatusBarScore(int a, int b) {
		if (a == b) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User Status Bar score is successfuly validated", "PASS", "Verifying the User Status Bar score");
		} else {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"User Status Bar score is not successfuly validated", "FAIL",
					"Verifying the User Status Bar score");
		}
	}
}
