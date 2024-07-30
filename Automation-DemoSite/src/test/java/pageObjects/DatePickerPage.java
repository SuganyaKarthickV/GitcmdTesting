package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPage {
	
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public DatePickerPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='form-control is-datepick']")
	private WebElement dateInput;
	
	@FindBy(xpath="//a[@class='datepick-cmd datepick-cmd-next ']")
	private WebElement next;
	
	@FindBy(xpath="//select[@title='Change the month']")
	private WebElement changeTheMonth;
	
	@FindBy(xpath="//select[@title='Change the month']//option[11]")
	private WebElement monthOption;
	
	@FindBy(xpath="//select[@title='Change the year']")
	private WebElement changeTheYear;
	
	@FindBy(xpath="//select[@title='Change the year']//option[1]")
	private WebElement upArrow;
	
	@FindBy(xpath="//select[@title='Change the year']//option[4]")
	private WebElement yearOption;
	
	@FindBy(xpath="//a[@title='Select Saturday, Nov 9, 1996']")
	private WebElement selectedDate;
	
	@FindBy(xpath="//a[@title='Clear all the dates']")
	private WebElement clear;
	
	@FindBy(xpath="//img[@class='imgdp']")
	private WebElement disabledDate;
	
	@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-w']")
	private WebElement previousArrow;
	
	@FindBy(xpath="(//a[@class='ui-state-default'])[24]")
	private WebElement date;
	
	
	
	public void datePickerEnabledInputBox()
	{
		//dateInput.sendKeys(date);
		dateInput.click();
		//next.click();
		wait.until(ExpectedConditions.elementToBeClickable(next));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		changeTheMonth.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		monthOption.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		changeTheYear.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		upArrow.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		yearOption.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//selectedDate.click();
		//WebElement date=wait.until(ExpectedConditions.elementToBeClickable(selectedDate));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedDate);
		System.out.println("date selected");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//dateInput.click();
		
		//driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.elementToBeClickable(dateInput));
		//clear.click();
	
		
	}
	

	public void datePickerDisabledInputBox()
	{
		disabledDate.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		previousArrow.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		date.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
