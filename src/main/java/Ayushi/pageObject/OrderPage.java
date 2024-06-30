package Ayushi.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
    public OrderPage(WebDriver driver) {
		
    	super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath="//tr/td[2]")
    List<WebElement> OrderHistory;
  
    
    public boolean VerifyOrderDisplay(String productName) {
    	
    	boolean match= OrderHistory.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
        return match;
    }



}