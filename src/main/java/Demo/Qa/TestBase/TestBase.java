package Demo.Qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import Demo.Qa.Util.Util;
import Demo.Qa.Util.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver fDriver;
	public static WebEventListner eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"D:\\Eclipse_Neon_Workspace\\SeleniumDemoProject\\src\\main\\java\\Demo\\Qa\\Config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browserName=prop.getProperty("BrowserName");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Divyaa\\Desktop\\Selenium\\DriverFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Divyaa\\Desktop\\Selenium\\DriverFiles\\gecko.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Divyaa\\Desktop\\Selenium\\DriverFiles\\IE.exe");
			driver = new InternetExplorerDriver();
		}
		fDriver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListner();
		fDriver.register(eventListener);
		driver=fDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Util.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
	}
	
}
