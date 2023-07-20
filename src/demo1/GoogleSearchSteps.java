package stepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.cucumber.core.cli.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleSearchSteps {

	WebDriver driver = null;
	
//	@FindBy(xpath = "//h6[contains(text(),'the business growth')]")
//	WebElement vision;
	
	
	@Given("^browser is open$")
	public void browser_is_open() {
		System.out.println("Browser is opening");
		
	//	System.setProperty("webdriver.chrome.driver", "");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
	}
	
	@And("^user is on the google search page$")
	public void user_is_on_the_google_search_page() {
		
		System.out.println("user is on google search page");
		driver.navigate().to("https://www.google.com");
		
	}
	
	@When("^user enters a text in search box$")
	public void user_enters_a_text_in_search_box() throws InterruptedException {
		
		System.out.println("user enters a text in search box");
		
		driver.findElement(By.id("APjFqb")).sendKeys("client server tech");
		
		Thread.sleep(2000);
	}
	 
	@And("^hits enter$")
	public void hits_enter() throws InterruptedException {
		
		System.out.println("hits enter");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
	
	@Then("^user is navigated to search results$")
	public void user_is_navigated_to_search_results() throws InterruptedException {
		
		System.out.println("user is navigated to search results");
		
		
		//driver.getPageSource().contains("provide complete software");
		
		// driver.findElement(By.xpath("//div[contains(text(),'provide complete software')]//parent::div//parent::div//child::div")).click();
		
		
		driver.findElement(By.xpath("//div[contains(text(),'complete Software Testing solutions')]//parent::div//parent::div//child::div//child::div//a")).click();
		
	//	driver.navigate().to("https://clientservertech.com");
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		//driver.findElement(By.name("About")).click();
		
		//span[normalize-space()='About']
		
		//div[contains(text(),'Specialized Testing')]//parent::div//child::div
		
		driver.findElement(By.xpath("//div[contains(text(),'Specialized Testing')]//parent::div//child::div")).click();
		
		driver.findElement(By.xpath("//span[text()='About']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
//		String abc= "Our vision is to enhance the business growth of our customers and transform their digital experiences. With our creative designs, development, and high-quality solutions – we aim to offer efficient, seamless, and worry-free IT.";
//		
//		String vision = driver.findElement(By.xpath("//h6[contains(text(),'the business growth')]")).getText();	
//	
//		
//		assertEquals(abc,vision);
		
					
}

	@Then("^Validate$")
	public void Validate() throws InterruptedException {
		
		String actual= driver.findElement(By.xpath("//h6[contains(text(),'the business growth')]")).getText();
		
		String expected = "Our vision is to enhance the business growth of our customers and transform their digital experiences. With our creative designs, development, and high-quality solutions – we aim to offer efficient, seamless, and worry-free IT.";

		
		// assertEquals(actual,expected);
		
		if (expected.equals(actual)) {
			System.out.println("Data matches");
		}else{
			System.out.println("Please check the data ");
		} 
		
		
		Thread.sleep(2000);
	
	}

	
	
}


