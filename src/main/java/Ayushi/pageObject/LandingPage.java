package Ayushi.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ayushi.AbstractComponents.AbstractComponent;

public class LandingPage  extends AbstractComponent {
		
	WebDriver driver;

    public LandingPage(WebDriver driver){
		// TODO Auto-generated constructor stub
    	super(driver);
    	this.driver= driver;
		PageFactory.initElements(driver, this);
	}
    

	@FindBy(id="userEmail")
    WebElement usermail;
    
    @FindBy(id="userPassword")
    WebElement password;
    
    @FindBy(id="login")
    WebElement submit;
    
    @FindBy(css="[class*='flyInOut']")
    WebElement ErrorMessage;
    
    
    public void goTo() {
    	driver.get("https://rahulshettyacademy.com/client");
    }
    public ProductCatalogue loginApplication(String user,String pass) {
    	
    	usermail.sendKeys(user);
    	password.sendKeys(pass);
    	submit.click();
    	ProductCatalogue pc= new ProductCatalogue(driver);
    			return pc;
    }
    
    public String getLoginError() {
    	
    	waitForWebElementToAppear(ErrorMessage);
    	return ErrorMessage.getText();
    	
    
    }
    
}
