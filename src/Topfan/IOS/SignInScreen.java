package Topfan.IOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class SignInScreen {
	
	private WebDriver driver;
	private WebElement element;

	public SignInScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String userName) {
		try {
			element = IOSAppLocators.getInstance().getUserNameEditText(driver);
			Keywords.typeText(element, userName);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username successfully entered",
						"PASS", "Username should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username not successfully entered",
						"FAIL", "Username should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Username", "FAIL", "Username should be entered");
		}
	}
	
	public void enterPassword(String password) {
		try {
			element = IOSAppLocators.getInstance().getPasswordEditText(driver);
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
		try {
			element = IOSAppLocators.getInstance().getLSLoginButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button successfully clicked", "PASS", "Login button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button not successfully clicked", "FAIL", "Login button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Login button", "FAIL",
					"Login button should be clicked");
		}
	}
	
	public void clickRegisterNow() {
		try {
			element = IOSAppLocators.getInstance().getRegisterNow(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register Now Link successfully clicked", "PASS", "Register Now Link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register Now Link not successfully clicked", "FAIL", "Register Now Link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Register Now Link", "FAIL",
					"Register Now Link should be clicked");
		}
	}
	
	public void clickForgotPassword() {
		try {
			element = IOSAppLocators.getInstance().getForgotPassword(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password Link successfully clicked", "PASS", "Forgot Password Link should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Forgot Password Link not successfully clicked", "FAIL", "Forgot Password Link should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Forgot Password Link", "FAIL",
					"Forgot Password Link should be clicked");
		}
	}
}
