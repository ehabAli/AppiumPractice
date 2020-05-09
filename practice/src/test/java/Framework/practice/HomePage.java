package Framework.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	private AndroidDriver<AndroidElement> driver;
	

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleRadioButton;
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement dropDownList;
	
//	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\\\"Argentina\\\"));")

	public WebElement scrollToAregentina;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement selectArgentina;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement submitButton;
	
	
	public void fillTextBox(String text) {
		nameField.sendKeys(text);
	}
	
	
	public void selectFemaleRadioButton() {
		
		femaleRadioButton.click();
	}
	
	
	public void expandDDL() {
		dropDownList.click();
	}
	
	public void ScrollToText() {
//		driver.findElement(MobileBy.AndroidUIAutomator(
//				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + Text + "\"));"));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");	}
	public void selectArgentina() {
		selectArgentina.click();
	}
	
	
	public void clickOnSubmit() {
		submitButton.click();
	}
	
	
	
}
