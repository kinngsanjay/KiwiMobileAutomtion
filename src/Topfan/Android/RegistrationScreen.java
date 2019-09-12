package Topfan.Android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class RegistrationScreen extends CommonFeatures{
	private WebDriver driver;
	private WebElement element;

	public RegistrationScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String fillFormAndSend(String username) throws Exception {
		String email = null;
		try {
			enterUsername(username);
			email = enterEmail();
			selectBirthdate("2000", "7", "27");
			selectGender("Male");
			enterLocation("Gurgaon");
			enterPassword();
			clickGetStartedButton();
			handleAlerts();
			verifyHomePageOpened();
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Registraton Form successfully filled and sent", "PASS",
						"Registration Form should be filled and sent");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Registraton Form not successfully filled and sent", "FAIL",
						"Registration Form should be filled and sent");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while filling Registration Form", "FAIL",
					"Registration Form should be filled and sent");
			throw e;
		}
		return email;
	}

	public String enterUsername() {
		String username = null;
		try {
			element = AndroidAppLocators.getInstance().getUserNameEditText(driver, "Registration");
			username = "User" + Keywords.getRandomData();
			Keywords.typeText(element, username);

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username successfully entered",
						"PASS", "Username should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username not successfully entered",
						"FAIL", "Username should be entered");
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Username", "FAIL", "Username should be entered");
		}
		return username;
	}

	public void enterUsername(String username) {
		try {
			element = AndroidAppLocators.getInstance().getUserNameEditText(driver, "Registration");
			Keywords.typeText(element, username);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username successfully entered",
						"PASS", "Username should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username not successfully entered",
						"FAIL", "Username should be entered");
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Username", "FAIL", "Username should be entered");
			throw e;
		}
	}

	public String enterEmail() {
		String email = null;
		try {
			email = "Topfan" + Keywords.getRandomString() + "@grr.la";
			enterEmail(email);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while entering Email", "FAIL", "Email should be entered");
			throw e;
		}
		return email;
	}

	public void enterEmail(String email) {
		try {
			element = AndroidAppLocators.getInstance().getEmailEditText(driver);
			Keywords.typeText(element, email);
//			Keywords.typeTextWithoutClear(element, "@"+email.split("@")[1]);
			
 			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email successfully entered",
						"PASS", "Email should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email not successfully entered",
						"FAIL", "Email should be entered");
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while entering Email", "FAIL", "Email should be entered");
		}
	}

	public void selectBirthdate(String year, String month, String day) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getBirthdateDropDown(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getYearPicker(driver);
			Keywords.click(element);
			Keywords.androidYearScroll(Integer.parseInt(year));
			element = AndroidAppLocators.getInstance().getYear(driver, year);
			Keywords.click(element);
			Keywords.androidMonthScroll(driver, month);
			Thread.sleep(1000L);
			element = AndroidAppLocators.getInstance().getDay(driver, day);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getOkButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate successfully selected",
						"PASS", "Birthdate should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Birthdate not successfully selected", "FAIL", "Birthdate should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while selecting Birthdate", "FAIL", "Birthdate should be selected");
			throw e;
		}
	}

	public void selectGender(String gender) {
		try {
			element = AndroidAppLocators.getInstance().getGenderDropDown(driver);
			Keywords.click(element);
			switch (gender) {
			case "Male":
				element = AndroidAppLocators.getInstance().getGenderMale(driver);
				Keywords.click(element);
				break;
			case "Female":
				element = AndroidAppLocators.getInstance().getGenderFemale(driver);
				Keywords.click(element);
				break;
			case "Other":
				element = AndroidAppLocators.getInstance().getGenderOther(driver);
				Keywords.click(element);
				break;
			default:
				break;
			}
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender successfully selected",
						"PASS", "Gender should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender not successfully selected",
						"FAIL", "Gender should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while selecting Gender", "FAIL", "Gender should be selected");
			throw e;
		}
	}

	public String enterLocation(String location) {
		try {
			element = AndroidAppLocators.getInstance().getLocationEditText(driver);
			// location = "Location" + Keywords.getRandomData();
			Keywords.typeText(element, location);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location successfully entered",
						"PASS", "Location should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location not successfully entered",
						"FAIL", "Location should be entered");
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Location", "FAIL", "Location should be entered");
			throw e;
		}
		return location;
	}
	
	public void enterPassword() {
		enterPassword(DriverSession.getTestCaseData().get("Password"));
	}

	public void enterPassword(String password) {
		try {
			element = AndroidAppLocators.getInstance().getPasswordEditText(driver, "Registration");
			Keywords.typeText(element, password);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password successfully entered",
						"PASS", "Password should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password not successfully entered",
						"FAIL", "Password should be entered");
			Keywords.hideKeyBoard();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while entering Password", "FAIL", "Password should be entered");
			throw e;
		}
	}

	public void clickGetStartedButton() {
		try {
			element = AndroidAppLocators.getInstance().getStartedButton(driver);
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
			throw e;
		}
	}

	public void handleAlerts() {
		try {
			element = AndroidAppLocators.getInstance().getSkipButton(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getYesButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Alert Box successfully handled",
						"PASS", "Alert box should be handled");
			else
				DriverSession.getLastExecutionReportingInstance()
						.teststepreporting("Alert Box not successfully handled", "FAIL", "Alert box should be handled");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while handling Alert Box", "FAIL", "Alert box should be handled");
			throw e;
		}
	}

	public void verifyHomePageOpened() {
		try {
			element = AndroidAppLocators.getInstance().getHomePageCheckElement(driver);
			Keywords.isElementPresent(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage successfully opened",
						"PASS", "HomePage should open");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("HomePage not successfully opened",
						"FAIL", "HomePage should open");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while opening HomePage", "FAIL", "HomePage should open");
			throw e;
		}
	}

	public void verifyEmailAlertMessage() {
		try {
			element = AndroidAppLocators.getInstance().getAlertMessage(driver);
			Keywords.isElementPresent(element);
			DriverSession.setStepResult(element.getText().trim().equals("Invalid email address"));

			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Alert Message successfully opened",
						"PASS", "Alert Message indicating invalid email address should open");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Alert Message not successfully opened", "FAIL",
						"Alert Message indicating invalid email address should open");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Alert Message", "FAIL",
					"Alert Message indicating invalid email address should open");
		}
	}

	public void verifyBirthdayAlertMessage() {
		try {
			element = AndroidAppLocators.getInstance().getAlertMessage(driver);
			Keywords.isElementPresent(element);
			DriverSession.setStepResult(element.getText().trim().equals("You must be 12 years or older to sign up"));
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Alert Message successfully opened",
						"PASS", "Alert Message indicating low age should open");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Alert Message not successfully opened", "FAIL",
						"Alert Message indicating low age should open");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying Alert Message", "FAIL",
					"Alert Message indicating low age should open");
		}
	}
	
	public void isGetStartedButtonPresent(){
		try{
			element = AndroidAppLocators.getInstance().getStartedButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Get Started button is present", "PASS", "Verifying Get Started button is present");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Get Started button is not present", "FAIL", "Verifying Get Started button is present");
			throw e;
		}
	}
	
	public void isFacebookButtonPresent(){
		try{
			element = AndroidAppLocators.getInstance().getFacebookButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Facebook button is present", "PASS", "Verifying Facebook button is present");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Facebook button is not present", "FAIL", "Verifying Facebook button is present");
			throw e;
		}
	}
	
	public void enterReferralUserName(String referralUserName) throws Exception{
		try{
			element = AndroidAppLocators.getInstance().getReferralUserNameEditTextBox(driver);
			Keywords.typeText(element, referralUserName);
			element = AndroidAppLocators.getInstance().getSubmitButtonOnReferral(driver);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Successfully entered the username who referred the current user", "PASS", "Entering username who referred the current user");
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Could not successfully enter the username who referred the current user", "FAIL", "Entering username who referred the current user");
			throw e;
		}
	}
}
