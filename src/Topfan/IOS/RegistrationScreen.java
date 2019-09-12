package Topfan.IOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class RegistrationScreen {

	private WebDriver driver;
	private WebElement element;
	private final String mandatoryFieldMsg = "Please enter all required fields.";
	private final String allowedAgeMsg = "You must be (.*?) years or older to signup";

	public RegistrationScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername() {
		try {
			element = IOSAppLocators.getInstance().getUserNameEditText(driver);
			String username = "Topfan" + Keywords.getRandomData();
			Keywords.typeText(element, username);
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

	public String enterEmail() {
		String email = null;
		try {
			element = IOSAppLocators.getInstance().getEmailEditText(driver);
			email = "topfan" + Keywords.getRandomData() + "@grr.la";
			Keywords.typeText(element, email);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully entered",
						"PASS", "Email should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email not successfully entered",
						"FAIL", "Email should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while entering Email", "FAIL", "Email should be entered");
		}
		return email;
	}

	public void selectBirthdate(String day, String month, String year) {
		try {
			element = IOSAppLocators.getInstance().getBirthdateDropDown(driver);
			Keywords.click(element);
			Keywords.iOSDatePicker(day, month, year);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate successfully selected",
						"PASS", "Birthdate should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Birthdate not successfully selected", "FAIL", "Birthdate should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while selecting Birthdate", "FAIL", "Birthdate should be selected");
		}
	}

	public void selectGender() {
		try {
			element = IOSAppLocators.getInstance().getGenderDropDown(driver);
			Keywords.click(element);
			element = IOSAppLocators.getInstance().getGenderPicker(driver);
			Keywords.typeText(element, "Male");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender successfully selected",
						"PASS", "Gender should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender not successfully selected",
						"FAIL", "Gender should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while selecting Gender", "FAIL", "Gender should be selected");
		}
	}

	public void enterLocation() {
		try {
			element = IOSAppLocators.getInstance().getLocationEditText(driver);
			String location = "Indiana, PA, United States";
			Keywords.typeText(element, location);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location successfully entered",
						"PASS", "Location should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location not successfully entered",
						"FAIL", "Location should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Location", "FAIL", "Location should be entered");
		}
	}

	public String enterPassword() {
		String password = DriverSession.getTestCaseData().get("Password");
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
		return password;
	}

	public void clickGetStartedButton() {
		try {
			element = IOSAppLocators.getInstance().getStartedButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Get Started button successfully clicked", "PASS", "Get Started button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Get Started button not successfully clicked", "FAIL", "Get Started button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Get Started button", "FAIL",
					"Get Started button should be clicked");
		}
	}

	public void verifyMandatoryMsg() {
		try {
			String msg = Keywords.getiOSAlertText();
			if (msg.equals(mandatoryFieldMsg))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Manadatory Field msg verified",
						"PASS", "Mandatory Field msg should be verified");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Mandatory Field msg is incorrect",
						"FAIL", "Mandatory Field msg should be verified");
			Keywords.acceptAlert();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Mandatory Field msg", "FAIL",
					"Mandatory Field msg should be verified");
		}
	}

	public void verifyLowerAgeMsg() {
		try {
			String msg = Keywords.getiOSAlertText();
			if (msg.matches(allowedAgeMsg))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Allowed age msg verified", "PASS",
						"Allowed age msg should be verified");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Allowed age msg is incorrect",
						"FAIL", "Allowed age msg should be verified");
			Keywords.acceptAlert();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Allowed age msg", "FAIL",
					"Allowed age msg should be verified");
		}
	}
}
