package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeAndFurniturePage {
	
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomeAndFurniturePage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 50);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='_1ch8e_'][3]")
	private WebElement homeAndFurnitureCategory;

	@FindBy(xpath="(//a[@class='_3490ry'])[2]")
	private WebElement homeAndFurnitureSubCategory;
	
	
	@FindBy(xpath="//div[@class='slAVV4']")
	private List<WebElement> productList;
	
	@FindBy(xpath="(//div[@class='cPHDOP col-12-12'])[5]")
	private List<WebElement> productName;


	@FindBy(xpath="//div[@class='DOjaWF gdgoEp col-8-12']//li")
	private List<WebElement> productDetails;
	

	public void navigateTohomeAndFurniture()
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeAndFurnitureCategory);
		wait.until(ExpectedConditions.elementToBeClickable(homeAndFurnitureCategory)).click();
	}

	public void selectSubCategory()
	{
		wait.until(ExpectedConditions.elementToBeClickable(homeAndFurnitureSubCategory)).click();
		System.out.println("Navigated to HomeAndFurniture sub-category");
	}
	
	public void selectProduct(int index)
	{
		//Wait until all elements in the productList are visible
		 wait.until(ExpectedConditions.visibilityOfAllElements(productList));
		//Get the size of the productList
		 int productListSize = productList.size();
		 
		//check if the provided index is within the bounds of productList
		    if (index >= 0 && index < productListSize) {
		 	
		   // Get the product WebElement at the specified index
	        WebElement product = productList.get(index);
	     // Scroll the product element into view using JavaScript
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
	        
	     // Wait until the product element is clickable
	        wait.until(ExpectedConditions.elementToBeClickable(product));
	        try
	        {
	        	product.click();
	        }
	        
	        // If an ElementClickInterceptedException occurs, handle it by using JavaScript to click the element
	        catch (org.openqa.selenium.ElementClickInterceptedException e) {
                System.out.println("Click intercepted, trying again...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
	        }
	        
	        System.out.println("product is clicked successfully");
	     // Print out that the product has been selected successfully
	        System.out.println("Selected product at index: " + index );
	        
	            
	            }
		  
	}
	
	public String getProductName()
	{
		// Assuming product details page has a unique container element
	    WebElement productDetailsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']"))); // Replace with your container locator

	    // Find the product name element within the container using your verified XPath
	    WebElement productNameElement = productDetailsContainer.findElement(By.xpath("(//div[@class='cPHDOP col-12-12'])[5]"));  // Replace with your product name XPath
	    
	    // Extract and return the product name text
	    String productNameText= productNameElement.getText();
	    System.out.println("Product Name: " + productNameText);
        return productNameText;
		
	}

	
	
	public String getProductDetails() {
        StringBuilder details = new StringBuilder();
        for (WebElement detail : productDetails) {
        	
        	 details.append(detail.getText()).append("\n");
        }
        String detailsText = details.toString();
        System.out.println("Product Details: " + detailsText);
        return detailsText;
    }
	
	public List<String[]> getMultipleProductDetails(int numberOfProducts) {
		//initializes an empty list productDetailsList to store details of products.
        List<String[]> productDetailsList = new ArrayList<>();
      //stores the current window handle to return to the main window later.
        String originalWindowHandle = driver.getWindowHandle();
      //method loops through the number of products specified by numberOfProducts.
        for (int i = 0; i < numberOfProducts; i++) {
        	
             System.out.println("Product list size: " + productList.size());
             System.out.println("Getting details for product index: " + i);

          // Check if the product list contains elements
             if (productList.size() > i) {
                 
        	// Click on product from the productList
            selectProduct(i);
          //switches to the new window that opens after selecting a product.
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(originalWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            
          //waits for the product details container and product name element to be visible.
            WebElement productDetailsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container']")));
            WebElement productNameElement = productDetailsContainer.findElement(By.xpath("(//div[@class='cPHDOP col-12-12'])[5]"));
            
           
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DOjaWF gdgoEp col-8-12']//li")));
            
           
         // retrieves the product name and details
            String name = getProductName();
            //String price = getProductPrice();
            String details = getProductDetails();
            
         // If the product name or details are empty, it prints a message. Otherwise, it adds the product details to productDetailsList.
            if (name.isEmpty() || details.isEmpty()) {
                System.out.println("Product " + (i + 1) + " details are incomplete.");
            } else {
            productDetailsList.add(new String[]{name, details});
            }
            
          //Close New Window and Return to Main Window
            driver.close();
            driver.switchTo().window(originalWindowHandle);
            System.out.println("Navigated back to product list");
          //waits for the product list to be visible again.
            wait.until(ExpectedConditions.visibilityOfAllElements(productList));
             }else {
                 System.out.println("Product list does not contain enough elements.");
             }
            
            

    }
        return productDetailsList;
}
}
