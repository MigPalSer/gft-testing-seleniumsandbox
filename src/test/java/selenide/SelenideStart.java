package selenide;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SelenideStart {

	@Test
	public void test() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		open("https://the-internet.herokuapp.com/");
		$("BasicAuth").click();
		$(By.name("name")).shouldHave(text("Name"));
	}

}
