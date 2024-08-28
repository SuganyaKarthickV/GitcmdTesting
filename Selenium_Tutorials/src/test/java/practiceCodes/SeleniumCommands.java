package practiceCodes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommands {
	
	static WebDriver driver;
	static Actions actions;
	
	static {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver-win64 new\\chromedriver 126\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Get commands
		//driver.get("https://www.google.com/");
		driver.get("https://the-internet.herokuapp.com/");
		
		actions=new Actions(driver);
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		//driver.get("https://www.flipkart.com/");
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current Url:"+ currentUrl);
		
		String title=driver.getTitle();
		System.out.println("Title:" + title);
		
		//String pageSource=driver.getPageSource();
		//System.out.println("Page Source:"+pageSource);
		
		//browser Commands
		//driver.close();
		//driver.quit();
		
		//Navigation commands
		
		//driver.navigate().to("https://www.amazon.in/");
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.close();
		//driver.quit();
		/*WebElement textBox=driver.findElement(By.id("APjFqb"));
		Actions actions =new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).perform();*/
		rightClick();
		dragAndDrop();
		dropDown();
		windows();
	}
	public static void rightClick() throws AWTException {
		//right click
		driver.findElement(By.xpath("//a[@href='/context_menu']")).click();
		
		
		WebElement rightClick=driver.findElement(By.id("hot-spot"));
		actions.contextClick(rightClick).perform();
		
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		//actions.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).perform();
		//driver.switchTo().defaultContent();
		//driver.navigate().refresh();
		//actions.moveByOffset(10, 10).click().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		driver.navigate().back();
	}
	
	public static void dragAndDrop() {
		//drag and drop
		driver.findElement(By.xpath("//a[@href=\"/drag_and_drop\"]")).click();
		
		
		WebElement drag1=driver.findElement(By.id("column-a"));
		WebElement drag2=driver.findElement(By.id("column-b"));
		actions.dragAndDrop(drag1, drag2).perform();
		driver.navigate().back();
	}
	
	public static void dropDown() throws InterruptedException {
		
		//dropdown
		
		driver.findElement(By.xpath("//a[@href=\"/dropdown\"]")).click();
		//WebElement dropdown=driver.findElement(By.id("dropdown"));
		//dropdown.click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
		select.selectByVisibleText("Option 1");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href=\"/entry_ad\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-footer']/p")))).click();
		//driver.findElement(By.xpath("//div[@class='modal-footer']/p")).click();
		Thread.sleep(20);
		driver.navigate().back();
	}
	
	public static void windows() {
		
		//windows
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href=\"/windows\"]")).click();
		String window1=driver.getWindowHandle();
		System.out.println("Name of the Parent Window:" + window1);
		driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String windowHandle:allWindows)
			if(!windowHandle.equals(window1))
			{
				driver.switchTo().window(windowHandle);
				System.out.println("Name of the child window:" + windowHandle);
				break;
			}
				
		driver.switchTo().window(window1);
		
		
		
		
	}

}
