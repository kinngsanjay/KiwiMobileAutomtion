package Topfan.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AndroidAppLocators {

	private static AndroidAppLocators mHeader;

	private AndroidAppLocators() {

	}

	public static AndroidAppLocators getInstance() {
		if (mHeader == null) {
			mHeader = new AndroidAppLocators();
		}
		return mHeader;
	}

	public WebElement getRegisterButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnRegister"));
		return element;
	}

	public WebElement getUserNameEditText(WebDriver driver, String screen) {
		WebElement element;
		switch (screen) {
		case "Registration":
			element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etRegisterUsername"));
			break;
		case "SignIn":
			element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etLoginUserNameOrEmail"));
			break;
		default:
			element = null;
			break;
		}

		return element;
	}

	public WebElement getEmailEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etRegisterEmail"));
		return element;
	}

	public WebElement getBirthdateDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnBirthdate"));
		return element;
	}

	public WebElement getGenderDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnGender"));
		return element;
	}

	public WebElement getLocationEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etRegisterLocation"));
		return element;
	}

	public WebElement getPasswordEditText(WebDriver driver, String screen) {
		WebElement element;
		switch (screen) {
		case "Registration":
			element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etRegisterPassword"));
			break;
		case "SignIn":
			element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etLoginPassword"));
			break;
		default:
			element = null;
			break;
		}

		return element;
	}

	public WebElement getStartedButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/register"));
		return element;
	}

	public WebElement getLoginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnLogin"));
		return element;
	}

	public WebElement getForgotPasswordLink(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvForgotPassword"));
		return element;
	}

	public WebElement getSkipButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/d_referral_button_submit_layout"));
		return element;
	}

	public WebElement getYesButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/button1"));
		return element;
	}

	public WebElement getHomePageCheckElement(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_toggle_feed_home"));
		return element;
	}

	public WebElement getForgotPasswordUrlBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.android.chrome:id/url_bar"));
		return element;
	}

	public WebElement getForgetEmailTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.name("useremail"));
		return element;
	}

	public WebElement getSubmitButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		return element;
	}

	public WebElement newPassword(WebDriver driver) {
		WebElement element = driver.findElement(By.name("userpassword"));
		return element;
	}

	public WebElement getGenderMale(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Male']"));
		return element;
	}

	public WebElement getGenderFemale(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Female']"));
		return element;
	}

	public WebElement getGenderOther(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Other']"));
		return element;
	}

	public WebElement getYearPicker(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/date_picker_year"));
		return element;
	}

	public WebElement getDay(WebDriver driver, String day) {
		WebElement element = driver.findElement(By.xpath("//android.view.View//android.view.View[" + day + "]"));
		return element;
	}

	public WebElement getYear(WebDriver driver, String year) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']"));
		return element;
	}

	public WebElement getOkButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/button1"));
		return element;
	}

	public WebElement getAlertMessage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/frg_dialog_msg"));
		return element;
	}

	public WebElement getEmailField(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@title='Enter Email']"));
		return element;
	}

	public WebElement getEllipsisSettingsIcon(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.ImageView[@index='5']"));
		return element;
	}

	public WebElement getSettingsLink(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']"));
		return element;
	}

	public WebElement getLogoutLink(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']"));
		return element;
	}

	public WebElement getLogoutOKButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
		return element;
	}

	public WebElement getProfileButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_profile"));
		return element;
	}

	public WebElement getFirstFeedSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/text1"));
		return element;
	}

	public String getCardsTitleFromHomeScreen(WebDriver driver) {
		String element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/carousal_title_text")).getText().trim();
		return element;
	}

	public WebElement getBackButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.view.View[@resource-id='com.topfan.TopFan.TestApp:id/action_bar']/android.widget.ImageButton"));
		return element;
	}

	public WebElement getSkipForNowButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvGuestSignIn"));
		return element;
	}

	public WebElement getStatusBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/register_text_home"));
		return element;
	}

	public WebElement getFeedSectionNextButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/right_arrow"));
		return element;
	}

	public List<WebElement> getFeedSectionTitles(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/text1"));
		return elements;
	}

	public List<WebElement> getALLCTACard(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/tvCategoryName"));
		return elements;
	}

	public WebElement getCTAFromIndex(WebDriver driver, int index) {
		WebElement element = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/tvCategoryName")).get(index - 1);
		return element;
	}

	public WebElement getFeedButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/action_toggle_feed_home']"));
		return element;
	}

	public WebElement getHomeButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_toggle_feed_home"));
		return element;
	}

	public WebElement getLikesCount(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivLike'])[" + index
						+ "]/following-sibling::android.widget.TextView"));
		return element;
	}

	public WebElement getLikeButton(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivLike'])[" + index + "]"));
		return element;
	}

	public WebElement getCommentButton(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivComment'])[" + index + "]"));
		return element;
	}

	public By getLocatorForACard() {
		By by = By.id("com.topfan.TopFan.TestApp:id/cardLayout");
		return by;
	}

	public List<WebElement> getAllVisibleLikeButtons(WebDriver driver) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivLike']"));
		return elements;
	}

	public List<WebElement> getAllVisibleCommentButtons(WebDriver driver) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivComment']"));
		return elements;
	}

	public WebElement getCommentEditText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/_mm_edit_text"));
		return element;
	}

	public WebElement getPostCommentButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/makemoji_post_tv"));
		return element;
	}

	public WebElement getCameraIcon(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/_mm_camera_ib"));
		return element;
	}

	public WebElement getTakeFromCameraOption(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("(//android.widget.TextView[@resource-id='android:id/text1'])[1]"));
		return element;
	}

	public WebElement getCameraView(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.motorola.camera:id/preview_surface"));
		return element;
	}

	public WebElement getApproveImageButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.motorola.camera:id/review_approve"));
		return element;
	}

	public WebElement getDoneButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/photo_editing_btn_done"));
		return element;
	}

	public WebElement getHamburgerIcon(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/home_button_ic"));
		return element;
	}

	public List<WebElement> getHamburgerFeeds(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("android:id/text1"));
		return elements;
	}

	public WebElement getSingleLikeButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivLike"));
		return element;
	}

	public WebElement getCommentButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivComment"));
		return element;
	}

	public WebElement getSearchIconButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/search"));
		return element;
	}

	public WebElement getSearchButtonPlaceholderOnFeed(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/search_src_text"));
		return element;
	}

	public WebElement getPollsButton(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Polls']"));
		return element;
	}

	public WebElement getVoteButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnvote"));
		return element;
	}

	public List<WebElement> getAllVoteButtons(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/btnvote"));
		return elements;
	}

	public WebElement getQuizzesButton(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Quizzes']"));
		return element;
	}

	public WebElement getStartQuizButton(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnStartQuiz']"));
		return element;
	}

	public WebElement getQuestionScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/quiz_flow_title"));
		return element;
	}

	public WebElement getFirstOption(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/quiz_option_layout']//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvquiz_option_name']"));
		return element;
	}

	public WebElement getSecondOption(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/quiz_option_layout']//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvquiz_option_name'])[2]"));
		return element;
	}

	public WebElement getNextButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnNextQuiz"));
		return element;
	}

	public WebElement getQuizResultScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id = 'com.topfan.TopFan.TestApp:id/quiz_flow_title' and @text='Quiz Results']"));
		return element;
	}

	public WebElement getDoneQuizButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/quiz_flow_completed_done"));
		return element;
	}

	public WebElement getCompleteQuizButton(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnCompleteQuiz'])["
						+ index + "]"));
		return element;
	}

	public WebElement getCompletedQuizAlertText(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/frg_dialog_msg']"));
		return element;
	}

	public WebElement getTab(WebDriver driver, String title) {
		WebElement element = driver.findElement(
				By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='" + title + "']"));
		return element;
	}

	public WebElement getTakeAnotherQuizButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnTakeAnotherQuiz"));
		return element;
	}

	public WebElement getQuizzesButtonSelected(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Quizzes' and @selected='true']"));
		return element;
	}

	public WebElement getAnswerResult(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvquiz_option_name'])[1]"));
		return element;
	}

	public List<WebElement> ticksQuizAnswer(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/quiz_option_tick_image"));
		return elements;
	}
	
	public WebElement getScoreSigleQuestion(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvChallengeCoinAmount"));
		return element;
	}

	public WebElement getFinalScoreQuiz(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvpointsCompleted"));
		return element;
	}

	public WebElement getScoreFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_coins"));
		return element;
	}

	public List<WebElement> getAllCards(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/cardLayout"));
		return elements;
	}

	public WebElement getAccessUnavailableMessage(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));
		return element;
	}

	public WebElement getPollsOption(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/optionView1"));
		return element;
	}

	public By getLocatorForAMetaDataCard() {
		By by = By.id("com.topfan.TopFan.TestApp:id/bottom_meta_data_bar");
		return by;
	}

	public List<WebElement> getAllMetaDataCards(WebDriver driver) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.RelativeLayout"));
		elements.remove(0);
		return elements;
	}

	public WebElement getFrame(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
		return element;
	}

	public WebElement getDeviceStatusBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/statusBarBackground"));
		return element;
	}

	public WebElement getActionBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_bar"));
		return element;
	}

	public WebElement getTabLayout(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tab_layout"));
		return element;
	}

	public WebElement getATextView(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView"));
		return element;
	}

	public List<WebElement> getStartQuizButtons(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/btnStartQuiz"));
		return elements;
	}

	public By getLocatorOfQuestionScreen() {
		By by = By.id("com.topfan.TopFan.TestApp:id/quiz_flow_title");
		return by;
	}

	public WebElement getQuestionScreenHeader(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/quiz_flow_actionbar"));
		return element;
	}

	public By getLocatorForProfileImage() {
		By by = By.id("com.topfan.TopFan.TestApp:id/profile_image_thumb");
		return by;
	}

	public WebElement getCardType(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("//android.support.v7.app.ActionBar.Tab[@index='" + index + "']/android.widget.TextView"));
		return element;
	}

	public WebElement getEachCardType(WebDriver driver, String cardType) {
		WebElement element = driver.findElement(
				By.xpath("//android.widget.HorizontalScrollView//android.widget.TextView[@text='" + cardType + "']"));
		return element;
	}

	public WebElement getEmailTextBoxOnWebView(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter email address']"));
		return element;
	}

	public WebElement getSendButtonOnForgotPasswordPage(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.Button"));
		return element;
	}

	public List<WebElement> getAllTextViews(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//android.widget.TextView"));
		return elements;
	}

	public WebElement getVideoCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvVideoTitle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvVideoTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMetadataVideoCardTitle(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/meta_data_title'])["
						+ index + "]"));
		return element;
	}

	public WebElement getAudioCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvAudioName"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvAudioName'])[" + index + "]"));
		return element;
	}

	public WebElement getArticleCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvTitleArticle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitleArticle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getChallengeCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvChallengeTitle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvChallengeTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getProductCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvTitleMerchandise"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitleMerchandise'])["
						+ index + "]"));
		return element;
	}

	public WebElement getRewardCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvTitle"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitle'])[" + index + "]"));
		return element;
	}

	public WebElement getSocialCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvTitlesocial"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitlesocial'])["
						+ index + "]"));
		return element;
	}

	public WebElement getDiscussionCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvDiscussionCaption"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvDiscussionCaption'])["
						+ index + "]"));
		return element;
	}

	public WebElement getPhotoCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvTitle"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitle'])[" + index + "]"));
		return element;
	}

	public WebElement getComicCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvDiscussionTitle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvDiscussionTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getPollCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvPollsTitle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvPollsTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getQuizCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvQuizTitle"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvQuizTitle'])[" + index + "]"));
		return element;
	}

	public WebElement getGifCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvGIFTitle"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvGIFTitle'])[" + index + "]"));
		return element;
	}

	public WebElement getVRCardTitle(WebDriver driver, int index) {
		// WebElement element =
		// driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvVideoTitle"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvVideoTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMetadataVRCardTitle(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/meta_data_title'])["
						+ index + "]"));
		return element;
	}

	public List<WebElement> getALLCTACardsUnderArticleTab(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/btnCallToAction"));
		return elements;
	}

	public WebElement getFirstCTACard(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnCallToAction"));
		return element;
	}

	public WebElement getChromeUrlBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.android.chrome:id/url_bar"));
		return element;
	}

	public List<WebElement> getTextViewsOnActionBar(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath(
				"//android.view.View[@resource-id='com.topfan.TopFan.TestApp:id/action_bar']/android.widget.TextView"));
		return elements;
	}

	public List<WebElement> getOptionsOnPollCard(WebDriver driver, int index) {
		List<WebElement> elements = driver.findElements(By.xpath("//android.widget.Button[@text='Vote'][" + index
				+ "]//ancestor::android.widget.RelativeLayout[@resource-id='com.topfan.TopFan.TestApp:id/cardLayout']//descendant::android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/poll_option_tick_image']"));
		return elements;
	}

	public WebElement getMainElementOfVideoCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivVideoPlayerState'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfMetadataVideoCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/meta_data_title'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfAudioCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivAudioPlayerState'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfArticleCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivImage'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfChallengeCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnCallToAction'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfProductCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitleMerchandise'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfRewardCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvCaption'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfSocialCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTitlesocial'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfDiscussionCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivImage'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfPhotoCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivImage'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfComicCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnJoinLiveChat'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfPollCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnvote'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfQuizCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivImage'])[" + index + "]"));
		return element;
	}

	public WebElement getMainElementOfGifCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/gifiImage_blur'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfMetadataVRCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivVideoPlayerState'])["
						+ index + "]"));
		return element;
	}

	public WebElement getMainElementOfVRCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivImage'])[" + index + "]"));
		return element;
	}

	public By getLocatorForAMetadataCard() {
		By by = By.id("com.topfan.TopFan.TestApp:id/ivImage");
		return by;
	}

	public By getLocatorOfCommentEditText() {
		By by = By.id("com.topfan.TopFan.TestApp:id/_mm_edit_text");
		return by;
	}

	public By getLocatorOfActionBar() {
		By by = By.xpath("//android.view.View[@resource-id='com.topfan.TopFan.TestApp:id/action_bar']");
		return by;
	}

	public WebElement getForumButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/action_community"));
		return element;
	}

	public WebElement getActivityButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/imgBell"));
		return element;
	}

	public WebElement getPlusButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/menu_new"));
		return element;
	}

	public WebElement getEditTextOnPostScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/mojiEditText"));
		return element;
	}

	public WebElement getPostButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvPost"));
		return element;
	}

	public WebElement getUserNameOfFirstCardAfterTrendingCards(WebDriver driver, int index) {
		// WebElement element = driver.findElement(By.xpath(
		// "(//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/rootViewForum'])[1]//descendant::android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvUserName']"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvUserName'])[" + index + "]"));
		return element;
	}

	public WebElement getStatusLevelOfFirstCardAfterTrendingCards(WebDriver driver, int index) {
		// WebElement element = driver.findElement(By.xpath(
		// "(//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/rootViewForum'])[1]//descendant::android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvUserLevel']"));
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvUserLevel'])[" + index + "]"));
		return element;
	}

	public WebElement getPostMessageOfFirstCardAfterTrendingCards(WebDriver driver, int index) {
		// WebElement element = driver.findElement(By.xpath(
		// "(//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/rootViewForum'])[1]//descendant::android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvDiscussionTitle']"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvDiscussionTitle'])["
						+ index + "]"));
		return element;
	}

	public WebElement getUpArrowIcon(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivAttachment"));
		return element;
	}

	public WebElement getSkipOverlayButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/overlay_skip"));
		return element;
	}

	public WebElement getSkipButtonForImageCaptured(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/overlay_skip"));
		return element;
	}

	public WebElement getSaveCapturedImageButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.motorola.MotGallery2:id/filtershow_done"));
		return element;
	}

	public WebElement getMainImageOfFirstCardAfterTrendingCards(WebDriver driver, int index) {
		// WebElement element = driver.findElement(By.xpath(
		// "(//android.widget.LinearLayout[@resource-id='com.topfan.TopFan.TestApp:id/rootViewForum'])[1]//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivDiscussionImage']"));
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivDiscussionImage'])["
						+ index + "]"));
		return element;
	}

	public WebElement radioButtonLocator(WebDriver driver) {
		WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/input_adds_check_box"));
		return element;
	}
	
	public WebElement textViewLocator(WebDriver driver) {
		WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest"));
		return element;
	}
	
	public WebElement toastButtonLocator(WebDriver driver) {
		WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/showToastButton"));
		return element;
	}
	
	public WebElement textBoxLocator(WebDriver driver) {
		WebElement element = driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"));
		return element;
	}

	public By getLocatorOfProgressBar() {
		By by = By.xpath("//android.widget.ProgressBar[@resource-id='com.topfan.TopFan.TestApp:id/progressbar']");
		return by;
	}
	

	public By getLocatorForAForumCard() {
		By by = By.id("com.topfan.TopFan.TestApp:id/rootViewForum");
		return by;
	}

	public List<WebElement> getAllCardsOnForumScreen(WebDriver driver) {
		List<WebElement> elements = driver.findElements(
				By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout"));
		return elements;
	}

	public WebElement getFirstLikeButtonForum(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivLike"));
		return element;
	}

	public WebElement getFirstCommentButtonForum(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivComment"));
		return element;
	}

	public WebElement getFirstForumCommentText(WebDriver driver) {
		WebElement element;
		try {
			element = driver.findElement(By.xpath(
					"(//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout[1]//*[@resource-id='com.topfan.TopFan.TestApp:id/tvCommentsText']"));
		} catch (Exception e) {
			element = null;
		}
		return element;
	}

	public WebElement getForumCommentTextOnPostWithIndex(WebDriver driver, int index) {
		WebElement element;
		try {
			element = driver
					.findElement(By.xpath("(//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout["
							+ index + "]//*[@resource-id='com.topfan.TopFan.TestApp:id/tvCommentsText']"));
		} catch (Exception e) {
			element = null;
		}
		return element;
	}

	public WebElement getForumCommentTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/_mm_edit_text"));
		return element;
	}

	public WebElement getForumCommentPostButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/makemoji_post_tv"));
		return element;
	}

	public WebElement getForumPostButtonForNewPost(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvPost"));
		return element;
	}

	public WebElement getForumAddNewPostButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/menu_new"));
		return element;
	}

	public WebElement getForumPostTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/mojiEditText"));
		return element;
	}

	public WebElement getForumPostUsingText(WebDriver driver, String postText) {
		WebElement element = driver
				.findElement(By.xpath("(//android.widget.ListView[@index=0])[1]//android.widget.TextView[@text='"
						+ postText + "']//ancestor::android.widget.LinearLayout[2]"));
		return element;
	}

	public List<WebElement> getAllVisiblePostInForum(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By.xpath("(//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout"));
		return elements;
	}

	public WebElement getTextFromPost(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("(//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout[" + index
						+ "]/android.widget.LinearLayout[1]/android.widget.TextView"));
		return element;
	}

	public WebElement getFollowingButtonForum(WebDriver driver, String tabText) {
		WebElement element = driver
				.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + tabText + "')]"));
		return element;
	}

	public WebElement getFollowingNoPost(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@index=2]"));
		return element;
	}

	public WebElement getFirstUserOfForum(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("((//android.widget.ListView[@index=0])[1]//android.widget.TextView)[1]"));
		return element;
	}

	public WebElement getFollowButtonFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnUnchecked"));
		return element;
	}

	public WebElement getUnfollowButtonFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnChecked"));
		return element;
	}

	public WebElement scrollToNextPost(WebDriver driver, String user, int index) {
		WebElement element = ((AndroidDriver<?>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + user + "\").instance("
						+ index + "));");
		return element;
	}

	public List<WebElement> getAllVisiblePosts(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By.xpath("(//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout"));
		return elements;
	}

	public WebElement getPostUserName(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("((//android.widget.ListView[@index=0])[1]/android.widget.LinearLayout[" + index
						+ "]/android.widget.LinearLayout[1]//android.widget.TextView)[1]"));
		return element;
	}

	public WebElement getSearchButtonForum(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/search"));
		return element;
	}

	public WebElement getBuyHoursDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'1 hour')]"));
		return element;
	}

	public WebElement getBuyTwoHoursDropDown(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'2 hours')]"));
		return element;
	}

	public WebElement getCoinsButtonOnFanWall(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnBuy"));
		return element;
	}

	public WebElement getTextBoxFanWallForum(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/mojiEditText"));
		return element;
	}

	public WebElement getPostFanWallForum(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvPost"));
		return element;
	}

	public WebElement getUserProfileScore(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_coins"));
		return element;
	}

	public List<WebElement> getAllTabFromForum(WebDriver driver) {
		List<WebElement> elements = driver
				.findElements(By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView"));
		return elements;
	}

	public WebElement getUserNameFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_text_name"));
		return element;
	}

	public WebElement getMyActivityHeader(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//android.widget.TextView[@index='1'])[1]"));
		return element;
	}

	public WebElement getActivityTab(WebDriver driver, String tabName) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='" + tabName + "']"));
		return element;
	}

	public WebElement getDiscussionTextFromActivity(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("(//android.widget.ListView[@index=0])[1]//android.widget.RelativeLayout[" + index
						+ "]/android.widget.TextView[1]"));
		return element;
	}

	public WebElement getDotsOfActivity(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("(//android.widget.ListView[@index=0])[1]//android.widget.RelativeLayout[" + index
						+ "]/android.widget.ImageView[2]"));
		return element;
	}

	public WebElement getLeaveDiscussion(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/title"));
		return element;
	}

	public WebElement getClearConversation(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/title"));
		return element;
	}

	public WebElement getFirstDiscussionText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/message_text"));
		return element;
	}

	public WebElement getMessageButtonFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_button_message"));
		return element;
	}

	public WebElement getMessageTextBoxFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/_mm_edit_text"));
		return element;
	}

	public WebElement getPostButtonFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/makemoji_post_tv"));
		return element;
	}

	public WebElement getFirstMessageText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/message_text"));
		return element;
	}

	public WebElement getGuestLoginButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/button_login"));
		return element;
	}

	public WebElement getTrendingTextOnForumCard(WebDriver driver, int index) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvTrending'])[" + index + "]"));
		return element;
	}

	public WebElement getAllNotificationsTextFromActivity(WebDriver driver, int index) {
		WebElement element = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/title_textview")).get(index);
		return element;
	}

	public WebElement getActivityBadgeText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/notification_count"));
		return element;
	}

	public WebElement getFollowingFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_friends_layout"));
		return element;
	}

	public WebElement getSearchIconProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/search"));
		return element;
	}

	public WebElement searchUserResultFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvUserName"));
		return element;
	}

	public WebElement searchTextBoxFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/search_src_text"));
		return element;
	}

	public WebElement getGuestRegisterNowButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/button_register' and @text='Register Now']"));
		return element;
	}

	public WebElement getFacebookButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnFacebookConnect"));
		return element;
	}

	public WebElement getProgressBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/progress_level"));
		return element;
	}

	public WebElement getUserScore(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/textview_points"));
		return element;
	}

	public WebElement getEditProfileButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnEditProfile"));
		return element;
	}

	public WebElement getFirstNameFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_firstname"));
		return element;
	}

	public WebElement getLastNameFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_lastname"));
		return element;
	}

	public WebElement getUsernameFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_username"));
		return element;
	}

	public WebElement getPasswordFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_password"));
		return element;
	}

	public WebElement getEmailFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_email"));
		return element;
	}

	public WebElement getBirthdateFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnBirthdate"));
		return element;
	}

	public WebElement getGenderFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnGender"));
		return element;
	}

	public WebElement getLocationFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/etRegisterLocation"));
		return element;
	}

	public WebElement getBioFieldInEditProfileSection(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/user_bio"));
		return element;
	}

	public WebElement getNoFollowingOrFollowerUsersMessage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvNoContent"));
		return element;
	}

	public WebElement getFollowerFromProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_followers_layout"));
		return element;
	}

	public List<WebElement> getAllFollowersInFollowersSection(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/username"));
		return elements;
	}

	public WebElement getDrawerLayoutProfileScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/drawerLayout"));
		return element;
	}

	public WebElement getFirstFollowingUser(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/discussion_textview"));
		return element;
	}

	public By getLocatorOfProgressBarOnProfileScreen() {
		By by = By.id("com.topfan.TopFan.TestApp:id/progress");
		return by;
	}

	public WebElement getAvatarImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_image_bg"));
		return element;
	}

	public WebElement getTakePhotoOption(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Take Photo']"));
		return element;
	}

	public WebElement getPhotoFromGalleryOption(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Photo from Gallery']"));
		return element;
	}

	public WebElement getProfileImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/profile_image_thumb"));
		return element;
	}

	public WebElement getGiveGiftButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnGiveGift"));
		return element;
	}

	public WebElement getFirstGiftOption(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvCoinCost'])[1]"));
		return element;
	}

	public WebElement getSendGiftButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnSendGift"));
		return element;
	}

	public WebElement getMyGiftsButton(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/btnMyGifts"));
		return element;
	}

	public WebElement getFirstGiftTitle(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvGiftInfo"));
		return element;
	}

	public By getLocatorOfGiveGiftButton() {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnGiveGift");
		return by;
	}

	public By getLocatorOfFirstGiftOption() {
		By by = By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvCoinCost'])[1]");
		return by;
	}

	public By getLocatorOfMyGiftsButton() {
		By by = By.id("com.topfan.TopFan.TestApp:id/btnMyGifts");
		return by;
	}

	public By getLocatorOfGiftName() {
		By by = By.id("com.topfan.TopFan.TestApp:id/tvGiftName");
		return by;
	}

	public WebElement getGiftName(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvGiftName"));
		return element;
	}

	public WebElement getMessageTextFromActivity(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/message_text'])["
						+ index + "]"));
		return element;
	}

	public By getLocatorOfProgressBarTextOnForumScreen() {
		By by = By.id("com.topfan.TopFan.TestApp:id/frg_dialog_title");
		return by;
	}

	public WebElement getReferralUserNameEditTextBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/d_referral_edit_user_name"));
		return element;
	}

	public WebElement getSubmitButtonOnReferral(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/d_referral_button_submit_layout"));
		return element;
	}

	public WebElement getPhotoCardFromFeed(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ListView//android.widget.LinearLayout)[1]//*[@resource-id='com.topfan.TopFan.TestApp:id/ivImage']"));
		return element;
	}

	public WebElement getUnlockTextPhotoCard(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"(//android.widget.ListView//android.widget.LinearLayout)[1]//*[@resource-id='com.topfan.TopFan.TestApp:id/tap_to_join_text']"));
		return element;
	}

	public WebElement getPhotosCoinAccessPopUp(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/button2"));
		return element;
	}

	public WebElement getZoomedImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/icon"));
		return element;
	}

	public List<WebElement> getAllVotedButtons(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/btnvoted"));
		return elements;
	}

	public List<WebElement> getProgressBarsOfAUsedPollCard(WebDriver driver, int index) {
		List<WebElement> elements = driver.findElements(
				By.xpath("(//android.widget.Button[@resource-id='com.topfan.TopFan.TestApp:id/btnvoted'])[" + index
						+ "]//ancestor::android.widget.RelativeLayout[@resource-id='com.topfan.TopFan.TestApp:id/cardLayout']//descendant::android.widget.ProgressBar"));
		return elements;
	}

	public WebElement getRewardEarnedOnCompletingPoll(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.TextView[@resource-id='com.topfan.TopFan.TestApp:id/tvpollCoinAmount'])["
						+ index + "]"));
		return element;
	}

	public WebElement getAppSpecificStatusBar(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(
				"//android.view.View[@resource-id='android:id/statusBarBackground' and @package='com.topfan.TopFan.TestApp']"));
		return element;
	}

	public WebElement getFirstDiscussion(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/message_text"));
		return element;
	}

	public WebElement getConversationScreen(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/custom_header_title"));
		return element;
	}

	public WebElement getPostFanWall(WebDriver driver) {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/tvUserName"));
		return element;
	}

	public List<WebElement> getAllFeedTitles(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/tvUserName"));
		return elements;
	}

	public WebElement getFeedAvatar(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id='com.topfan.TopFan.TestApp:id/ivUserPicture'])["
						+ index + "]"));
		return element;
	}

	public List<WebElement> getAllChallengeCardTitles(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.id("com.topfan.TopFan.TestApp:id/tvChallengeTitle"));
		return elements;
	}

	public WebElement getImageFrame(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.FrameLayout"));
		return element;
	}

	public WebElement getActionBarOnSaveImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("android:id/action_bar"));
		return element;
	}

	public WebElement getFrameOnSaveImage(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout"));
		return element;
	}

	public WebElement getPostedImage(WebDriver driver) throws Exception {
		WebElement element = driver.findElement(By.id("com.topfan.TopFan.TestApp:id/ivDiscussionImage"));
		return element;
	}
}