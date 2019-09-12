package Topfan.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class LoginScreen extends CommonFeatures {

	private WebDriver driver;
	private WebElement element;

	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickLoginButton() throws Exception {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getLoginButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button on Login screen successfully clicked", "PASS",
						"Login Button on Login screen should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button on Login screen not successfully clicked", "FAIL",
						"Login Button on Login screen should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on login button", "FAIL",
					"Login Button on Login screen should be clicked");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickRegisterButton() {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getRegisterButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Register button clicked", "PASS",
						"Register Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Register button not clicked",
						"FAIL", "Register Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on register button", "FAIL",
					"Register Button should be clicked");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickSkipForNow() {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		Keywords.waitForPage(driver, 20);
		try {
			element = AndroidAppLocators.getInstance().getSkipForNowButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Skip For Now button clicked",
						"PASS", "Skip For Now Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Skip For Now button not clicked",
						"FAIL", "Skip For Now Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on Skip For Now button", "FAIL",
					"Skip For Now Button should be clicked");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public boolean isLoginScreen() {
		Keywords.waitForPage(driver, 10);
		try {
			WebElement element = AndroidAppLocators.getInstance().getLoginButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Login screen appeared succesfully",
					"PASS", "Login screen should appear");
			return true;
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Login screen did not appear ", "FAIL",
					"Login screen should appear");
			return false;
		} finally {
			Keywords.waitForPage(driver, 60);
		}

	}

}
