package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
//	String osName = System.getProperty("os.name");
//	String projectPath = System.getProperty("user.dir");

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
//			if (osName.contains("Windows")) {
//				System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			} else {
//				System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//				driver = new FirefoxDriver();
				driver = WebDriverManager.firefoxdriver().create();
//			}

		} else if (browserName.equalsIgnoreCase("chrome")) {
//			if (osName.contains("Windows")) {
//				System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//			} else {
//				System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//				driver = new ChromeDriver();
//			}
				driver = WebDriverManager.chromedriver().create();
 	}
	

		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	protected String getEmailRandom() {
		Random rand = new Random();
		return "xuyen" + rand.nextInt(99999) + "@gmail.com";
	}
	protected void closeBrowser() {
		if(driver== null) {
			System.out.println("Browser is closed");
		}
		else {
			driver.quit();
		}
	}
}
