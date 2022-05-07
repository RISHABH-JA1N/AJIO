package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver = null;
	String browserName;

	Properties config = new Properties();
	FileInputStream fis;

	@Parameters({"url"})
	//@BeforeGroups("regression")
	@BeforeSuite(alwaysRun = true)
	//@BeforeSuite
	public void setup(String siteUrl) {
		try {

			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		browserName = config.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--ignore-ssl-errors");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}

		//driver.get(config.getProperty("url"));
		driver.get(siteUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwait")),TimeUnit.SECONDS);

	}

	@AfterSuite(groups={"sanity","regression"})
	public void tearDown() {
		driver.quit();
	}

}
