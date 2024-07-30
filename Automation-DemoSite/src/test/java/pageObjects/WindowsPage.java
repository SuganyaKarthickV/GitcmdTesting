package pageObjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public WindowsPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='dropdown-toggle'][contains(text(),\"SwitchTo\")]")
	public WebElement switchToMenu;
	
	@FindBy(xpath="//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[2]/a")
	private WebElement windowsOption;
	
	
	@FindBy(xpath="//a//button[@class='btn btn-info']")
	public WebElement clickButton;
	
	//@FindBy(xpath="//a[@class='analystic'][contains(text(),\"Open New Seperate Windows\")]")
	@FindBy(xpath="/html/body/div[1]/div/div/div/div/ul/li[2]")
	public WebElement separateWindow;
	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement secondClickButton;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div/ul/li[3]")
	public WebElement separateMultipleWindows;
	
	@FindBy(xpath="//button[@onClick='multiwindow()']")
	public WebElement thirdClickButton;
	
	
	public void selectSwitchTo()
	{
		switchToMenu.click();
	}

	public void selectWindowsOption()
	{
		windowsOption.click();
	}

	public void firstClickButton()
	{
		String parentTab=driver.getWindowHandle();
		clickButton.click();
		Set<String> childTab=driver.getWindowHandles();
		for(String handles:childTab)
		{
			if(!handles.equals(parentTab))
			{
			driver.switchTo().window(handles);
			break;
			}
		}
		System.out.println(driver.getCurrentUrl());
		int totalWindows=driver.getWindowHandles().size();
		System.out.println(totalWindows);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
		//driver.switchTo().defaultContent();  
	    driver.switchTo().window(parentTab);
		
	}
	
	public void selectNewSeperateWindow()
	{
		
		separateWindow.click();
		
	}
	
	public void clickSecondButton()
	{
		String currentWindow=driver.getWindowHandle();
		secondClickButton.click();
		Set<String> newWindow=driver.getWindowHandles();
		for(String Whandles:newWindow)
		{
			
			driver.switchTo().window(Whandles);
			
		}
		System.out.println(driver.getCurrentUrl());
		int totalWindows=driver.getWindowHandles().size();
		System.out.println(totalWindows);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
		//driver.switchTo().defaultContent();  
	    driver.switchTo().window(currentWindow);
	}
	
	public void selectMultipleWindows()
	{
		separateMultipleWindows.click();
	}
	
	public void clickThirdButton() throws InterruptedException
	{
		String oldWindow=driver.getWindowHandle();
		thirdClickButton.click();
		Set<String> totalWindow=driver.getWindowHandles();
		for(String thandles:totalWindow)
		{
			if(!thandles.equals(oldWindow))
			driver.switchTo().window(thandles);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Thread.sleep(30);
			System.out.println(driver.getCurrentUrl());
			int totalWindows=driver.getWindowHandles().size();
			System.out.println(totalWindows);
			driver.close();
			
		}
		
		
		//driver.close();
		//driver.switchTo().defaultContent();  
	    //driver.switchTo().window(oldWindow);
	}



}
