package action.Topfan;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

import Topfan.AccessLevel;
import Topfan.CMS;
import Topfan.Android.ActivityScreen;
import Topfan.Android.AndroidAppLocators;
import Topfan.Android.CommonFeatures;
import Topfan.Android.HomeScreen;
import Topfan.Android.LoginScreen;
import Topfan.Android.ProfileScreen;
import Topfan.Android.RegistrationScreen;
import Topfan.Android.SignInScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAppAction extends CommonAppAction {

	public WebElement element;
	public AppiumDriver<MobileElement> driver;
	private String email, username;

	public AndroidAppAction(AppiumDriver<MobileElement> lastExecutionDriver) {
		super(lastExecutionDriver);
		driver = lastExecutionDriver;
	}

	public void verifyRadioButton() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 1 STARTED</b>", "INFO",
					"<b>TESTCASE 1 - VERIFY RADIO BUTTON</b>");
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifyRadioButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyTextView() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 2 STARTED</b>", "INFO",
					"<b>TESTCASE 2 - VERIFY RADIO BUTTON</b>");
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifyTextView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyToast() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 3 STARTED</b>", "INFO",
					"<b>TESTCASE 3 - VERIFY TOAST</b>");
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifyToast();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyTextBox() throws Exception {
		try {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("<b>TESTCASE 4 STARTED</b>", "INFO",
					"<b>TESTCASE 4 - VERIFY TEXT BOX</b>");
			HomeScreen hs = new HomeScreen(DriverSession.getLastExecutionDriver());
			hs.verifyToast();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchApp(WebDriver driver) throws Exception { 
		try {
			setUp(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("App Launched", "PASS",
						"App should Launch");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured...while launching app", "FAIL",
					"App should Launch.");
			throw e;
		}
	}
}
