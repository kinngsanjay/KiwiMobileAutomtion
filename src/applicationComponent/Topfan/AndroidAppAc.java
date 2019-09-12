package applicationComponent.Topfan;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.session.DriverSession;

import action.Topfan.AndroidAppAction;
import action.Topfan.CommonAppAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@Test
public class AndroidAppAc extends AppComponent implements ApplicationComponent {
	AndroidDriver<MobileElement> driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	AndroidAppAction action;
	String email;

	@SuppressWarnings("unchecked")
	@Override
	public void openApplication() throws Exception {
		driver = (AndroidDriver<MobileElement>) DriverSession.getLastExecutionDriver();
		action = new AndroidAppAction((AndroidDriver<MobileElement>) DriverSession.getLastExecutionDriver());
		action.launchApp(driver);
		CommonAppAction.loadMasterProperties("TopfanAppConfig");
	}

	@Override
	public void closeApplication() {
		action.closeApp();
	}

	@Override
	public void validateHomePage() throws Exception {
		action.killApp();
	}
	
	public void verifyTC01() throws Exception {
		action.verifyRadioButton();
		action.killApp();
	}
	
	public void verifyTC02() throws Exception {
		action.verifyToast();
		action.killApp();
	}
	
	public void verifyTC03() throws Exception {
		action.verifyTextView();
		action.killApp();
	}
	
	public void verifyTC04() throws Exception {
		action.verifyTextBox();
		action.killApp();
	}
}