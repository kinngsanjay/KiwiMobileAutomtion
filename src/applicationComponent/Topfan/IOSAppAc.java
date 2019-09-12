package applicationComponent.Topfan;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.session.DriverSession;
import com.utilities.Keywords;

import action.Topfan.CommonAppAction;
import action.Topfan.IOSAppAction;
import applicationComponent.AppComponent;
import applicationComponent.ApplicationComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

@Test
public class IOSAppAc extends AppComponent implements ApplicationComponent {
	IOSDriver<MobileElement> driver = null;
	HashMap<String, String> testData = new HashMap<String, String>();
	IOSAppAction action;

	@SuppressWarnings("unchecked")
	@Override
	public void openApplication() throws Exception {
		driver = (IOSDriver<MobileElement>) DriverSession.getLastExecutionDriver();
		action = new IOSAppAction((IOSDriver<MobileElement>) DriverSession.getLastExecutionDriver());
		action.launchApp(driver);
		Keywords.acceptAlert();
		CommonAppAction.loadMasterProperties("TopfanAppConfig");
	}

	@Override
	public void closeApplication() {
		action.closeApp();
	}

	@Override
	public void validateHomePage() throws Exception {
		action.verifyFeedSection();
		action.verifyCTASection();
		action.verifyStatusBar();
	}
	
	public void verifyCardsInCarousel() throws Exception {
		action.launchCMS();
		action.verifyCarousel();
	}
	
	public void verifyCarouselSequence() throws Exception {
		action.launchCMS();
		action.verifyCarouselSequence();
	}
	
	public void verifyFeedSequence() throws Exception {
		action.launchCMS();
		action.verifyFeedSequence();
	}
	
	public void verifyAllCardsFeed() throws Exception {
//		action.verifyAllCardsFromFeed();
//		action.verifyLikeFromFeed();
		action.verifyLikeFromGuestUser();
	}
	
	public void verifyAppRegistration() throws Exception {
		action.registerWithoutMandatoryFields();
		action.registerWithLowerAge();
		action.registerWithAllowedAge();
		action.registerWithOnlyMandatoryFields();
		action.verifyForgotPassword();
	}
}
