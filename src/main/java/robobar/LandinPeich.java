package robobar;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandinPeich {

	private WebDriver driver;

	public LandinPeich(WebDriver driver) {
		this.driver = driver;
	}
	public void clickCola() {
		 driver.findElement(By.cssSelector(".ng-scope:nth-child(1) > td .input-group-append > .btn")).click();
	}
	public void clickWine() {
		driver.findElement(By.cssSelector(".ng-scope:nth-child(3) .input-group-append > .btn")).click();
	}
	public void clickBeer() {
		driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td .input-group-append > .btn")).click();
	}
   
	public void clickOrder() {
	    driver.findElement(By.cssSelector(".btn-success")).click();
	}
	
	public boolean orderIsDisabled() {
		WebElement boton=driver.findElement(By.cssSelector(".btn-success"));
		Optional<String> result=Optional.ofNullable(boton.getAttribute("disabled"));
		return result.orElse("false").equals("true");
	}
   
	public void introducirEdad(int edad) {
	    driver.findElement(By.id("ageInput")).click();
	    driver.findElement(By.id("ageInput")).sendKeys(Integer.toString(edad));
	    }
	
	public String valorActual() {
		return driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getText();
	}	
	
	public boolean orderSuccess() {
		return driver.getCurrentUrl().equals("https://migpalser.github.io/robobar-example/#!/success");
	}
	
}
