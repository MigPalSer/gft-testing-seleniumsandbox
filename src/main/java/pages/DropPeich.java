package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropPeich {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropPeich(WebDriver driver){
        this.driver = driver;
    }
}
