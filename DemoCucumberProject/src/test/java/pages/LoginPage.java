package pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
		wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	/*@FindBy(xpath="//h6[text()='Dashboard']")
	private By dashboardTitle;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorMessage;*/
	
	private By dashboardTitle=By.xpath("//h6[text()='Dashboard']");
	private By errorMessage=By.xpath("//p[text()='Invalid credentials']");
	
	public void enterUsername(String uname)
	{
		wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(uname);
		//username.sendKeys(uname);
	}
	
	public void enterPassword(String pname)
	{
		password.sendKeys(pname);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public String getLoginMessage()
	{
		try
		{
			WebElement dashboardElement=wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
			if(dashboardElement.isDisplayed()) {
				return dashboardElement.getText();
			}
			
		}
		catch(TimeoutException e) {
			
				WebElement errorElement= wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
	            if (errorElement.isDisplayed()) {
	                return errorElement.getText(); 
	            
			}
			
		}
		return "Unknown";
	}
	            
	
		
		
	}
		
			
		
	

