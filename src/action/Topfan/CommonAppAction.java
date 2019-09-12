package action.Topfan;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.session.DriverSession;
import com.utilities.GlobalParam;

import Topfan.CMS;
import action.AppAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonAppAction extends AppAction {

	public WebElement element;
	public static Properties masterProp;
	public CMS cms;

	public CommonAppAction(AppiumDriver<MobileElement> lastExecutionDriver) {
		super(lastExecutionDriver);
	}

	public static void loadMasterProperties(String flavour) {
		masterProp = new Properties();
		String fileLoc = GlobalParam.CURRENT_PROJECT_PATH + GlobalParam.slash + flavour + ".properties";
		try {
			File f = new File(fileLoc);
			FileInputStream fis = new FileInputStream(f);
			masterProp.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launchCMS() throws Exception {
		try {
			cms = new CMS(masterProp.getProperty("browser"));
			cms.login("topfan_testing@kiwitech.com", "Passw0rd#KIWI!");
		}catch(Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to log in", "FAIL",
					"Logging in to the CMS");
			throw e;
		}
	}
	
	public int addCardsInCarousel() throws Exception {
		cms.createAllTypesOfCard();
		return cms.getCarouselCardsCount();
	}
	
	public ArrayList<String> getHomeScreenCarouselCards() throws Exception {
		return cms.getHSCarouselCardDetails();
	}
	
	public ArrayList<String> getHomeScreenFeedCards() throws Exception {
		return cms.getHSFeedCardDetails();
	}

	public void destoryAllCardAndClose() throws Exception {
		cms.destroyAllAddedCards();
		cms.closeCMS();
	}

	public String launchAndAddFeed() throws Exception {
		launchCMS();
		String feedID = cms.addFeedTopic();
		return feedID;
	}

	public void deleteAddedFeed(String feedID) throws Exception {
		cms.reverseFeedChanges();
		cms.deleteFeed(feedID);
	}

	public WebDriver getDisposableMail(String emailID) {
		WebDriver driver;
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/Sanjay/chromedriver");
			driver = new ChromeDriver();
			emailID = emailID.substring(0, emailID.indexOf("@"));
			driver.get("https://www.guerrillamail.com/inbox");
			driver.findElement(By.id("inbox-id")).click();
			driver.findElement(By.xpath("//span[@id='inbox-id']//input")).sendKeys(emailID);
			driver.findElement(By.xpath("//button[@class='save button small']")).click();
			WebElement element = driver.findElement(By.id("gm-host-select"));
			Select select = new Select(element);
			select.selectByValue("grr.la");
		} catch (Exception ee) {
			driver = null;
			ee.printStackTrace();
		}
		return driver;
	}

	public String topfanChangePassword(String emailID) {
		String password = "kiwitech@123";
		try {
			WebDriver driver = getDisposableMail(emailID);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains(text(),'talkchain.com')]")));
			driver.findElement(By.xpath("//td[contains(text(),'talkchain.com')]")).click();
			Thread.sleep(2000);
			String url = driver.findElement(By.xpath("//div[@class='email_body']//descendant::a")).getAttribute("href");
			driver.navigate().to(url);
			driver.findElement(By.xpath("//input[@name='userpassword']")).sendKeys(password);
//			driver.findElement(By.xpath("//input[@name='user[password_confirmation]']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(15000);
			driver.quit();
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return password;
	}
	
	public void addCTACard(int row) {
		try {
			cms.navigateToEditHomeScreen();
			cms.addCTACard(row);
		} catch (Exception e) {
		}
	}

	public boolean setFanWallStateFromCMS(boolean state) {
		try {
			return cms.setFanWallStatus(state);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured while setting state of Fan Wall", "FAIL",
					"Setting state of Fan Wall from CMS");
			throw e;
		}
	}
	
	public boolean setCMSPhotosLockedState(boolean state) {
		try {
			return cms.setPhotosLockedState(state);
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Exception occured while setting state of Photos", "FAIL",
					"Setting state of Photos Locked State from CMS");
			throw e;
		}
	}
}
