package Topfan.Android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.session.DriverSession;
import com.utilities.Keywords;

public class ActivityScreen extends CommonFeatures {

	private WebDriver driver;
	private WebElement element;

	private final String activityHeader = "My Activity";
	private final String newUserRegText1 = "You received 100 COIN for logging in.";
	private final String newUserRegText2 = "You received 1,000 COIN for creating an account.";

	public ActivityScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyMyActivity() {
		try {
			Keywords.waitForPage(driver, 5);
			element = AndroidAppLocators.getInstance().getMyActivityHeader(driver);
			String actualText = Keywords.getText(element).trim();
			if (actualText.equals(activityHeader))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Activity Screen is launched and verified", "PASS", "Verifying is My Activity launched");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Activity Screen is not launched", "FAIL", "Verifying is My Activity launched");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while opening My Activity", "FAIL", "Verifying is My Activity launched");
		} finally {
			Keywords.waitForPage(driver, 60);
		}
	}

	public void clickActivityTab(String tabName) {
		try {
			element = AndroidAppLocators.getInstance().getActivityTab(driver, tabName);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(tabName + " clicked successfully",
						"PASS", tabName + " should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unable to click on " + tabName + " tab", "FAIL", tabName + " should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on tab", "FAIL", tabName + " should be clicked");
			throw e;
		}
	}

	public void verifyActivityTab(String tabName) {
		try {
			clickActivityTab(tabName);
			element = AndroidAppLocators.getInstance().getActivityTab(driver, tabName);
			if (element.isSelected())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(tabName + " tab is selected",
						"PASS", tabName + " should be selected");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(tabName + " tab is not selected",
						"FAIL", tabName + " should be selected");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying tab", "FAIL", tabName + " should be selected");
		}
	}

	public void verifyLeaveDiscussion() {
		try {
			element = AndroidAppLocators.getInstance().getDiscussionTextFromActivity(driver, 1);
			String disText = Keywords.getText(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"State of Activity Screen before leaving a discussion", "INFO", "State of Activity screen");
			element = AndroidAppLocators.getInstance().getDotsOfActivity(driver, 1);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getLeaveDiscussion(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getDiscussionTextFromActivity(driver, 1);
			if (!Keywords.getText(element).equals(disText))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Leaving a discussion is working as expected", "PASS", "Verifying leaving any discussion");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Leaving a discussion not is working as expected", "FAIL", "Verifying leaving any discussion");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying leaving discussion", "FAIL",
					"Verifying leaving any discussion");
		}
	}

	public void verifyPostedDiscussionNotification(String userName, String postText) {
		try {
			Thread.sleep(5000L);
			String notificationText = (userName + " posted in " + postText).substring(0, 41) + " ...";
			element = AndroidAppLocators.getInstance().getFirstDiscussionText(driver);
			String orignalText = Keywords.getText(element);
			if (orignalText.equals(notificationText))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Notification is appearing in discussion", "PASS", "Verifying Discussion Notification");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Notification is not appearing in discussion", "FAIL", "Verifying Discussion Notification");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying notification", "FAIL", "Verifying Discussion Notification");
		}
	}

	public String verifyMessageInActivity(String userName, String message) {
		String messageText = "You and " + userName + " " + message;
		try {
			Thread.sleep(5000L);
			element = AndroidAppLocators.getInstance().getFirstMessageText(driver);
			String orignalText = Keywords.getText(element).replace(" ...", "");
			if (orignalText.equals(messageText))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Notification is appearing in Messages", "PASS", "Verifying Messages Notification");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Notification is not appearing in Messages", "FAIL", "Verifying Messages Notification");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying notification", "FAIL", "Verifying Messages Notification");
		}
		return messageText;
	}

	public void verifyClearConversationInMessage(String messageText) {
		try {
			element = AndroidAppLocators.getInstance().getDotsOfActivity(driver, 1);
			Keywords.click(element);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Message Screen state", "INFO",
					"Getting state of Message before clear conversation");
			element = AndroidAppLocators.getInstance().getClearConversation(driver);
			Keywords.click(element);
			Keywords.waitForPage(driver, 5);
			String orignalText = "";
			try {
				element = AndroidAppLocators.getInstance().getFirstMessageText(driver);
				orignalText = Keywords.getText(element);
			} catch (Exception e) {
			} finally {
				Keywords.waitForPage(driver, 60);
			}
			if (!orignalText.equals(messageText))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Clear Conversation is working as expected", "PASS",
						"Verifying Clear Conversation in Messages");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Clear Conversation is not working as expected", "FAIL",
						"Verifying Clear Conversation in Messages");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying clear conversations", "FAIL",
					"Verifying Clear Conversation in Messages");
		}
	}

	public void verifyNewUserRegNotification() {
		try {
			String notificationText;
			element = AndroidAppLocators.getInstance().getAllNotificationsTextFromActivity(driver, 0);
			notificationText = Keywords.getText(element);
			if (notificationText.equals(newUserRegText1))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Notification is appearing correct",
						"PASS", "Verifying New User Registration logging in notification text");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Incorrect notification is appearing", "FAIL",
						"Verifying New User Registration logging in notification text");
			element = AndroidAppLocators.getInstance().getAllNotificationsTextFromActivity(driver, 1);
			notificationText = Keywords.getText(element);
			if (notificationText.equals(newUserRegText2))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Notification is appearing correct",
						"PASS", "Verifying New User Registration account creation notification text");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Incorrect notification is appearing", "FAIL",
						"Verifying New User Registration account creation notification text");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying notification", "FAIL",
					"Verifying New User Registration notifications");
		}
	}

	public void readFirstMessage() {
		try {
			element = AndroidAppLocators.getInstance().getFirstMessageText(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First message Read", "PASS",
						"Reading first message in discussion");
				clickBackButton();
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to read message", "FAIL",
						"Reading first message in discussion");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while reading message", "FAIL", "Reading first message in discussion");
		}
	}

	public void verifyOrderOfDiscussions(String username, String firstMsg, String secondMsg) throws Exception {
		try {
			Thread.sleep(5000);
			username = username.trim().toLowerCase();
			firstMsg = firstMsg.trim().toLowerCase();
			secondMsg = secondMsg.trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getDiscussionTextFromActivity(driver, 1);
			String firstDiscussionText = element.getText().trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getDiscussionTextFromActivity(driver, 2);
			String secondDiscussionText = element.getText().trim().toLowerCase();
			String firstText = (username + " created " + secondMsg).substring(0, 41) + " ...";
			String secondText = (username + " created " + firstMsg).substring(0, 41) + " ...";
			if (firstDiscussionText.contains(firstText) && secondDiscussionText.contains(secondText)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Discussions are in the right order", "PASS", "Verifying order of discussions");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Discussions are not in the right order", "FAIL", "Verifying order of discussions");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying order of discussions", "FAIL",
					"Verifying order of discussions");
			throw e;
		}
	}

	public void verifyOrderOfMessages(String userOne, String userTwo, String messageOne, String messageTwo)
			throws Exception {
		try {
			Thread.sleep(5000);
			userOne = userOne.trim().toLowerCase();
			messageOne = messageOne.trim().toLowerCase();
			userTwo = userTwo.trim().toLowerCase();
			messageTwo = messageTwo.trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getMessageTextFromActivity(driver, 1);
			String firstMessageText = element.getText().trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getDiscussionTextFromActivity(driver, 2);
			String secondMessageText = element.getText().trim().toLowerCase();
			if (firstMessageText.contains(userOne) && firstMessageText.contains(messageOne)
					&& secondMessageText.contains(userTwo) && secondMessageText.contains(messageTwo)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Messages are in the right order",
						"PASS", "Verifying order of messages");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Messages are not in the right order", "FAIL", "Verifying order of messages");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying order of messages", "FAIL", "Verifying order of messages");
			throw e;
		}
	}

	public void verifyOrderOfNotifications(String userOne, String userTwo) throws Exception {
		try {
			Thread.sleep(5000);
			userOne = userOne.trim().toLowerCase();
			userTwo = userTwo.trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getAllNotificationsTextFromActivity(driver, 0);
			String firstNotificationText = element.getText().trim().toLowerCase();
			element = AndroidAppLocators.getInstance().getAllNotificationsTextFromActivity(driver, 1);
			String secondNotificationText = element.getText().trim().toLowerCase();
			if (firstNotificationText.contains(userOne) && secondNotificationText.contains(userTwo)) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Notifications are in the right order",
						"PASS", "Verifying order of notifications");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Notifications are not in the right order",
						"FAIL", "Verifying order of notifications");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying order of notifications", "FAIL",
					"Verifying order of notifications");
			throw e;
		}
	}
	
	public void verifyReferralNotification(String userReferred) throws Exception{
		try{
			Thread.sleep(5000);
			userReferred = userReferred.trim().toLowerCase();
			String expectedNotificationText = userReferred + " followed you.";
			element = AndroidAppLocators.getInstance().getAllNotificationsTextFromActivity(driver, 0);
			String actualNotificationText = element.getText().trim().toLowerCase();
			if(actualNotificationText.equals(expectedNotificationText)){
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Referral Notification successfully verified", "PASS",
						"Verifying referral notification");
			}else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Referral Notification not successfully verified", "FAIL",
						"Verifying referral notification");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying referral notification", "FAIL",
					"Verifying referral notification");
			throw e;
		}
	}
	
	public void clickFirstDiscussion() {
		  try {
		   element = AndroidAppLocators.getInstance().getFirstDiscussion(driver);
		   Keywords.click(element);
		   if(DriverSession.getStepResult()){
		    DriverSession.getLastExecutionReportingInstance().teststepreporting(
		      "First Discussion clicked successfully", "PASS",
		      "Discussion should be clicable");
		   }
		   else
		    DriverSession.getLastExecutionReportingInstance().teststepreporting(
		      "First Discission not clicked successfully", "FAIL",
		      "Discussion should be clicable");
		  } catch (Exception e) {
		   DriverSession.getLastExecutionReportingInstance().teststepreporting(
		     "Exception Occured...clicking the first discussion", "FAIL",
		     "Discussion should be clicable");
		  }
		 }
	
	public void isConversationScreenOpened(){
		  try{
		   element =AndroidAppLocators.getInstance().getConversationScreen(driver);
		    DriverSession.getLastExecutionReportingInstance().teststepreporting(
		      "Conversation screen appeared successfully", "PASS",
		      "Conversation screen should open");
		  } catch (Exception e) {
		   DriverSession.getLastExecutionReportingInstance().teststepreporting(
		     "Converstion screen not appeared successfully", "FAIL",
		     "Conversation screen should open");
		  } 
		 }
}
