package Ayushi.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Ayushi.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ayushi\\resources\\GlobalData.properties");
		
		prop.load(fis);
		String browserName=System.getProperty("browser")!= null ? System.getProperty("browser") :prop.getProperty("browser"); 
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		
		WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();    
	    
	}
		else if(browserName.equalsIgnoreCase("EdgeDriver")) {
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    return driver;
}
	
public List<HashMap<String,String>> getJsonDatatoMap(String Filepath) throws IOException {
		
		//read json to string
		String jsonContent= FileUtils.readFileToString(new File(Filepath),StandardCharsets.UTF_8);
		
		//string to map Jackson databind dependency
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}

public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
	
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File file= new File(System.getProperty("user.dir")+ "//report//" + testcaseName + ".png");
	FileUtils.copyFile(src,file);
	return System.getProperty("user.dir")+ "//report//" + testcaseName + ".png";
}

	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver= initializeDriver();
		lp= new LandingPage(driver);
	    lp.goTo();
	    return lp;		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	
	
}
