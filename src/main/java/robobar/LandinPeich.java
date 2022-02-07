package robobar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
   
	public void introducirEdad(int edad) {
	    driver.findElement(By.id("ageInput")).click();
	    driver.findElement(By.id("ageInput")).sendKeys(Integer.toString(edad));
	    }
	
	public String valorActual() {
		return driver.findElement(By.cssSelector("tr:nth-child(4) > .ng-binding")).getAttribute("value");
	}	
	
}
