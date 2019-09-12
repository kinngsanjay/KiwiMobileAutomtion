package Topfan.IOS;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Keywords;

import io.appium.java_client.ios.IOSDriver;

public class IOSAppLocators {

	public static IOSAppLocators getInstance() {
		IOSAppLocators mHeader = null;
		try {
			mHeader = new IOSAppLocators();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mHeader;
	}

	public Set<String> getCardTitleFromHomeScreen(WebDriver driver) {
		Set<String> lists;
		try {
			String title1 = driver.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[7]")).getAttribute("value");
			String title2 = driver.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[10]")).getAttribute("value");
			String title3 = driver.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[13]")).getAttribute("value");
			String[] titles = { title1, title2, title3 };
			lists = Arrays.stream(titles).collect(Collectors.toSet());
			return lists;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCardsTitleFromHomeScreen(WebDriver driver) {
		String element = driver.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[7]")).getText();
		return element;
	}

	public String getCardsTitleFromHomeScreen2(WebDriver driver) {
		String element = ((IOSDriver<?>) driver).findElementByIosUIAutomation(".scrollViews()[0].staticTexts()[9]")
				.getText();
		return element;
	}

	public WebElement getCardDescriptionFromHomeScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[8]"));
		return element;
	}

	public WebElement getCardTypeFromHomeScreen(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//UIAScrollView[1]/UIAStaticText[7]/preceding-sibling::UIAImage[1]"));
		return element;
	}

	public WebElement getLoginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//UIAButton[@name='LOGIN'])[1]"));
		return element;
	}

	public WebElement getRegisterButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//UIAButton[@name='REGISTER'])[1]"));
		return element;
	}

	public WebElement getUserNameEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[contains(@value,'Username')]"));
		return element;
	}

	public WebElement getEmailEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[contains(@value,'Email')]"));
		return element;
	}

	public WebElement getPasswordEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIASecureTextField[contains(@value,'Password')]"));
		return element;
	}

	public WebElement getBirthdateDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[contains(@value,'Birthdate')]"));
		return element;
	}

	public WebElement getLocationEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[contains(@value,'Location')]"));
		return element;
	}

	public WebElement getGenderDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[contains(@value,'Gender')]"));
		return element;
	}

	public WebElement getStartedButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[contains(@label,'Get Started')]"));
		return element;
	}

	public WebElement getLSLoginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[contains(@label,'Login')]"));
		return element;
	}

	public WebElement getRegisterNow(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='Register Now']"));
		return element;
	}

	public WebElement getForgotPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='Forgot Password?']"));
		return element;
	}

	public WebElement emailForForgotPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATextField[@label='Enter Email']"));
		return element;
	}

	public WebElement submitForgotPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='SUBMIT']"));
		return element;
	}

	public WebElement doneForgotPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='Done']"));
		return element;
	}

	public WebElement getGenderPicker(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAPickerWheel"));
		return element;
	}

	public WebElement getSkipOnLogin(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[contains(@label,'Skip')]"));
		return element;
	}

	public WebElement getMenu(WebDriver driver, String menu) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='" + menu + "']"));
		return element;
	}

	public WebElement getMenu(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath("//UIATabBar/UIAButton[" + index + "]"));
		return element;
	}

	public WebElement getSettingGear(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@label='icon settings']"));
		return element;
	}

	public WebElement getLogOut(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATableCell[@name='Logout']"));
		return element;
	}

	public WebElement getFirstLocation(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("(//UIATableView[starts-with(@value,'rows')]//UIATableCell)[1]"));
		return element;
	}

	public WebElement fetFirstFeedSection(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIACollectionCell"));
		return element;
	}

	public WebElement getMyProfileHeader(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIANavigationBar[@name='My Profile']"));
		return element;
	}

	public WebElement getCurrenScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIATabBar//UIAButton[@value='1']"));
		return element;
	}

	public WebElement getSkipForNow(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAStaticText[@label='SKIP FOR NOW']"));
		return element;
	}

	public WebElement getStatusBar(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAStaticText[contains(@label,'REGISTER NOW FOR')]"));
		return element;
	}

	public WebElement getCrossOnLogin(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@name='cross']"));
		return element;
	}

	public WebElement getCTAFromIndex(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath("//UIACollectionView[2]/UIACollectionCell[" + index + "]"));
		return element;
	}

	public List<WebElement> getALLCTACard(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//UIACollectionView[2]/UIACollectionCell"));
		return elements;
	}

	public WebElement getCarousel(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//UIAImage[@name='video_frame_bg']/following-sibling::UIAImage[1]"));
		return element;
	}

	public List<WebElement> getAllVisibleFeeds(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By.xpath("//UIAScrollView//UIACollectionView[1]/UIACollectionCell[@visible='true']"));
		return elements;
	}

	public WebElement getFeedRightArrow(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//UIAButton[@name='rightarrow']"));
		return element;
	}

	public WebElement getFeedCardsTopHeader(WebDriver driver) {
		WebElement element = ((IOSDriver<?>) driver).findElementByIosUIAutomation(".collectionViews()");
		return element;
	}

	public WebElement getFeedCards(WebDriver driver) {
		WebElement element = ((IOSDriver<?>) driver).findElementByIosUIAutomation(".tableViews()[0]");
		return element;
	}

	public List<WebElement> getFeedCardsTitle(WebDriver driver) {
		@SuppressWarnings("unchecked")
		List<WebElement> elements = ((IOSDriver<WebElement>) driver)
				.findElementsByIosUIAutomation(".collectionViews()[0].cells()");
		return elements;
	}

	public List<WebElement> getAllCardsOfFeed(WebDriver driver) {
		@SuppressWarnings("unchecked")
		List<WebElement> elements = ((IOSDriver<WebElement>) driver)
				.findElementsByIosUIAutomation(".tableViews()[0].cells()");
		return elements;
	}

	public WebElement getCardElement(WebDriver driver, int index) {
		WebElement element = ((IOSDriver<?>) driver)
				.findElementByIosUIAutomation(".tableViews()[0].cells()[" + index + "].staticTexts()[1]");
		return element;
	}

	public List<WebElement> getCardButtonElements(WebDriver driver, int index) {
		Keywords.waitForPage(driver, 5);
		@SuppressWarnings("unchecked")
		List<WebElement> elements = ((IOSDriver<WebElement>) driver)
				.findElementsByIosUIAutomation(".tableViews()[0].cells()[" + index + "].buttons()");
		Keywords.waitForPage(driver, 60);
		return elements;
	}

	public List<WebElement> getCardStaticTexts(WebDriver driver, int index) {
		Keywords.waitForPage(driver, 5);
		@SuppressWarnings("unchecked")
		List<WebElement> elements = ((IOSDriver<WebElement>) driver)
				.findElementsByIosUIAutomation(".tableViews()[0].cells()[" + index + "].staticTexts()");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((IOSDriver<?>) driver)
				.findElementByIosUIAutomation(".tableViews()[0].cells()[" + index + "].scrollToVisible()");
		Keywords.waitForPage(driver, 60);
		return elements;
	}

	public WebElement getLoginText(WebDriver driver) {
		WebElement element = ((IOSDriver<?>) driver).findElementByIosUIAutomation(".staticTexts()");
		return element;
	}

	public WebElement getAppSpecificStatusBar(WebDriver driver) {
		WebElement element = ((IOSDriver<?>) driver).findElementByXPath("//XCUIElementTypeApplication[1]");
		return element;
	}
}
