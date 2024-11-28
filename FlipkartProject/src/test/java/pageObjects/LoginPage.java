	package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 50);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@class='uiU-ZX']")
	private WebElement loginText;
	
		
	@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
	private WebElement emailOrMobile;
	
	@FindBy(xpath="//button[@class='QqFHMw twnTnD _7Pd1Fp']")
	private WebElement requestOTP;
	
	@FindBy(xpath="//span[contains(text(),'Account')]")
	private WebElement userProfileIcon;
	
	
	
	public void clickLoginText()
	{
		
		JavascriptExecutor executor1=(JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()",loginText);
	}

	
	public void enterMobileNo(String mobileNo)
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(emailOrMobile)).sendKeys(mobileNo);
	}
	
	public void clickRequestOTP()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(requestOTP)).click();
	}
	
	public boolean isUserLoggedIn()
	{
		return userProfileIcon.isDisplayed();
	}
}

