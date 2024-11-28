package jsDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptExecutor {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver-win64 new\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.tradeviv.com/");
		driver.manage().window().maximize();
		
		// click on the user icon 1st time to Login
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		WebElement usericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative']")));
		usericon.click();
		
		// move to user login and click
		driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div[1]/div/div/div[2]/div/div[2]/ul/li[2]")).click();
		
		
		// enter login credentials and click login button
		driver.findElement(By.id("username")).sendKeys("suganyavasudevann@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.name("login")).click();
		
		//  click on the user icon 2nd time to Logout
		
		/*WebDriverWait afterLogin= new WebDriverWait(driver, 30);
		WebElement usericon1 = afterLogin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none']")));
		usericon1.click();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none']")).click();
		*/
		
	    //driver.findElement(By.xpath("//div[@class='d-flex align-items-center justify-content-end h-100 md-py-10']//i[@class='flaticon-user-3 flat-mini mx-auto text-dark']")).click();
		
		
		// using action class
		/*driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		WebElement usericon1=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none']"));
		WebElement userdashboard=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='User Dashboard']"));
		WebElement Trackorder=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='Track Orders']"));
		WebElement Logout = driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='Logout']"));
	
		act.moveToElement(usericon1).click(). build().perform();
		act.moveToElement(userdashboard).build().perform();
		act.moveToElement(Trackorder).build().perform();
		act.moveToElement(Logout).click().build().perform();*/
		
		
		//using javascript executor
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement usericon1=driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div[2]/div/div/div[2]/div/div[1]/a"));
		
		JavaUtilClass.clickElementByJS(usericon1, driver);
	
	
	}
	

	}

