package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_Base {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static String browser;
	public static Logger log;

	@BeforeSuite
	public void openBrowser() throws Throwable {

		fis = new FileInputStream("./src/test/java/config/config.properties");
		prop = new Properties();
		prop.load(fis);
		browser = prop.getProperty("browser");
		log = Logger.getLogger("FD_FrameWork");
		PropertyConfigurator.configure("./src/test/java/config/Log4j.properties");
		if (browser.equalsIgnoreCase("chrome")) {
			log.info("Chrome Browser selected");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
			driver = new ChromeDriver();
			log.info("Chrome driver opened");
		} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("url")+" opened");
		driver.manage().window().maximize();
		log.info("window maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("implicity wait applied");
	}

	@AfterSuite
	public static void close() {
		driver.quit();
		log.info("driver closed");
	}

}
