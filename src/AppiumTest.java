import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.html5.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;

import io.appium.java_client.*;
import io.appium.java_client.android.*;
import io.appium.java_client.ios.*;

public class AppiumTest {
	
	public static void main(String[] args) throws MalformedURLException, IOException {

		System.out.println("Run started");
		String browserName = "mobileOS";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
		String host = "myHost.perfectomobile.com";		
		capabilities.setCapability("user", "myUser");
		capabilities.setCapability("password", "myPassword");
		capabilities.setCapability("deviceName", "12345");
		capabilities.setCapability("automationName", "Appium");

		// setExecutionIdCapability(capabilities);

		AndroidDriver driver = new AndroidDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
		// IOSDriver driver = new IOSDriver(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
		
		try {
			// write your code here

			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// In case you want to down the report or the report attachments, do it here.
			/* try {
				RemoteWebDriverUtils.downloadReport(driver, "pdf", "C:\\test\\report");
				RemoteWebDriverUtils.downloadAttachment(driver, "video", "C:\\test\\report\\video", "flv");
				RemoteWebDriverUtils.downloadAttachment(driver, "image", "C:\\test\\report\\images", "jpg");
			} catch (Exception e) {
				e.printStackTrace();
			} */

			driver.quit();
		}
		
		System.out.println("Run ended");
	}
	
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	// Recommended:
	// Remove the comment and use this method if you want the script to share the devices with the recording plugin.\
	// Requires import com.perfectomobile.selenium.util.EclipseConnector;
	/*
 	private static void setExecutionIdCapability(DesiredCapabilities capabilities) throws IOException {
		EclipseConnector connector = new EclipseConnector();
		String executionId = connector.getExecutionId();
		capabilities.setCapability(EclipseConnector.ECLIPSE_EXECUTION_ID, executionId);
	}
	 */
	
}
