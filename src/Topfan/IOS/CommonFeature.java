package Topfan.IOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.Keywords;

public class CommonFeature {

	private WebDriver driver;
	private WebElement element;

	public CommonFeature(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForLoaderToStop() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//UIAImage[@name='video_frame_bg']/following-sibling::UIAImage[1]")));
		} catch (Exception e) {
		}
	}

	public void waitForActivityIndicator() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//UIAActivityIndicator[1]")));
		} catch (Exception e) {
		}
	}

	public void clickOnMenu(String screen) {
		try {
			element = IOSAppLocators.getInstance().getMenu(driver, screen);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						screen + " Menu button successfully clicked", "PASS", screen + " Menu should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						screen + " Menu button not successfully clicked", "FAIL",
						screen + " Menu button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Profile Menu button", "FAIL",
					"Profile Menu button should be clicked");
		}
	}

	public void clickOnMenu(int index) {
		try {
			element = IOSAppLocators.getInstance().getMenu(driver, index);
			Keywords.click(element);
			Thread.sleep(2000L);
			element = IOSAppLocators.getInstance().getCurrenScreen(driver);
			String screen = Keywords.getAttributeVal(element, "name");
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						screen + " Menu button successfully clicked", "PASS", screen + " Menu should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						screen + " Menu button not successfully clicked", "FAIL",
						screen + " Menu button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Profile Menu button", "FAIL",
					"Profile Menu button should be clicked");
		}
	}

	public void verifyFreshUserLogIn() {
		try {
			Thread.sleep(5000L);
			Keywords.acceptAlert();
			element = IOSAppLocators.getInstance().getSkipOnLogin(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User logged in successfully", "PASS",
					"User should log in");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("User not logged in", "FAIL",
					"User should log in");
		}
	}

}
