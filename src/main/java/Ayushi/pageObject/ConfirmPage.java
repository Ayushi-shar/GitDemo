package Ayushi.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class ConfirmPage extends AbstractComponent {
	
	WebDriver driver;

    public ConfirmPage(WebDriver driver) {
    	super(driver);
		// TODO Auto-generated constructor stub
    	this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String getConfirmationMessage() {
		
		return message.getText();
	}

}
