package Topfan.IOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ProfileScreen {
	
	private WebDriver driver;
	private WebElement element;
	
	public ProfileScreen(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSettigsGear() {
		try {
			element = IOSAppLocators.getInstance().getSettingGear(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Settings Gear successfully clicked", "PASS", "Settings Gear should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Settings Gear not successfully clicked", "FAIL", "Settings Gear should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Settings Gear", "FAIL",
					"Settings Gear should be clicked");
		}
	}
	
	public void clickLogOut() {
		try {
			Keywords.scrollDown();	
			element = IOSAppLocators.getInstance().getLogOut(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Logout successfully clicked", "PASS", "Logout should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Logout not successfully clicked", "FAIL", "Logout should be clicked");
			Keywords.acceptAlert();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Logout", "FAIL",
					"Logout should be clicked");
		}
	}
}
