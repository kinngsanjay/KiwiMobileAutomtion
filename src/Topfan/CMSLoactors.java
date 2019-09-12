package Topfan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CMSLoactors {

	public static CMSLoactors getInstance() {
		CMSLoactors mHeader = null;
		try {
			mHeader = new CMSLoactors();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mHeader;
	}

	public WebElement emailFieldCMS(WebDriver driver) {
		WebElement element = driver.findElement(By.id("agent_email"));
		return element;
	}

	public WebElement passwordFieldCMS(WebDriver driver) {
		WebElement element = driver.findElement(By.id("agent_password"));
		return element;
	}

	public WebElement loginButtonCMS(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@class='btn']"));
		return element;
	}

	public List<WebElement> getAllCardsFromCMS(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//li[starts-with(@id,'carousel_feed')]"));
		return elements;
	}

	public WebElement showCardOnScreenFromCMS(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[contains(@id,'show_on_home_screen')]"));
		return element;
	}

	public WebElement getIsEnabledCheckbox(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//input[contains(@id,'client_challenge_feed_item_attributes_is_enabled')]"));
		return element;
	}

	public WebElement showCardOnScreenFromCarousel(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//input[@id='carousel_feed_feed_item_attributes_show_on_home_screen']"));
		return element;
	}

	public WebElement updateCarouselButtonOnCMS(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@class='btn primary']"));
		return element;
	}

	public WebElement getURLFromCarousel(WebDriver driver, CarouselType carousel) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + carousel + "')]"));
		return element;
	}

	public WebElement getFirstCardFromCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("(//tbody//tr//a)[1]"));
		return element;
	}

	public WebElement getTitleFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("(//label[contains(text(),'Title') or contains(text(),'Name')]/following-sibling::input)[1]"));
		return element;
	}

	public WebElement getDescriptionFromAddCarousel(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath("//label[contains(text(),'Description')]/following-sibling::*"));
		return element;
	}

	public WebElement getZoomedImageFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@class='zoomed_image']"));
		return element;
	}

	public WebElement getGIFImageFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("gif_gif"));
		return element;
	}

	public WebElement getChallengeBGColorFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_background_color"));
		return element;
	}

	public WebElement getChallengeTotalCompletionFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_participation_cap"));
		return element;
	}

	public WebElement getChallengeCompletionPerUserFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_per_user_participation_cap"));
		return element;
	}

	public WebElement getChallengePointValueFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_point_value"));
		return element;
	}

	public WebElement getChallengeStartDateFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_formatted_start_date"));
		return element;
	}

	public WebElement getChallengeEndDateFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("challenge_formatted_end_date"));
		return element;
	}

	public WebElement getChallengeClientAddCarousel(WebDriver driver, String client) {
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'" + client + "')]/input"));
		return element;
	}

	public WebElement getVideoURLFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("video_url"));
		return element;
	}

	public WebElement getRewardPointCostFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("reward_point_cost"));
		return element;
	}

	public WebElement getStockWarningQtyFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("reward_total_quantity_available"));
		return element;
	}

	public WebElement getURLFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@type='url']"));
		return element;
	}

	public WebElement getVirtualURLFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("virtual_reality_url"));
		return element;
	}

	public WebElement getFeedImageCheckBoxFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@class='feed_image_checkbox']"));
		return element;
	}

	public WebElement createButtonFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@name='commit']"));
		return element;
	}

	public WebElement destroyButtonForCard(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Destroy')]"));
		return element;
	}

	public WebElement getViewFromChallengesPage(WebDriver driver, String title) {
		WebElement element = driver.findElement(
				By.xpath("//a[contains(text(),'" + title + "')]/ancestor::tr//a[contains(text(),'View')]"));
		return element;
	}

	public WebElement getProductPriceFromAddCarousel(WebDriver driver) {
		WebElement element = driver.findElement(By.id("product_price"));
		return element;
	}

	public WebElement getZoomedImageOnId(WebDriver driver, String attribute) {
		WebElement element = driver.findElement(By.id(attribute));
		return element;
	}

	public List<WebElement> getCarouselsFromHomeScreen(WebDriver driver) {
		List<WebElement> element = driver.findElements(By.xpath("//li[contains(@id,'carousel_feed_')]"));
		return element;
	}

	public List<WebElement> getAllFeeds(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath("//li[starts-with(@id,'featured_feed')]//a"));
		return elements;
	}

	public WebElement getFeatureFeed(WebDriver driver) {
		WebElement element = driver.findElement(By.id("featured_feed_feed_item_attributes_is_enabled"));
		return element;
	}

	public WebElement getFeedTitle(WebDriver driver) {
		WebElement element = driver.findElement(By.id("featured_feed_name"));
		return element;
	}

	public WebElement getFeedHeroImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("featured_feed_header_image"));
		return element;
	}

	public WebElement getFeedAvatarImage(WebDriver driver) {
		WebElement element = driver.findElement(By.id("featured_feed_logo_image"));
		return element;
	}

	public WebElement getCreateFeed(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@name='commit']"));
		return element;
	}

	public WebElement getFeedWithTitle(WebDriver driver, String feed) {
		WebElement element = driver.findElement(By.xpath("//a[text()='" + feed + "']"));
		return element;
	}

	public WebElement getUpdate(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[@name='commit']"));
		return element;
	}

	public WebElement getCTATitle(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//li[starts-with(@id,'home_screen_cta_buttons') and contains(@id,'title_input')]/input)["
						+ index + "]"));
		return element;
	}

	public WebElement getCTAImage(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//input[starts-with(@id,'home_screen_cta_buttons') and contains(@id,'background_image')])["
						+ index + "]"));
		return element;
	}

	public WebElement getCTAContentTypeRadioBtn(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//input[starts-with(@id,'home_screen_cta_buttons') and contains(@id,'button_type_ct')])["
						+ index + "]"));
		return element;
	}

	public WebElement getCTASize(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//select[@class='cta_button_size']"));
		return element;
	}

	public WebElement getCTAContentTypeField(WebDriver driver, int index) {
		WebElement element = driver.findElement(
				By.xpath("(//select[starts-with(@id,'home_screen_cta_buttons') and contains(@id,'content_type')])["
						+ index + "]"));
		return element;
	}

	public WebElement getStatusBar(WebDriver driver) {
		WebElement element = driver.findElement(By.id("home_screen_user_status_bar"));
		return element;
	}

	public WebElement getHSCarouselCard(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("(//li[starts-with(@id,'carousel_feed')]//a[1])[" + index + "]"));
		return element;
	}

	public WebElement getHSFeedCard(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath("(//li[starts-with(@id,'featured_feed')]//a[1])[" + index + "]"));
		return element;
	}

	public WebElement getMainFeedCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("home_screen_hide_main_feed"));
		return element;
	}

	public List<WebElement> getFeedsFromHomeScreen(WebDriver driver) {
		List<WebElement> element = driver.findElements(By.xpath("//li[contains(@id,'featured_feed_')]"));
		return element;
	}

	public WebElement getCarouselItem(WebDriver driver, WebElement element) {
		element = element.findElement(By.xpath(".//div/a[1]"));
		return element;
	}

	public WebElement getHamburgerIconCheckBox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("client_hamburger_menu"));
		return element;
	}

	public WebElement getFirstFeedTopic(WebDriver driver) {
		WebElement element = driver
				.findElement(By.xpath(".//*[@class='featured_feeds sortable-list ui-sortable']/li[1]/div/a"));
		return element;
	}

	public WebElement getEditFeedButton(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(".//div[@class='adminsimple-action-column']/a[1]"));
		return element;
	}

	public WebElement getHeaderLogoCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.id("client_remove_feed_icon"));
		return element;
	}

	public String getVideoLocator() {
		String locator = ".//tbody[@id='video_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getAudioLocator() {
		String locator = ".//tbody[@id='audio_track_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getArticleLocator() {
		String locator = ".//tbody[@id='articles_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getChallengeLocator() {
		String locator = ".//tbody[@id='client_challenge_list']/tr[1]//descendant::a[text()='View']";
		return locator;
	}

	public String getSocialLocator() {
		String locator = ".//tbody[@id='social_item_list']/tr[1]/td[3]/a";
		return locator;
	}

	public String getProductLocator() {
		String locator = ".//tbody[@id='product_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getRewardLocator() {
		String locator = ".//tbody[@id='reward_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getDiscussionLocator() {
		String locator = ".//tbody[@id='discussion_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getPhotoLocator() {
		String locator = ".//tbody[@id='photo_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getComicLocator() {
		String locator = ".//tbody[@id='comic_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getPollLocator() {
		String locator = ".//tbody[@id='poll_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getQuizLocator() {
		String locator = ".//tbody[@id='quiz_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getGifLocator() {
		String locator = ".//tbody[@id='gif_list']/tr[1]/td[1]/a";
		return locator;
	}

	public String getVirtualRealityLocator() {
		String locator = ".//tbody[@id='virtual_reality_list']/tr[1]/td[1]/a";
		return locator;
	}

	public WebElement getFirstItemFromTable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	}

	public List<WebElement> getSocialIdentitiesItems(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.xpath(".//tbody/tr/td[3]/a[1]"));
		return elements;
	}

	public List<WebElement> getAccessLevelCheckboxes(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By
				.xpath(".//li[contains(@id,'feed_item_attributes_vip_access_input')]/ancestor::ol[1]/li/label/input"));
		return elements;
	}

	public WebElement getSingleAccessLevelCheckbox(WebDriver driver, int index) {
		WebElement element = driver
				.findElement(By.xpath(".//li[contains(@id,'feed_item_attributes_vip_access_input')]/ancestor::ol[1]/li["
						+ index + "]/label/input"));
		return element;
	}

	public WebElement getCardIsEnabledCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[contains(@id,'feed_item_attributes_is_enabled')]"));
		return element;
	}

	public WebElement getCardIsFeaturedCheckbox(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//input[contains(@id,'feed_item_attributes_featured')]"));
		return element;
	}

	public WebElement getFirstItemFromChallengeTable(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(".//tbody[@id='client_challenge_list']/tr[1]/td[1]/a"));
		return element;
	}

	public WebElement getFanWallState(WebDriver driver) {
		WebElement element = driver.findElement(By.id("client_fan_wall_toggle"));
		return element;
	}

	public WebElement getPhotosLockedState(WebDriver driver) {
		WebElement element = driver.findElement(
				By.xpath("//*[contains(text(),'Photos')]/preceding-sibling::td//input[contains(@id,'lock_photo')]"));
		return element;
	}

	public WebElement getFanWallText(WebDriver driver) {
		WebElement element = driver.findElement(By.id("fan_wall_name"));
		return element;
	}
	
	public WebElement getFeedTopicDropdown(WebDriver driver){
		WebElement element = driver.findElement(By.xpath("//select[@id='client_challenge_feed_item_attributes_featured_feed_id']"));
		return element;
	}
	
	public WebElement getContentTypeFilterCheckbox(WebDriver driver){
		WebElement element = driver.findElement(By.id("featured_feed_content_type_filter_switch"));
		return element;
	}

}
