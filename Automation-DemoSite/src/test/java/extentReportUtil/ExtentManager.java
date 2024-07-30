package extentReportUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import baseClasses.BaseClass;

public class ExtentManager {
	private static ThreadLocal<ExtentReports> extent=new ThreadLocal<>();
	static Properties properties;
	static {
        try {
            BaseClass.loadConfig();
            properties = BaseClass.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static ExtentReports getInstance() 
	{
		if (extent.get()==null)
		{
			extent.set(new ExtentReports());
		
		
		// Construct report path
		//String reportPath=properties.getProperty("extent.reporter.spark.out", "target/") + reportName + ".html"; 
		
		String reportName=generateReportName();
		// Create ExtentSparkReporter with the report path
		ExtentSparkReporter spark=new ExtentSparkReporter(reportName);
		
		// Load custom configuration
		String configPath=properties.getProperty("extent.reporter.spark.config","src/test/resources/extent-config.xml");
		try {
			spark.loadXMLConfig(configPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Failed to load ExtentReports config: " + configPath, e);
        }
		
		// Attach reporter to ExtentReports instance
		extent.get().attachReporter(spark);
		
		}
	
		return extent.get();
	}
	
	public static void flush()
	{
		if(extent.get()!=null)
		{
			extent.get().flush();
			extent.remove();
	
		}
	}

	private static String generateReportName() {
        String baseReportPath = properties.getProperty("extent.reporter.spark.out", "target/SparkReport_");
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return baseReportPath + timeStamp + ".html";
    }
}
