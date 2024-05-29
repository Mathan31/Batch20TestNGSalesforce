package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import util.ExcelReader;
import util.PropertyReader;

public class BaseClass {
	
	public WebDriver driver; // 123456
	public String fileName = "Environment";
	public String sBrowser = PropertyReader.readDataFromPropertyFile(fileName, "Browser");
	public String sURL = PropertyReader.readDataFromPropertyFile(fileName, "URL");
	public String excelFileName = "";
	
	@BeforeClass
	public void invokeBrowser() {
		switch (sBrowser.toLowerCase()) {
		case "chrome":
			System.out.println("User option is "+sBrowser+",So invoking chrome browser");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println("User option is "+sBrowser+",So invoking edge browser");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.out.println("User option is "+sBrowser+",So invoking firefox browser");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("User option is wrong "+sBrowser+",So invoking the default chrome browser");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterClass	
	public void closeBrowser() {
		driver.quit();
	}
	
	@DataProvider(name="TestCaseData")
	public Object[][] excelData() {
		Object[][] values = ExcelReader.getValueFromExcel(excelFileName);
		return values;
	}

}
