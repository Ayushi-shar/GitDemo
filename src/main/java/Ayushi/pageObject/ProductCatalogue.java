package Ayushi.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	

    WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
    	this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(css=".mb-3")
    List<WebElement> products;
    
    @FindBy(css=".ng-animating")
    WebElement productAddedMessage;
    
    
    
    By productby= By.cssSelector(".mb-3");
    By addtoCart= By.cssSelector(".card-body button:last-of-type");
    By toastMessage= By.cssSelector(".toast-container");
    
    public List<WebElement> getProductList() {
    	
    	waitForElementToAppear(productby);
    	return products;    	
    }
    
    public WebElement getProductName(String productName) {
    	
    	WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b"))
    			.getText().equals(productName)).findFirst().orElse(null);        
        return prod;
    }
    
    public void addProductToCart(String productName) throws InterruptedException {
    	WebElement prod= getProductName(productName);
    			prod.findElement(addtoCart).click();
    			
    			waitForElementToAppear(toastMessage);
    			waitForElementToDisappear(productAddedMessage);
    	
    }
    
    
}
