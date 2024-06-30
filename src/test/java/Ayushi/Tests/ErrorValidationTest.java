package Ayushi.Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ayushi.TestComponents.BaseTest;
import Ayushi.pageObject.CartPage;
import Ayushi.pageObject.ProductCatalogue;


public class ErrorValidationTest extends BaseTest{
	
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer= Ayushi.TestComponents.Retry.class )
	public void LoginErrorMessage() {
	 
    //Login Page
    
    //Wait for products to appear on screen
    lp.loginApplication("ayushis302@gmail.com","Ayus123@");    
    Assert.assertEquals("Incorrect email password.", lp.getLoginError());  
}
	@Test
	public void ProductErrorValidation() throws InterruptedException {
		
		String productName= "ZARA COAT 3";
		ProductCatalogue pc= lp.loginApplication("ayushis1409@gmail.com","Ayushi123@");
	    List<WebElement> products=pc.getProductList();
	    
	   //Wait for product to add in cart
	    pc.addProductToCart(productName);
	    CartPage cart=pc.goToCart();
	    
	    //Cart page where product is present then clicking on Checkout
	    Boolean match=cart.VerifyProductDisplay("ZARA PRODUCT 33");
	    Assert.assertFalse(match);
	}
}
