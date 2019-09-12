package Topfan.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInScreen extends CommonFeatures {
	private WebDriver driver;
	private WebElement element;
	private String password;
	private String email;

	public SignInScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public SignInScreen(WebDriver driver, String email, String password) {
		super(driver);
		this.driver = driver;
		this.password = password;
		this.email = email;
	}

	public void fillDetatilsAndSend() {
		try {
			enterEmail(email);
			enterPassword(password);
			clickLoginButton();
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignIn details successfully filled and sent", "PASS",
						"SignIn details should be filled and sent");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"SignIn details not successfully filled and sent", "FAIL",
						"SignIn details should be filled and sent");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while filling and sending SignIn details", "FAIL",
					"SignIn details should be filled and sent");
		}

	}

	public void enterEmail(String localEmail) {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		try {
			element = AndroidAppLocators.getInstance().getUserNameEditText(driver, "SignIn");
			Keywords.typeText(element, localEmail);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Username/Email successfully entered", "PASS", "Username/Email should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Username/Email not successfully entered", "FAIL", "Username/Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Username/Email", "FAIL", "Username/Email should be entered");
		}
	}

	public void enterPassword(String password) {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		try {
			element = AndroidAppLocators.getInstance().getPasswordEditText(driver, "SignIn");
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password successfully entered",
						"PASS", "Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password not successfully entered",
						"FAIL", "Password should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Password", "FAIL", "Password should be entered");
		}
	}

	public void clickLoginButton() {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnLogin");
		waitForLoaderToStop(by);
		try {
			element = AndroidAppLocators.getInstance().getLoginButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button on SignIn screen successfully clicked", "PASS",
						"Login button on SignIn screen should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button on SignIn screen not successfully clicked", "FAIL",
						"Login button on SignIn screen should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Login button", "FAIL",
					"Login button on SignIn screen should be clicked");
		}
	}

	public void clickForgotPasswordLink() {
		try {
			element = AndroidAppLocators.getInstance().getForgotPasswordLink(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password Link successfully clicked", "PASS", "Forgot Password Link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password Link not successfully clicked", "FAIL",
						"Forgot Password Link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Forgot Password Link", "FAIL",
					"Forgot Password Link should be clicked");
		}
	}

	@SuppressWarnings("unchecked")
	public void enterEmailOnWebView(String email) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getEmailTextBoxOnWebView(driver);
			Keywords.typeText(element, email);
			Keywords.hideKeyBoard();
//			int quarterElementWidth = element.getSize().getWidth() / 4;
//			int startX = element.getLocation().getX() + quarterElementWidth;
//			int finalX = element.getLocation().getX() - quarterElementWidth;
//			int constantY = element.getLocation().getY();
//			((AppiumDriver<AndroidElement>) driver).swipe(startX, constantY, finalX, constantY, 4000);
			element = AndroidAppLocators.getInstance().getSendButtonOnForgotPasswordPage(driver);
			element.click();
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Successfully entered on WebView",
					"PASS", "Entering email on WebView");
			Thread.sleep(15000);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering email on WebView", "FAIL", "Entering email on WebView");
			throw e;
		}
	}
	
	public void isLoginButtonPresent() throws Exception {
		try{
			element = AndroidAppLocators.getInstance().getLoginButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Login Button is present",
					"PASS", "Verifying Login Button on SignIn Screen");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Login Button is not present",
					"FAIL", "Verifying Login Button on SignIn Screen");
			throw e;
		}
	}

}
