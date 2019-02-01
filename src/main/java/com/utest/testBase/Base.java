package com.utest.testBase;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utest.excelDataReader.ExcelDataReader;
import com.utest.logs4j.Log4jResource;

public class Base {

	public WebDriver driver;
	private ExcelDataReader excel = null;
	public ExtentHtmlReporter reporter = null;
	public ExtentReports extent = null;
	public static final Logger log = Logger.getLogger(Base.class);

	public WebElement element = null;

	public String userdir = System.getProperty("user.dir");;

	@BeforeMethod
	public void setUp() {
		init();
	}

	@AfterMethod
	public void closeBrowser(Method method) {

		driver.close();
		driver.quit();
	}

	/*
	 * Initializing Browser
	 */
	public void init() {
		String log4jConfPath = Log4jResource.getResourcePath("/src/main/resources/config_files/log4j.properties");
		PropertyConfigurator.configure(log4jConfPath);
		log.info("Selecting Broswer");
		selectBrowser();

		log.info("Browser Id is : " + "Chrome");

		log.info("Navigating to given URL : " + "https://www.utest.com");
		getURL();
	}

	/*
	 * Selecting a browser
	 */
	public void selectBrowser() {

		System.setProperty("webdriver.chrome.driver", userdir + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * System.setProperty("webdriver.gecko.driver", userdir +
		 * "/Drivers/geckodriver.exe"); driver = new FirefoxDriver();
		 */
	}

	/*
	 * Navigating to URL
	 */
	public void getURL() {

		driver.get("https://www.utest.com");
		driver.manage().window().maximize();
	}

	/*
	 * Explicit Wait
	 */
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilAllElementToBeVisible(WebDriver driver, List<WebElement> AllElements) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(AllElements));
	}

	/*
	 * This code is to take a screen shot for the pages
	 */
	public void getScreenShot(String screenName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(userdir).getAbsolutePath()
					+ "/src/main/java/com/css/CSSSelectorProject/screenshots/";
			File destFile = new File(
					(String) reportDirectory + screenName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(srcFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method is used to create extent reports
	 */
/*	public void generateExtentReports(String testName) {
		
		reporter = new ExtentHtmlReporter(userdir + "/src/main/java/com/utest/extentReports/uTestReports.html");
		extent = new ExtentReports();

		extent.attachReporter(reporter);

		ExtentTest logger = extent.createTest(testName);
		logger.log(Status.INFO, testName);
		logger.log(Status.PASS, "Passed");
		logger.log(Status.FAIL, "Failed");
		logger.log(Status.SKIP, "Skipped");
	}*/

	/*
	 * This block of code will be used to read excel data
	 */

	public String[][] getAllDataFromExcel(String excelName, String sheetName, String colName, int rowNum) {

		String path = userdir + "/src/main/java/com/utest/data/" + excelName;
		excel = new ExcelDataReader(path);

		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	/*
	 * Read CELL data from the excel sheet
	 */
	public String getCellDataFromExcell(String excelName, String sheetName, String colName, int rowNum) {

		String path = userdir + "/src/main/java/com/utest/data/" + excelName;
		excel = new ExcelDataReader(path);

		String data = excel.getCellDataFromSheet(sheetName, colName, rowNum);
		return data;
	}

}
