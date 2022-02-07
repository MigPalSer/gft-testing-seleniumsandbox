package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	private WebDriver driver;
	
	public void setUp(){
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");
	    System.out.println(driver.getTitle());
	    //c3
	    WebElement inputsLink = driver.findElement(By.linkText("Inputs"));	
	    inputsLink.click();
	    
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    System.out.println("elementos con a: "+links.size());
	    
	    driver.quit();
	}

	public void shiftOptional(){
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");
	   
	    WebElement nextLink = driver.findElement(By.linkText("Shifting Content"));	
	    nextLink.click();
	    
	    nextLink = driver.findElement(By.linkText("Example 1: Menu Element"));	
	    nextLink.click();
	    
	    List<WebElement> links = driver.findElements(By.tagName("li"));
	    		//tagName("<li>"));
	    System.out.println("elementos del menu: "+links.size());
	    
	    
	}
	
	public static void main(String[] args) {
		BaseTest b= new BaseTest();
		//b.setUp();
		b.shiftOptional();
	}
	
}
