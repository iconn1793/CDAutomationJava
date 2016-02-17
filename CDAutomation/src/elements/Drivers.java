package elements;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public abstract class Drivers {
	
	public static AppiumDriver<WebElement> driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String appiumServerAddress = "127.0.0.1";
	public static String appiumServerPort = "4723";
	
	public WebDriverWait wait = new WebDriverWait(driver, 20);
	public TouchAction action = new TouchAction(driver);
	public int screenWidth = driver.manage().window().getSize().getWidth();
	public int screenHeight = driver.manage().window().getSize().getHeight();
	public static boolean IOSEnabled = false;
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			new VariableCheck().environmentVariable();
			new DeviceReader().checkDevice();
			new AppPath().findApp();
		} 
		
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
			DeviceReader.AndroidDevice = true;
		}
		
		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.LOG_NO_COLORS)
				.withIPAddress(appiumServerAddress)
				.usingPort(Integer.parseInt(appiumServerPort)));
			
		if (!IOSEnabled && DeviceReader.IOSDevice && !DeviceReader.AndroidDevice) {
				System.out.println("Running test on iOS device");
				capabilities.setCapability("platformName", "IOS");
				capabilities.setCapability("platformVersion", "");
				capabilities.setCapability("deviceName", "iPhone 6");
				capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
				capabilities.setCapability("udid", "12b78bfcd3c6eb45ac80d9d6038db4f87a64e965");
				driver = new IOSDriver<>(service, capabilities);
			}
			
		if ((IOSEnabled && (DeviceReader.IOSDevice || DeviceReader.AndroidDevice)) || (!DeviceReader.IOSDevice && !DeviceReader.AndroidDevice)) {
				System.out.println("Running test on iOS simulator");
				capabilities.setCapability("platformName", "IOS");
				capabilities.setCapability("platformVersion", "");
				capabilities.setCapability("deviceName", "");
				capabilities.setCapability("noReset", true);
				capabilities.setCapability("nativeInstrumentsLib", true);
				capabilities.setCapability("bundleId", "com.mentionmobile.cyberdust");
				capabilities.setCapability("app", AppPath.localAppPath);
				driver = new IOSDriver<>(service, capabilities);
			}
		
		if (!IOSEnabled && DeviceReader.AndroidDevice) {
				System.out.println("Running test on Android device");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "");
				capabilities.setCapability("deviceName", "");
				capabilities.setCapability("appPackage", "com.radicalapps.cyberdust");
				capabilities.setCapability("appActivity", "com.radicalapps.cyberdust.activities.LauncherActivity");
				driver = new AndroidDriver<>(service, capabilities);
			}

		service.start();
	}
	
	@AfterClass
	public static void tearDown() {
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.stop();
		driver.quit();
	}
	
	// Checks if device is Android
	public boolean Android() {
		if (capabilities.getCapability("platformName").equals("Android")) {
			return true;
		} else {
			return false;
		}
	}
	
	// Checks if device is iOS
	public boolean IOS() {
		if (capabilities.getCapability("platformName").equals("IOS")) {
			return true;
		} else {
			return false;
		}
	}
	
	// For calling the Android driver from other classes
	public static AndroidDriver<WebElement> aDriver() {
		return (AndroidDriver<WebElement>) driver;
	}
	
	// For calling the iOS driver from other class
	public static IOSDriver<WebElement> iDriver() {
		return (IOSDriver<WebElement>) driver;
	}
	
	// Relaunches the app
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	// Prints text to console and to a log file in the project folder / test logs folder
	public void log(String text) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation = new String();
		
		String dateTime = LocalDateTime.now().format(formatter)+" ";
		String logName = getClass().getPackage().toString().replace("package ", "");
		String testName = ("["+getClass().getSimpleName()+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("iOS_", "");
		
		if (projectPath.contains("/")) {
			new File(projectPath+"/testlogs/").mkdir();
			logLocation = projectPath+"/testlogs/"+logName+".log";
		} else {
			new File(projectPath+"\\testlogs\\").mkdir();
			logLocation = projectPath+"\\testlogs\\"+logName+".log";
		}
		
		if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception") 
				|| text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
			System.err.print(dateTime + testName + text + "\n");
		} else {
			System.out.print(dateTime + testName + text + "\n");
		}
		
		try {
			FileWriter myWriter = new FileWriter(logLocation, true);
			myWriter.append(dateTime + testName + text + "\n");
			myWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}