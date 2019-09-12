package Topfan.Android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.Keywords;

import Topfan.CMS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen extends CommonFeatures{
	private WebDriver driver;
	private WebElement element;

	public HomeScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyRadioButton() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().radioButtonLocator(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Radio Button successfully clicked",
						"PASS", "Progress Bar should be clicked");
			}else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Radio Button not successfully clicked",
						"FAIL", "Progress Bar should be clicked");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...as Radio Button was not found",
					"FAIL", "Radio Button should be clicked");
		}
	}
	
	public void verifyTextView() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().textViewLocator(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting("TextView successfully clicked",
						"PASS", "TextView should be clicked");
			}else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("TextView not successfully clicked",
						"FAIL", "TextView should be clicked");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...as TextView was not found",
					"FAIL", "TextView should be clicked");
		}
	}
	
	public void verifyToast() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().toastButtonLocator(driver);
			Keywords.click(element);
			if(DriverSession.getStepResult()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Toast Msg Button successfully clicked",
						"PASS", "Toast Msg Button should be clicked");
			}else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Toast Msg Button not successfully clicked",
						"FAIL", "Toast Msg Button should be clicked");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...as Toast Msg Button was not found",
					"FAIL", "Toast Msg Button should be clicked");
		}
	}
	
	public void verifyTextBox() throws Exception{
		try{
			element = AndroidAppLocators.getInstance().textBoxLocator(driver);
			Keywords.click(element);
			String notes = DriverSession.getTestCaseData().get("Notes");
			Keywords.typeText(element, notes);
			if(DriverSession.getStepResult()){
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Text successfully entered",
						"PASS", "Text Button should be entered");
			}else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Toast Msg Button not successfully entered",
						"FAIL", "Text Button should be entered");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...as Text Button was not found",
					"FAIL", "Text Button should be entered");
		}
	}

}
