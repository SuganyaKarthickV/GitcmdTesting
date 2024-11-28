package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

	public static void main(String[] args) throws InterruptedException {
	

		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver-win64 new\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Agni"+Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
		}

	

}
