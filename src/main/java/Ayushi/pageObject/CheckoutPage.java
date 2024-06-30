package Ayushi.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-results button")
	List<WebElement> options;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	public void selectCountry(String name) {
		
		country.sendKeys(name);	
		
	}
	
	public void findCountry() {
		for(WebElement option:options) {
	    	if(option.getText().equalsIgnoreCase("India")) {
	    		option.click();
	    		break;
	}
 }
}
  public ConfirmPage SubmitButton() {
	  submit.click();
	  return new ConfirmPage(driver);
	 
  }

}
