package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectablePage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public SelectablePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='Default']//li[@class='ui-widget-content'][4]")
	private WebElement defaultSelect;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[1]/ul/li[2]")
	private WebElement serialize;
	
	@FindBy(xpath="//ul[@class='SerializeFunc']/li")
	private List<WebElement> selectOptions;
	
	
	
	public void defaultOption()
	{
		defaultSelect.click();
	}
	
	public void serializeOption()
	{
		serialize.click();
		//wait.until(ExpectedConditions.elementToBeClickable(serialize));
		System.out.println("selected");
		
		Actions actions= new Actions(driver);
		/*actions.keyDown(Keys.CONTROL).click(selectOptions.get(1))
				.click(selectOptions.get(3))
						.click(selectOptions.get(5)).build().perform();*/
		
		actions.clickAndHold(selectOptions.get(1));
		actions.clickAndHold(selectOptions.get(3));
		actions.clickAndHold(selectOptions.get(5));
		actions.clickAndHold(selectOptions.get(2));
		actions.build().perform();
		
         System.out.println(selectOptions.size());		
		
		
	}
}
