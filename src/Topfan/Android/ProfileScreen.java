package Topfan.Android;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.session.DriverSession;
import com.utilities.Keywords;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProfileScreen extends CommonFeatures {
	private WebElement element;
	private WebDriver driver;

	public ProfileScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public int getUserProfileScore() throws Exception{
		int scoreValue = 0;
		By by = AndroidAppLocators.getInstance().getLocatorForProfileImage();
		waitForLoaderToStop(by);
		Thread.sleep(10000);
		Keywords.waitForPage(driver, 20);
		try {
			try {
				element = AndroidAppLocators.getInstance().getScoreFromProfileScreen(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fetching score from profile screen successful", "PASS", "Fetching score from profile screen");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Fetching score from profile screen not successful", "FAIL",
						"Fetching score from profile screen");
			}
			String score = element.getText().trim();
			String scoreTemp;
			float sv;
			if (score.endsWith("K")) {
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000;
				scoreValue = (int) sv;
			} else if (score.endsWith("M")) {
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000000;
				scoreValue = (int) sv;
			} else if(score.endsWith("G")){
				scoreTemp = score.substring(0, score.length() - 1);
				sv = Float.parseFloat(scoreTemp);
				sv *= 1000000000;
				scoreValue = (int) sv;
			}else {
				scoreTemp = score.replaceAll(",", "");
				scoreValue = Integer.valueOf(scoreTemp);
			}
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Score is "+scoreValue, "INFO", "Fetching score from profile screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while fetching profile score", "FAIL", "Fetching score from profile screen");
			throw e;
		} finally {
			Keywords.waitForPage(driver, 60);
		}
		return scoreValue;
	}

	public void clickFollowButton() {
		try {
			element = AndroidAppLocators.getInstance().getFollowButtonFromProfileScreen(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getUnfollowButtonFromProfileScreen(driver);
			if (DriverSession.getStepResult() && Keywords.getText(element).equals("Unfollow"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follow button clicked successfully", "PASS", "Follow Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click follow button",
						"FAIL", "Follow Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking follow button", "FAIL", "Follow Button should be clicked");
			throw e;
		}
	}

	public void clickUnfollowButton() {
		try {
			element = AndroidAppLocators.getInstance().getUnfollowButtonFromProfileScreen(driver);
			Keywords.click(element);
			element = AndroidAppLocators.getInstance().getFollowButtonFromProfileScreen(driver);
			if (DriverSession.getStepResult() && Keywords.getText(element).equals("Follow"))
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Unfollow button clicked successfully", "PASS", "Unfollow Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click unfollow button",
						"FAIL", "Unfollow Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking unfollow button", "FAIL", "Unfollow Button should be clicked");
			throw e;
		}
	}

	public String getUserScore() {
		element = AndroidAppLocators.getInstance().getUserProfileScore(driver);
		return Keywords.getText(element);
	}

	public void verifyUserName(String user) {
		try {
			String userName = getUserName();
			if (userName.equals(user))
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User name is appeariing correct",
						"PASS", "Verifying User Name on Profile Screen");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to username", "FAIL",
						"Verifying User Name on Profile Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying user name", "FAIL", "Verifying User Name on Profile Screen");
		}
	}

	public String getUserName() {
		try {
			element = AndroidAppLocators.getInstance().getUserNameFromProfileScreen(driver);
			String userName = Keywords.getText(element).trim();
			return userName;
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while getting user name", "FAIL", "Getting User Name from Profile Screen");
			throw e;
		}
	}

	public void clickMessageButton() {
		try {
			element = AndroidAppLocators.getInstance().getMessageButtonFromProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Message button clicked successfully", "PASS", "Message Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click message button",
						"FAIL", "Message Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking message button", "FAIL", "Message Button should be clicked");
			throw e;
		}
	}

	public void typeMessageForUser(String messageText) {
		try {
			element = AndroidAppLocators.getInstance().getMessageTextBoxFromProfileScreen(driver);
			Keywords.typeText(element, messageText);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Message typed successfully",
						"PASS", "Message for user should be entered");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to type message", "FAIL",
						"Message for user should be entered");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while typing message", "FAIL", "Message for user should be entered");
			throw e;
		}
	}

	public void clickPostButton() {
		try {
			element = AndroidAppLocators.getInstance().getPostButtonFromProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Post button clicked successfully",
						"PASS", "Post Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click Post button",
						"FAIL", "Post Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking Post button", "FAIL", "Post Button should be clicked");
			throw e;
		}
	}

	public void messageUser(String message) {
		try {
			DriverSession.setReporting(false);
			clickMessageButton();
			typeMessageForUser(message);
			clickPostButton();
			DriverSession.setReporting(true);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Message successfully send", "PASS",
						"Message should be send to user");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to send message to user",
						"FAIL", "Message should be send to user");
			clickBackButton();
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...when sending message", "FAIL", "Message should be send to user");
			throw e;
		}
	}

	public void clickFollowingSection() {
		try {
			element = AndroidAppLocators.getInstance().getFollowingFromProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Following section clicked successfully", "PASS", "Following section should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click following section",
						"FAIL", "Following section should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking following section", "FAIL",
					"Following section should be clicked");
			throw e;
		}
	}

	public void clickSearchIcon() {
		try {
			element = AndroidAppLocators.getInstance().getSearchIconProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Search Icon clicked successfully",
						"PASS", "Search Icon should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click search icon",
						"FAIL", "Search Icon should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking search icon", "FAIL", "Search Icon should be clicked");
			throw e;
		}
	}

	public void clickUserSearchResult() {
		try {
			element = AndroidAppLocators.getInstance().searchUserResultFromProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting("User selected successfully",
						"PASS", "User from search result should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to select user", "FAIL",
						"User from search result should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking on user search result", "FAIL",
					"User from search result should be clicked");
			throw e;
		}
	}

	public void typeTextInSearch(String text) {
		try {
			element = AndroidAppLocators.getInstance().searchTextBoxFromProfileScreen(driver);
			Keywords.typeText(element, text + "\n");
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username entered successfully",
						"PASS", "Enter the name of user");
			} else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to enter username", "FAIL",
						"Enter the name of user");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance()
					.teststepreporting("Exception Occured...while entering username", "FAIL", "Enter the name of user");
			throw e;
		}
	}

	public void navigateToUser(String userName) throws Exception {
		clickFollowingSection();
		clickSearchIcon();
		typeTextInSearch(userName);
		Thread.sleep(3000L);
		clickUserSearchResult();
	}

	public void followUser(String userName) throws Exception {
		navigateToUser(userName);
		clickFollowButton();
		clickBackButton();
		clickBackButton();
		clickBackButton();
	}

	public void isProfileScreenOpened() {
		try {
			element = AndroidAppLocators.getInstance().getEditProfileButton(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Profile Screen is opened", "PASS",
					"Verifying Profile Screen is opened");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("Profile Screen is not opened", "FAIL",
					"Verifying Profile Screen is opened");
		}
	}

	public void clickEditProfileButton() {
		try {
			element = AndroidAppLocators.getInstance().getEditProfileButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Edit Profile button successfully clicked", "PASS", "Edit Profile Button should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Edit Profile button not successfully clicked", "FAIL",
						"Edit Profile Button should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while clicking Edit Profile Button", "FAIL",
					"Edit Profile Button should be clicked");
		}
	}

	public void areAllFieldsPresentInEditProfileSection() throws Exception {
		try {
			try {
				element = AndroidAppLocators.getInstance().getFirstNameFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name Field is present",
						"PASS", "Verifying the presence of First Name field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name Field is not present",
						"FAIL", "Verifying the presence of First Name field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getLastNameFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Last Name Field is present",
						"PASS", "Verifying the presence of Last Name field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Last Name Field is not present",
						"FAIL", "Verifying the presence of Last Name field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getUsernameFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username Field is present", "PASS",
						"Verifying the presence of Username field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username Field is not present",
						"FAIL", "Verifying the presence of Username field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getPasswordFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password Field is present", "PASS",
						"Verifying the presence of Password field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Password Field is not present",
						"FAIL", "Verifying the presence of Password field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getEmailFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Field is present", "PASS",
						"Verifying the presence of Email field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Field is not present",
						"FAIL", "Verifying the presence of Email field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getBirthdateFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate Field is present",
						"PASS", "Verifying the presence of Birthdate field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate Field is not present",
						"FAIL", "Verifying the presence of Birthdate field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getGenderFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender Field is present", "PASS",
						"Verifying the presence of Gender field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender Field is not present",
						"FAIL", "Verifying the presence of Gender field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getLocationFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location Field is present", "PASS",
						"Verifying the presence of Location field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location Field is not present",
						"FAIL", "Verifying the presence of Location field in Edit Profile Section");
				throw e;
			}

			try {
				element = AndroidAppLocators.getInstance().getBioFieldInEditProfileSection(driver);
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Bio Field is present", "PASS",
						"Verifying the presence of Bio field in Edit Profile Section");
			} catch (Exception e) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Bio Field is not present", "FAIL",
						"Verifying the presence of Bio field in Edit Profile Section");
				throw e;
			}

		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while verifying the presence of all fields in Edit Profile Section", "FAIL",
					"Verifying the presence of all fields in Edit Profile Section");
			throw e;
		}
	}

	public void verifyPreFilledFieldsInEditProfileSection() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getFirstNameFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name Field is prefilled",
						"PASS", "Verifying First Name Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Name Field is not prefilled",
						"FAIL", "Verifying First Name Field is prefilled");
			}

			element = AndroidAppLocators.getInstance().getUsernameFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username Field is prefilled",
						"PASS", "Verifying Username Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Username Field is not prefilled",
						"FAIL", "Verifying Username Field is prefilled");
			}

			element = AndroidAppLocators.getInstance().getEmailFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Field is prefilled", "PASS",
						"Verifying Email Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Email Field is not prefilled",
						"FAIL", "Verifying Email Field is prefilled");
			}

			element = AndroidAppLocators.getInstance().getBirthdateFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate Field is prefilled",
						"PASS", "Verifying Birthdate Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Birthdate Field is not prefilled",
						"FAIL", "Verifying Birthdate Field is prefilled");
			}

			element = AndroidAppLocators.getInstance().getGenderFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender Field is prefilled", "PASS",
						"Verifying Gender Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Gender Field is not prefilled",
						"FAIL", "Verifying Gender Field is prefilled");
			}

			element = AndroidAppLocators.getInstance().getLocationFieldInEditProfileSection(driver);
			if (!element.getText().isEmpty()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location Field is prefilled",
						"PASS", "Verifying Location Field is prefilled");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Location Field is not prefilled",
						"FAIL", "Verifying Location Field is prefilled");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while verifying prefilled fields in Edit Profile Section", "FAIL",
					"Verifying prefilled fields in Edit Profile Section");
		}
	}

	public void verifyFirstNameInEditProfileSection(String username) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getFirstNameFieldInEditProfileSection(driver);
			if (element.getText().trim().equals(username.trim())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Name field is the username of the user", "PASS",
						"Verifying First Name field in Edit Profile Section is user's username");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Name field is not the username of the user", "FAIL",
						"Verifying First Name field in Edit Profile Section is user's username");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured... while verifying First Name field in Edit Profile Section is user's username",
					"FAIL", "Verifying First Name field in Edit Profile Section is user's username");
		}
	}

	public void verifyNoUsersFoundMessage() throws Exception {
		try {
			Thread.sleep(5000);
			element = AndroidAppLocators.getInstance().getNoFollowingOrFollowerUsersMessage(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Message '" + element.getText() + "' is present", "PASS",
					"Verifying No Users found message appears");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting("No message is present", "FAIL",
					"Verifying No Users found message appears");
		}
	}

	public void clickFollowersSection() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getFollowerFromProfileScreen(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult())
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Followers section clicked successfully", "PASS", "Followers section should be clicked");
			else
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Unable to click followers section",
						"FAIL", "Followers section should be clicked");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while clicking followers section", "FAIL",
					"Followers section should be clicked");
			throw e;
		}
	}

	public void verifyFollowerUserPresent(String follower) throws Exception {
		try {
			boolean found = false;
			boolean listFinished = false;
			int scrollAttempts = 0;
			String temp = null;
			do {
				List<WebElement> names = AndroidAppLocators.getInstance().getAllFollowersInFollowersSection(driver);
				if (!names.isEmpty()) {
					if (names.get(names.size() - 1).getText().trim().equals(temp)) {
						listFinished = true;
					} else {
						temp = names.get(names.size() - 1).getText().trim();
					}
					if (!listFinished) {
						for (int i = 0; i < names.size(); i++) {
							if (names.get(i).getText().trim().equals(follower.trim())) {
								found = true;
								break;
							}
						}
						if (!found) {
							scrollDownProfileScreen(driver);
							scrollAttempts++;
						}
					}
				} else {
					listFinished = true;
					DriverSession.getLastExecutionReportingInstance().teststepreporting("The Followers list is empty",
							"FAIL", "Verifying follower in Followers Section");
				}
			} while (!found && !listFinished && scrollAttempts < 10);

			if (found) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follower " + follower + " found in followers section", "PASS",
						"Verifying follower in Followers Section");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Follower " + follower + " not found in followers section", "FAIL",
						"Verifying follower in Followers Section");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying follower " + follower + " in followers section", "FAIL",
					"Verifying follower in Followers Section");
			throw e;
		}
	}

	public void verifyFollowingUserPresent(String followingUsername) throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getFirstFollowingUser(driver);
			if (element.getText().trim().toLowerCase().contains(followingUsername.trim().toLowerCase())) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Following user " + followingUsername + " present first in following section", "PASS",
						"Verifying following user in Following Section");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Following user " + followingUsername + " not present first in following section", "FAIL",
						"Verifying following user in Following Section");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception Occured...while verifying following user in following section", "FAIL",
					"Verifying following user in Following Section");
			throw e;
		}
	}

	public void isAvatarImagePresent() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getAvatarImage(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Avatar Image is present on Profile Screen", "PASS",
					"Verifying Avatar Image present on Profile Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Avatar Image not present on Profile Screen", "FAIL",
					"Verifying Avatar Image present on Profile Screen");
			throw e;
		}
	}

	public void verifyUploadOptionsOnAvatarImage() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getAvatarImage(driver);
			Keywords.click(element);
			if (isTakePhotoOptionPresent()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Take Photo option present", "PASS",
						"Verifying Options on Avatar Image");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Take Photo option not present",
						"FAIL", "Verifying Options on Avatar Image");
			}

			if (isPhotoFromGalleryOptionPresent()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Photo From Gallery option present",
						"PASS", "Verifying Options on Avatar Image");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Photo From Gallery option not present", "FAIL", "Verifying Options on Avatar Image");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying options on Avatar Image", "FAIL",
					"Verifying Options on Avatar Image");
			throw e;
		}
	}

	public boolean isTakePhotoOptionPresent() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getTakePhotoOption(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPhotoFromGalleryOptionPresent() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getPhotoFromGalleryOption(driver);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void isProfileImagePresent() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getProfileImage(driver);
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Profile Image is present on Profile Screen", "PASS",
					"Verifying Profile Image present on Profile Screen");
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Profile Image not present on Profile Screen", "FAIL",
					"Verifying Profile Image present on Profile Screen");
			throw e;
		}
	}

	public void verifyUploadOptionsOnProfileImage() throws Exception {
		try {
			element = AndroidAppLocators.getInstance().getProfileImage(driver);
			Keywords.click(element);
			if (isTakePhotoOptionPresent()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Take Photo option present", "PASS",
						"Verifying Options on Profile Image");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Take Photo option not present",
						"FAIL", "Verifying Options on Profile Image");
			}

			if (isPhotoFromGalleryOptionPresent()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Photo From Gallery option present",
						"PASS", "Verifying Options on Profile Image");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Photo From Gallery option not present", "FAIL", "Verifying Options on Profile Image");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying options on Profile Image", "FAIL",
					"Verifying Options on Profile Image");
			throw e;
		}
	}

	public void clickGiveGiftButton() throws Exception {
		try {
			By by = AndroidAppLocators.getInstance().getLocatorOfGiveGiftButton();
			waitForLoaderToStop(by);
			element = AndroidAppLocators.getInstance().getGiveGiftButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Give Gift button clicked successfully", "PASS", "Give Gift Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Give Gift Button not clicked successfully",
						"FAIL", "Give Gift Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking Give Gift Button", "FAIL", "Give Gift Button should be clicked");
			throw e;
		}
	}
	
	public void clickFirstGiftOption() throws Exception {
		try {
			By by = AndroidAppLocators.getInstance().getLocatorOfFirstGiftOption();
			waitForLoaderToStop(by);
			element = AndroidAppLocators.getInstance().getFirstGiftOption(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"First Gift option clicked successfully", "PASS", "First Gift option should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("First Gift option not clicked successfully",
						"FAIL", "First Gift option should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking the first Gift Option", "FAIL", "First Gift option should be clicked");
			throw e;
		}
	}
	
	public String clickSendGiftButton() throws Exception {
		try {
			By by = AndroidAppLocators.getInstance().getLocatorOfGiftName();
			waitForLoaderToStop(by);
			element = AndroidAppLocators.getInstance().getGiftName(driver);
			String giftName = element.getText();
			int scrolls = 0;
			while(!isSendGiftButtonPresent() && scrolls<5){
				scrollDownProfileScreen(driver);
				scrolls++;
			};
			element = AndroidAppLocators.getInstance().getSendGiftButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Send Gift button clicked successfully", "PASS", "Send Gift button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("Send Gift button not clicked successfully",
						"FAIL", "Send Gift button should be clicked");
			}
			Thread.sleep(5000);
			return giftName;
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking Send Gift Button", "FAIL", "Send Gift button should be clicked");
			throw e;
		}
	}
	
	private boolean isSendGiftButtonPresent(){
		try{
			element = AndroidAppLocators.getInstance().getSendGiftButton(driver);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public void clickMyGiftsButton(){
		try {
			By by = AndroidAppLocators.getInstance().getLocatorOfMyGiftsButton();
			waitForLoaderToStop(by);
			element = AndroidAppLocators.getInstance().getMyGiftsButton(driver);
			Keywords.click(element);
			if (DriverSession.getStepResult()) {
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"My Gifts Button clicked successfully", "PASS", "My Gifts Button should be clicked");
			} else {
				DriverSession.getLastExecutionReportingInstance().teststepreporting("My Gifts Button not clicked successfully",
						"FAIL", "My Gifts Button should be clicked");
			}
		} catch (Exception e) {
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while clicking My Gifts Button", "FAIL", "My Gifts Button should be clicked");
			throw e;
		}
	}
	
	public void verifyGiftReceived(String user, String giftName) throws Exception{
		Keywords.waitForPage(driver, 10);
		try{
			Thread.sleep(5000);
			element = AndroidAppLocators.getInstance().getFirstGiftTitle(driver);
			String actualText = element.getText().trim().toLowerCase();
			String expectedText = user.trim().toLowerCase()+" gave you a "+giftName.trim().toLowerCase();
			if(actualText.contains(expectedText)){
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Gift is received", "PASS", "Verifying gift received in the My Gifts section");
			}else{
				DriverSession.getLastExecutionReportingInstance().teststepreporting(
						"Gift is not received", "FAIL", "Verifying gift received in the My Gifts section");
			}
		}catch(Exception e){
			DriverSession.getLastExecutionReportingInstance().teststepreporting(
					"Exception occured...while verifying gift received", "FAIL", "Verifying gift received in the My Gifts section");
			throw e;
		}finally {
			Keywords.waitForPage(driver, 60);
		}
	}
}