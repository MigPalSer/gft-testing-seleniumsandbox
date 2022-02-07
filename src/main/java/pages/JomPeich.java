package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JomPeich {
	private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    public JomPeich(WebDriver driver){
        this.driver = driver;
    }
    

    public LoguinPeich clickFormAuthentication(){
        driver.findElement(formAuthenticationLink).click();
        return new LoguinPeich(driver);
   }

    
}
