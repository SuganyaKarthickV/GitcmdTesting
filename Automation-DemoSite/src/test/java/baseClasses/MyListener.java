package baseClasses;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentReportUtil.ExtentManager;

public class MyListener implements ITestListener 
{
	
	private static final Logger logger=LogManager.getLogger(MyListener.class);
	private static ExtentReports extent=ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties properties= BaseClass.getProperties();
    
    /*static {
        try {
            BaseClass.loadConfig(); // Initialize properties in BaseClass
            properties = BaseClass.getProperties(); // Retrieve initialized properties
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error loading configuration: " + e.getMessage());
        }
    }*/
	@Override
	public void onStart(ITestContext context)
	{
		/*try {
			BaseClass.initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("WebDriver initialized");*/
		logger.info("Test suite started");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		//BaseClass.quitDriver();
		ExtentManager.flush();
        logger.info("ExtentReports flushed");
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        logger.info("Test Started: " + result.getMethod().getMethodName());
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        logger.info("Test Passed: " + result.getMethod().getMethodName());
    }
	
	@Override
	public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
        logger.error("Test Failed: " + result.getMethod().getMethodName());
    }

	@Override
	public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
        logger.warn("Test Skipped: " + result.getMethod().getMethodName());
    }

	public static WebDriver getDriver() {
        return driver.get();
    }

}

