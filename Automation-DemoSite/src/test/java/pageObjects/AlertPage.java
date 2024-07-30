package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {

	private WebDriver driver;
	WebDriverWait wait;
	
	public AlertPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='dropdown-toggle'][contains(text(),\"SwitchTo\")]")
	public WebElement switchToMenu;
	
	//@FindBy(xpath="//li[@class='dropdown active']//li[1]//a")
	//@FindBy(linkText="Alerts.html")
	@FindBy(xpath="//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a")
	private WebElement AlertOption;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement okAlertBox;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")
	public WebElement okAndCancelAlert;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement confirmButton;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")
	public WebElement alertWithTextBox;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	public WebElement promptBox;
	
	public void clickSwitchTo()
	{
		switchToMenu.click();
	}
	
	public void clickAlert()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AlertOption)).click();
	}
	
	public void clickDisplayAlertBox()
	{
		okAlertBox.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Alert alert=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		alert.accept();
	}
	
	public void selectOkAndCancel()
	{
		okAndCancelAlert.click();
	}
	
	public void clickConfirmBox()
	{
		confirmButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Alert alert=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//alert.accept();
		alert.dismiss();
		
	}
	
	public void clickTextAlert()
	{
		alertWithTextBox.click();
	}
	
	public void clickPromptBox()
	{
		promptBox.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Alert alert=driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		alert.sendKeys("user");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		alert.accept();
	}
	
	

}
