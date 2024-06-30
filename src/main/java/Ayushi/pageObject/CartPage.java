package Ayushi.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
    public CartPage(WebDriver driver) {
		
    	super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="//div[@class='cartSection']/h3")
    List<WebElement> productsCart;
    
    @FindBy(css="li[class='totalRow'] button[type='button']")
    WebElement Checkout;
    
    public boolean VerifyProductDisplay(String productName) {
    	
    	boolean match= productsCart.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage CheckoutButton() {
    	Checkout.click();
    	return new CheckoutPage(driver);
    	
    	
    }


}