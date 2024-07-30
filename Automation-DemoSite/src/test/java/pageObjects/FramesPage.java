package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesPage {

	private WebDriver driver;
	WebDriverWait wait;
	
	public FramesPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="singleframe")
	private WebElement frame;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement inputBox;
	
	//@FindBy(xpath="//li[@class='active']//a[@class='analystic']")
	//@FindBy(xpath="/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")
	@FindBy(xpath="/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]")
	private WebElement nestedFrameOption;
	
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']")
	private WebElement nestedFrame1;
	
	@FindBy(xpath="//div[@class='iframe-container']//iframe[@src='SingleFrame.html']")
	private WebElement nestedFrame2;
	
	
	
	public void moveToFrame(String msg) throws InterruptedException
	{
		driver.switchTo().frame(frame);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" ,inputBox);
		Thread.sleep(30);
		inputBox.sendKeys(msg);
		
	}
	
	public void clickNestedFrame()
	{
		driver.switchTo().defaultContent();
		nestedFrameOption.click();
		driver.switchTo().frame(nestedFrame1);
		driver.switchTo().frame(nestedFrame2);
		
		
	}
	
}
