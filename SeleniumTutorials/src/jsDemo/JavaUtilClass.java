package jsDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaUtilClass {

	public static void clickElementByJS(WebElement element,WebDriver driver)
	{
		JavaScriptExecutor js=((JavaScriptExecutor) driver);
		js.executeScript("arguments[0].click();" , element);
	}
}
