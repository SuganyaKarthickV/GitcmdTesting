package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDandTablepage {

	WebDriver driver;
	WebDriverWait wait;
	
	public DDandTablepage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath="//label[text()='Employee Name']/preceding::div[@class='oxd-select-text-input']")
	private WebElement userroleDD;
	
	@FindBy(xpath="//label[text()='User Role']/following::span[text()='Admin']")
	private WebElement adminOption;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement search;
	
	//@FindBy(xpath="//div[@class='oxd-table-body']")
	@FindBy(xpath="//div[@class='oxd-table-card']")
	private List<WebElement> tableRows;
	
	//@FindBy(xpath="//div[@class='orangehrm-container']//div[@class='oxd-table-header']")
	@FindBy(xpath="//div[@class='orangehrm-container']//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']")
	private List<WebElement> tableheaders;
	
	
	public void clickAdmin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(admin)).click();
	}
	
	public void ddclick() throws InterruptedException
	{
		Thread.sleep(20);
		wait.until(ExpectedConditions.elementToBeClickable(userroleDD)).click();
		
	}
	
	public void optionClick()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adminOption);*/
		wait.until(ExpectedConditions.elementToBeClickable(adminOption)).click();
	}
	
	public void searchButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
	}
	
	public boolean verifyColumnResults(String columnName, String expectedValue) {
        int columnIndex = getColumnIndex(columnName); // Find the column index dynamically

        for (WebElement row : tableRows) {
            List<WebElement> dataCells = row.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));
            System.out.println("Row data cells: " );
            for(WebElement datacell : dataCells)
            {
            	System.out.println(datacell.getText());
            }
            // Validate index range to prevent errors
            if (columnIndex <= dataCells.size()) {
                String cellValue = dataCells.get(columnIndex - 1).getText(); // Adjust for 0-based index
                if (!cellValue.contains(expectedValue)) {
                    return false; // If any cell doesn't match, return false
                }
            } else {
                throw new RuntimeException("Column index " + columnIndex + " is out of range for the given row.");
            }
        }
        return true;
    }
	
	// Calculate total rows in the table
    public int getTotalRowCount() {
        return tableRows.size(); // Return the count of rows
    }

    //  Get column index dynamically by column name
    private int getColumnIndex(String columnName) {
        for (int i = 0; i < tableheaders.size(); i++) {
            if (tableheaders.get(i).getText().equalsIgnoreCase(columnName)) {
                return i + 1; // Return index + 1 for XPath (1-based index)
            }
        }
        throw new RuntimeException("Column " + columnName + " not found!");
    }
}
