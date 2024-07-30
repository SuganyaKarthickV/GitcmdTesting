package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Argument;

public class RegisterPage {

	
	private WebDriver driver;
	WebDriverWait wait;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched'])[1]")
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	private WebElement firstName;
	
	//@FindBy(xpath="(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required ng-touched'])[2]")
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
	private WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
	private WebElement address;
	
	@FindBy(xpath="//*[@id=\"eid\"]/input")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@name='radiooptions']")
	private List<WebElement> rd_gender;
	
	//@FindBy(xpath="//label[@class='checks']")                                        
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> ch_hobbies;
	
	@FindBy(xpath="//multi-select//div[@id='msdd']")
	private WebElement dd_languages;
	
	@FindBy(xpath="//select[@id='Skills']")
	private WebElement dd_skills;
	
	@FindBy(xpath="//select[@id='countries']")
	private WebElement dd_country;
	
	//@FindBy(xpath="//span[@id='select2-country-container']")
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single']")
	private WebElement dd_selectCountry;
	
	@FindBy(xpath="//select[@id='yearbox']")
	private WebElement dd_dobYear;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	private WebElement dd_dobMonth;
	
	@FindBy(xpath="//select[@id='daybox']")
	private WebElement dd_dobDay;
	
	@FindBy(xpath="//input[@id='firstpassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='secondpassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//button[@id='submitbtn']")
	private WebElement submit;
	
	@FindBy(xpath="//button[@id='Button1']")
	private WebElement refresh;
	
	@FindBy(xpath="//*[@id=\"imagesrc\"]")
	private WebElement chooseFileButton;
	
	public void enterFirstName(String fName)
	{
		try {
			
			firstName.sendKeys(fName);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No such element found");
		}
	}
	
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
	}
	
	public void enterAddress(String adr)
	{
		address.sendKeys(adr);
	}
	
	public void enterEmail(String emailId)
	{
		email.sendKeys(emailId);
	}
	
	public void enterPhone(String ph)
	{
		phone.sendKeys(ph);
	}
	
	public void selectGenderRadioButton(String gender)
	{
		
		/*System.out.println("Before:" + rd_gender.isSelected());
		if(!(rd_gender.isSelected()))
		{
			rd_gender.click();
		}
		System.out.println("After:" + rd_gender.isSelected());*/
		/*for(int i=0;i<=rd_gender.size();i++)
		{
			WebElement radioOption=rd_gender.get(i);
			String value=radioOption.getAttribute("value");              //in register testcase we have to assign it as if(value.equalIgnoreCase("Male")){ radioOption.click(); break; }
		}*/
		
		for (WebElement radioOption : rd_gender) {
            if (radioOption.getAttribute("value").equalsIgnoreCase(gender)) {
            	radioOption.click();
                break;
            }
		}
	}
	
	public void selectHobbiesCheckbox(List<String> hobbies)
	{
		for(WebElement options:ch_hobbies)
		{
			System.out.println("Checking option: " + options.getAttribute("value"));
			if(hobbies.contains(options.getAttribute("value")))
			{
				System.out.println("Clicking option: " + options.getAttribute("value"));
				if (!options.isSelected()) 
				{
                    options.click();
			    }
			}
			else
					{
					if (options.isSelected()) 
					options.click(); // Deselect if already selected but not in the list
		            }
			}
	}
	
	public void selectLanguages(String lang)
	{
		
		dd_languages.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li")));
		//List<WebElement> langList=driver.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li"));
		
		//li[@class='ng-scope']//a
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ng-scope']//a")));
		List<WebElement> langList=driver.findElements(By.xpath("//li[@class='ng-scope']//a"));
		
		//Select selectOption=new Select(dd_languages);
		System.out.println("checking options");
		
		for(WebElement languages:langList)
		{
			//System.out.println(languages.getText());
			String selectedLang=languages.getText();
			System.out.println(selectedLang);
			if(selectedLang.equalsIgnoreCase(lang));
			{
				languages.click();
				break;
			}
			/*if(lang.contains(selectedLang))
			{
				System.out.println("Selecting languages: +selectedLang");
				languages.click();
			}*/
		}
		// Click outside the dropdown to close it
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].blur();", dd_languages);

	    System.out.println("Language is selected and dropdown closed");
	}
	
	public void selectSkills(String skill)
	{
		Select skillsDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(dd_skills)));
	    skillsDropdown.selectByVisibleText(skill);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//dd_skills.click();
		/*Select skill=new Select(driver.findElement( dd_skills));
		List<WebElement> skillOptions= skill.getOptions();
		System.out.println(skillOptions.size());
		/*for(WebElement e :skillOptions)
		{
			
		}*/
		
	}
	
	
	public void selectSelectCountry(String country)
	{
		dd_selectCountry.click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(country);
		
		System.out.println("Select the country from the given list");
	
		List<WebElement> countryList=driver.findElements(By.xpath("//ul[@id='select2-country-results']"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		for(WebElement ele:countryList)
		{
		String currentOption=ele.getText();
		if(currentOption.equalsIgnoreCase(country))
		{
			ele.click();
			break;
		}
		
	    }
		System.out.println("country is selected");
	}
	
	public void selectDOB(String year,String month,String day)
	{
		Select dob_year = new Select(wait.until(ExpectedConditions.elementToBeClickable(dd_dobYear)));
		dob_year.selectByVisibleText(year); 
		Select dob_month = new Select(wait.until(ExpectedConditions.elementToBeClickable(dd_dobMonth)));
		dob_month.selectByVisibleText(month); 
		Select dob_day = new Select(wait.until(ExpectedConditions.elementToBeClickable(dd_dobDay)));
		dob_day.selectByVisibleText(day); 
	}
	
	
	public void enterPassword(String pwd1)
	{
		password.sendKeys(pwd1);
	}
	
	public void enterConfirmPassword(String pwd2)
	{
		confirmPassword.sendKeys(pwd2);
	}
	
	public void selectChooseFile(String path) throws AWTException
	{
	    //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chooseFileButton);
	    //WebElement fileInput=wait.until(ExpectedConditions.elementToBeClickable(chooseFileButton));
		chooseFileButton.sendKeys(path);
	    
	    //chooseFileButton.click();
	    System.out.println("Button clicked");
		/*Robot robot =new Robot();
		
		//store the path of the file to be uploaded using StringSelection class object
		StringSelection filePath=new StringSelection("C:\\Users\\Sahana Karthick\\Desktop\\sports product images\\diablo.jpg");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//now press control
		robot.keyPress(KeyEvent.VK_CONTROL);
		//now press v
		robot.keyPress(KeyEvent.VK_V);
		
		//release v
		robot.keyRelease(KeyEvent.VK_V);
		//release control
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//press enter
		robot.keyPress(KeyEvent.VK_ENTER);
		
		//release enter
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		
		System.out.println("File uploaded successfully using Robot Class");
		
		
	}
	
	/*public void selectRefresh()
	{
		refresh.click();
	}*/
}