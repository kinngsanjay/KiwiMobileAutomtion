package Topfan.IOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ForgotPasswordScreen {
	
	private WebDriver driver;
	private WebElement element;

	public ForgotPasswordScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		try {
			element = IOSAppLocators.getInstance().emailForForgotPassword(driver);
			Keywords.typeText(element, email);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully entered",
						"PASS", "Email should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email not successfully entered",
						"FAIL", "Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Email", "FAIL", "Email should be entered");
		}
	}
	
	public void clickSubmit() {
		try {
			element = IOSAppLocators.getInstance().submitForgotPassword(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Submit Button clicked successfully",
						"PASS", "Submit Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on submit button",
						"FAIL", "Submit Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking submit button", "FAIL", "Submit Button should be clicked");
		}
	}
	
	public void clickDone() {
		try {
			element = IOSAppLocators.getInstance().doneForgotPassword(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Done Button clicked successfully",
						"PASS", "Done Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click on done button",
						"FAIL", "Done Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking done button", "FAIL", "Done Button should be clicked");
		}
	}

}
