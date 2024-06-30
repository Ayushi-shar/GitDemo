package Ayushi.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ayushi.pageObject.CartPage;
import Ayushi.pageObject.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
    WebElement cartButton;
	
	@FindBy(css="[routerlink*='myorders']")
    WebElement orderButton;
	
	public void waitForElementToAppear(By findBy) {
		
		
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(15));
	    w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
    public void waitForWebElementToAppear(WebElement FindBy) {
		
		
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(15));
	    w.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void waitForElementToDisappear(WebElement productAddedMessage) throws InterruptedException {
		
		Thread.sleep(1000);
		//WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(15));
		//w.until(ExpectedConditions.invisibilityOf(productAddedMessage));
	}
	
    public CartPage goToCart() throws InterruptedException 
    {	
    	Thread.sleep(5000);
		cartButton.click();	
		CartPage cart= new CartPage(driver);
		return cart;
	}
    
    public OrderPage goToOrder()  
    {	
    	
		orderButton.click();	
		OrderPage order= new OrderPage(driver);
		return order;
}
    
}
