package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;




import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import jsDemo.JavaUtilClass;

public class UserLogin {

	

	@Test
	public void TradevivProject() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver-win64 new\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//driver.get("https://www.tradeviv.com/");
		//driver.manage().window().maximize();
		
		// click on the user icon 1st time to Login  //*[@id="page_wrapper"]/header/div[2]/div/div/div[2]/div/div[1]
		
		/*WebDriverWait wait= new WebDriverWait(driver, 50);
		WebElement usericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative']")));
		usericon.click();*/
		
		/*WebElement usericon=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative']"));
		JavascriptExecutor executor1=(JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()",usericon);*/
		
		
		
		
		
		// move to user login and click
		//driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div[1]/div/div/div[2]/div/div[2]/ul/li[2]")).click();
		
		
		// enter login credentials and click login button
		//driver.findElement(By.id("username")).sendKeys("suganyavasudevann@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("12345");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		//driver.findElement(By.name("login")).click();
		
		/*WebElement loginbtn=driver.findElement(By.name("login"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",loginbtn);*/
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		/*WebDriverWait wait1= new WebDriverWait(driver, 50);
		WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='login']")));
		login.click();*/
	
		
		
		
		//  click on the user icon 2nd time to Logout
		
		/*WebDriverWait afterLogin= new WebDriverWait(driver, 30);
		WebElement usericon1 = afterLogin.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("(a[class='has-dropdown d-flex align-items-center text-white text-decoration-none'])[2]")));
		usericon1.click();*/
		/*//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none']")).click();
		*/
		
	    //driver.findElement(By.xpath("//div[@class='d-flex align-items-center justify-content-end h-100 md-py-10']//i[@class='flaticon-user-3 flat-mini mx-auto text-dark']")).click();
		
		
		// using action class
		/*driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		WebElement usericon1=driver.findElement(By.xpath("(//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none'])[2]"));*/
		//WebElement userdashboard=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='User Dashboard']"));
		//WebElement Trackorder=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='Track Orders']"));
		//WebElement Logout = driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//span[@class='dropdown-item'][normalize-space()='Logout']"));
	
		//act.moveToElement(usericon1).click(). build().perform();
		//act.moveToElement(userdashboard).build().perform();
		//act.moveToElement(Trackorder).build().perform();
		//act.moveToElement(Logout).click().build().perform();
		
		
		//using javascript executor
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		//WebElement usericon1=driver.findElement(By.xpath("(//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none'])[2]"));
		//WebElement usericon1=driver.findElement(By.xpath("//div[@class='row sign-in my-account-dropdown position-relative show']//a[@class='has-dropdown d-flex align-items-center text-white text-decoration-none']"));
		
		//JavaUtilClass.clickElementByJS(usericon1, driver);
	
	
		
		/*Thread.sleep(5000);
		driver.findElement(By.cssSelector("#page_wrapper > header > div.main-nav.d-lg-block.d-none.py-3 > div > div > div.col-xl-6 > div > div.row.sign-in.my-account-dropdown.position-relative > a")).click();
	
		driver.findElement(By.xpath("(//span[@class='dropdown-item'][text()='Logout'])[1]")).click();*/
		
		/*WebDriverWait wait1= new WebDriverWait(driver, 100);
		WebElement usericon1 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#page_wrapper > header > div.main-nav.d-lg-block.d-none.py-3 > div > div > div.col-xl-6 > div > div.row.sign-in.my-account-dropdown.position-relative > a")));
		usericon1.click();*/
	
		String username = null;
		String password =null;
	
		// Read data from Excel
		
		String filePath="C:\\Users\\Sahana Karthick\\Desktop\\Tradeviv login credentials.xlsx";
		FileInputStream inputstream =new FileInputStream(filePath);
		
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("sheet1");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		System.out.println(rows);
		int logincount=0;
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row= sheet.getRow(r);  // 0
			
			for(int c=0;c<cols;c++)
				{
				XSSFCell cell=row.getCell(c);
				if(c==0)
				{
					username=cell.getStringCellValue();
				}
				if(c==1)
				{
					password =cell.getStringCellValue();
				}
				/*switch (cell.getCellType())
				{
				case STRING :System.out.print(cell.getStringCellValue()); break;
				case NUMERIC :System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN :System.out.print(cell.getBooleanCellValue()); break;
				}*/
				
				//System.out.print(" | ");
				}
			
			driver.get("https://www.tradeviv.com/");
			driver.manage().window().maximize();
			
			// Usericon click before login
			WebDriverWait wait= new WebDriverWait(driver, 50);
			WebElement usericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='row sign-in my-account-dropdown position-relative'])[1]")));
			usericon.click();
			
			
			// click login option
			driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/header/div[1]/div/div/div[2]/div/div[2]/ul/li[2]")).click();
			
			System.out.println("User Name :" + username +  "Password:" + password);
			
			// send datas in login page
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			
			// click login button
			WebElement loginbtn=driver.findElement(By.name("login"));
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()",loginbtn);
			Thread.sleep(5000);
			
			//click usericon after login
			driver.findElement(By.cssSelector("#page_wrapper > header > div.main-nav.d-lg-block.d-none.py-3 > div > div > div.col-xl-6 > div > div.row.sign-in.my-account-dropdown.position-relative > a")).click();
			
			// click logout option
			driver.findElement(By.xpath("(//span[@class='dropdown-item'][text()='Logout'])[1]")).click();  
			
			
			// count no.of login attempts
			logincount++;
			System.out.println("Total no.of login attempts:" + logincount );
			
			
			
			//System.out.println();
			
		}
		
	}
	
		// Read data from excel using iterator method 
	
		/*Iterator iterator=Sheet1.iterator();
	
	
		while(iterator.hasNext())
		{
			
		}*/

}
