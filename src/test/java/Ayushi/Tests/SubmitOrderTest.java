package Ayushi.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Ayushi.TestComponents.BaseTest;
import Ayushi.pageObject.CartPage;
import Ayushi.pageObject.CheckoutPage;
import Ayushi.pageObject.ConfirmPage;
import Ayushi.pageObject.OrderPage;
import Ayushi.pageObject.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productName= "ZARA COAT 3";
	@Test(dataProvider= "getData", groups= {"Purchase"})
	public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		    
    //Login Page
    
    //Wait for products to appear on screen
    ProductCatalogue pc= lp.loginApplication(input.get("email"),input.get("password"));
    List<WebElement> products=pc.getProductList();
    
   //Wait for product to add in cart
    pc.addProductToCart(input.get("productName"));
    CartPage cart=pc.goToCart();
    
    //Cart page where product is present then clicking on Checkout
    Boolean match=cart.VerifyProductDisplay(input.get("productName"));
    Assert.assertTrue(match);
    
    //Selecting country from dropdown
    CheckoutPage cp=cart.CheckoutButton();    
    cp.selectCountry("IND");
    cp.findCountry();
    
    
   //Confirming the thank you message
    ConfirmPage page= cp.SubmitButton();;
    String confirmMessage= page.getConfirmationMessage();    
    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    
	}

	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistory() {
		
		ProductCatalogue pc= lp.loginApplication("ayushis302@gmail.com","Ayushi123@");
		OrderPage order= pc.goToOrder();
		
		Assert.assertTrue(order.VerifyOrderDisplay(productName));
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data= getJsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\Ayushi\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
/*	@DataProvider
	public Object[][] getData() {
		
		return new Object[][]
		{
		{"ayushis302@gmail.com","Ayushi123@","ZARA COAT 3"},{"ayushis1409@gmail.com","Ayushi123@","ADIDAS ORIGINAL"}
		
		};
	}*/

}
