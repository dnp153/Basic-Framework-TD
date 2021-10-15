package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "username")
	public WebElement emailBox;
	@FindBy(name = "password")
	public WebElement passwordBox;
	@FindBy(id = "error")
	public WebElement errorMessage;
	
	public void openBrowser() throws IOException {
		FileInputStream fin = new FileInputStream("C:\\Users\\dnp15\\OneDrive\\Desktop\\QA\\prop.properties");
		Properties prop = new Properties();
		prop.load(fin);
		String browser = prop.getProperty("browser");

		if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\dnp15\\OneDrive\\Desktop\\QA\\SeleniumJars\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\dnp15\\OneDrive\\Desktop\\QA\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\dnp15\\OneDrive\\Desktop\\QA\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this);
	}

	public void openLoginPage() {
		driver.get(
				"https://authentication.td.com/uap-ui/index.html?consumer=easyweb&locale=en_CA#/login/easyweb-getting-started");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void login(String userName, String password) throws InterruptedException {
		emailBox.sendKeys(userName);
		passwordBox.sendKeys(password);

		passwordBox.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
	}

	public String readError() {
		String actualErr = errorMessage.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
