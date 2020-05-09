package Framework.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Utilities extends BaseClass{
//	public static AndroidDriver<AndroidElement> driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	public String scrolltoText(String text) {
//		return "new UiScrollable(new UiSelector()).scrollIntoView(text(\\\""+text+"\\\"));";
//	}
	
	public void scrollToAragentina() {

		driver.findElementByAndroidUIAutomator("new UiScrollable"
				+ "(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	}
	
	public static void takeScreenshotUtil(String filename) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/Users/Ehab/eclipse-workspace/practice/resources/"+filename+".png"));
		
	}

}
