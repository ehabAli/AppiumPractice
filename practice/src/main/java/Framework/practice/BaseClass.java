package Framework.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class BaseClass {
	
	public static AndroidDriver<AndroidElement> driver;
	
	
//	public static boolean checkIfServerOn(int port) {
//		boolean isServerRunning = false;
//		ServerSocket serverSocket;
//		try {
//			serverSocket = new ServerSocket(port);
//			serverSocket.close();
//			
//		} catch (Exception e) {
//			isServerRunning = true;
//		}finally {
//			serverSocket = null;
//		}
//		return isServerRunning;
//	}
	
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException, IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Framework/practice/global.properties");
		prop.load(file);
		prop.get("APP");
		
		File parentPath = new File("src");
		
		//select the App you want to test:
//		File fullPath = new File(parentPath, (String) prop.get("APP"));
//		File fullPath = new File(parentPath, "Splash.apk");
//		File fullPath = new File(parentPath, "WebView Test_v1.1.5_apkpure.com.apk");
		File fullPath = new File(parentPath, (String) prop.get("APP"));
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("DEVICE_NAME"));
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        
        //you should define ATOMATION_NAME capability for Android 6 and above
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //below capability is to define the duration per second for appium to wait until element is showing
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
        
		cap.setCapability(MobileCapabilityType.APP, fullPath.getAbsolutePath());
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;
	}
	
	public static void takeScreenshotUtil(String filename) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("/Users/Ehab/eclipse-workspace/practice/resources/"+filename+".png"));
		
	}
}
