package Framework.practice;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePageTest extends BaseClass{

	private AndroidDriver<AndroidElement> driver;
	
	
	
//	HomePage home = new HomePage(driver);
//	Utilities util = new Utilities(driver);
//	Checkout checkout = new Checkout(driver);

//	@BeforeClass
//	public void setup() throws MalformedURLException, IOException {
//		driver = Capabilities();
//	}
	
	@Test
	public void averifyTestCase() throws MalformedURLException, IOException {
		
		driver = Capabilities();
		
		HomePage home = new HomePage(driver);
		Utilities util = new Utilities(driver);
		
		home.fillTextBox("hello ehab");
		home.selectFemaleRadioButton();
		home.expandDDL();
//		util.scrollToAragentina();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		home.selectArgentina();
		home.clickOnSubmit();
//		service.stop();
		
	}
	
//	@Test
//	public void completeTest() {
//		
//		Checkout checkout = new Checkout(driver);
//		
//		checkout.getData();
//	}
}
