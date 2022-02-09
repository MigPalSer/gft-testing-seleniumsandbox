package robobar_selenide;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LandinPeichSelenide {

	private SelenideElement btnAddCola = $(
			"html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

	private SelenideElement btnAddBeer = $(
			"html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

	private SelenideElement btnAddWine = $(
			"html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button");

	private SelenideElement txtTotal = $("th[class='ng-binding']");

	private SelenideElement btnCheckout = $(".btn-success");
	
	private SelenideElement ageInput = $(By.id("ageInput"));

	public void clickCola() {
		btnAddCola.click();
	}

	public void clickWine() {
		btnAddWine.click();
	}

	public void clickBeer() {
		btnAddBeer.click();
	}
	public void clickOrder() {
		 btnCheckout.click(); }
	
	public boolean orderIsDisabled() { 
		Optional<String> result=Optional.ofNullable(btnCheckout.getAttribute("disabled"));
		 return result.orElse("false").equals("true");}
	
	public void introducirEdad(int edad) {
		 ageInput.click(); //TODO probar si funciona sin ello
		 ageInput.sendKeys(Integer.toString(edad));}
	
	public String valorActual() { return
			 txtTotal.getText(); }
	
	public boolean orderSuccess() { 
		String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
		return currentUrl.equals("https://migpalser.github.io/robobar-example/#!/success");
	}
	

}
