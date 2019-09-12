package Topfan.IOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class LoginScreen {
	
	private WebDriver driver;
	private WebElement element;

	public LoginScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLoginButton() {
		try {
			element = IOSAppLocators.getInstance().getLoginButton(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button clicked", "PASS", "Login Button should be clicked");
			else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Login button not clicked", "FAIL", "Login Button should be clicked");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on login button", "FAIL", "Login Button should be clicked");
			throw e;
		}
	}
	
	public void clickRegisterButton() {
		try {
			element = IOSAppLocators.getInstance().getRegisterButton(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register button clicked", "PASS", "Register Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register button not clicked", "FAIL", "Register Button should be clicked");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on register button", "FAIL", "Register Button should be clicked");
		}
	}

	public void clickSkipForNow() {
		try {
			element = IOSAppLocators.getInstance().getSkipForNow(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register button clicked", "PASS", "Register Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Register button not clicked", "FAIL", "Register Button should be clicked");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on register button", "FAIL", "Register Button should be clicked");
		}
	}

}
