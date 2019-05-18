package com.cucumber;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class Stepdefinition15 {
	
	static WebDriver driver;
	
	//Invalid data functionality
	
	@Given("The user should be at the Add Tariff Plan page")
	public void the_user_should_be_at_the_Add_Tariff_Plan_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\cucumber\\browserDriver\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.get("http://demo.guru99.com/telecom/addtariffplans.php");
        System.out.println("given");
	}

	@When("User should fill the Invalid data detail and click on the submit buttons")
	public void user_should_fill_the_Invalid_data_detail_and_click_on_the_submit_buttons(DataTable dataTable) {
		Map<String,String> addtariff = dataTable.asMap(String.class,String.class);
		 
		driver.findElement(By.id("rental1")).sendKeys(addtariff.get("Monthly Rental"));
		driver.findElement(By.id("local_minutes")).sendKeys(addtariff.get("Free Local Minutes"));
		driver.findElement(By.id("inter_minutes")).sendKeys(addtariff.get("Free International Minutes"));
		driver.findElement(By.id("sms_pack")).sendKeys(addtariff.get("Free SMS Pack"));
		driver.findElement(By.id("minutes_charges")).sendKeys(addtariff.get("Local Per Minutes Charges"));
		driver.findElement(By.id("inter_charges")).sendKeys(addtariff.get("International Per Minutes Charges"));
		driver.findElement(By.id("sms_charges")).sendKeys(addtariff.get("SMS Per Charges"));
		driver.findElement(By.name("submit")).click();
		System.out.println("when");

	}

	@Then("Error message box should display")
	public void error_message_box_should_display() {
		String actual_error =driver.findElement(By.xpath("//label[@id='message3']")).getText();
		String expected_error="Characters are not allowed";
		Assert.assertEquals(expected_error, actual_error);
		System.out.println("test completed");
		System.out.println("then");
		
	}
	
	
	
	//madatory functionality
	
    @Given("The user should be at the add customer page")
	public void the_user_should_be_at_the_add_customer_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\cucumber\\browserDriver\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.get("http://demo.guru99.com/telecom/addtariffplans.php");
	}

	@When("User should not fill madantory detail and click on the submit button")
	public void user_should_not_fill_madantory_detail_and_click_on_the_submit_button() {
		WebElement submit = driver.findElement(By.name("submit"));
		submit.click();
	}

	@Then("valid error message should display")
	public void valid_error_message_should_display() {
		Alert alert = driver.switchTo().alert();
		   System.out.println(alert.getText()); 
		    if(alert.getText().equalsIgnoreCase("please fill all fields Correct Value")){
		    	System.out.println("error message is verified and both alert message in expected and actual are same");
		    	}
		    alert.accept();
	}

	
	
	
	//scenario outline //add customer functionality
	@Given("The user should be at the add customer pagess")
	public void the_user_should_be_at_the_add_customer_pagess() {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\cucumber\\browserDriver\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.get("http://demo.guru99.com/telecom/addcustomer.php");
	}

	@When("Users should fill the all detail{string},{string},{string},{string},{string}")
	public void users_should_fill_the_all_detail(String Firstname, String Lastname, String Email, String address, String mobileno) {
		driver.findElement(By.id("fname")).sendKeys(Firstname);		
		driver.findElement(By.id("lname")).sendKeys(Lastname);		
		driver.findElement(By.id("email")).sendKeys(Email);		
		driver.findElement(By.name("addr")).sendKeys(address);		
		driver.findElement(By.id("telephoneno")).sendKeys(mobileno);
	}

	
	@When("users click on submit buttons")
	public void users_click_on_submit_buttons() {
		driver.findElement(By.name("submit")).click();
		}

	@Then("customer id is generated")
	public void customer_id_is_generated() {
		driver.findElement(By.tagName("h3")).isDisplayed();
	}


	
	//Reset functionality
	@Given("The user should be at the add tariff plan page")
	public void the_user_should_be_at_the_add_tariff_plan_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\cucumber\\browserDriver\\chromedriver.exe");
		driver =new ChromeDriver();
        driver.get("http://demo.guru99.com/telecom/addtariffplans.php");

	}

	@When("User should fill the all details")
	public void user_should_fill_the_all_details(DataTable dataTable) {
		Map<String, String> addtariffMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("rental1")).sendKeys(addtariffMap.get("Monthly Rental"));
	    driver.findElement(By.id("local_minutes")).sendKeys(addtariffMap.get("Free Local Minutes"));
	    driver.findElement(By.id("inter_minutes")).sendKeys(addtariffMap.get("Free International Minutes"));
	    driver.findElement(By.id("sms_pack")).sendKeys(addtariffMap.get("Free SMS Pack"));
	    driver.findElement(By.id("minutes_charges")).sendKeys(addtariffMap.get("Local Per Minutes Charges"));
	    driver.findElement(By.id("inter_charges")).sendKeys(addtariffMap.get("International Per Minutes Charges"));
	    driver.findElement(By.id("sms_charges")).sendKeys(addtariffMap.get("SMS Per Charges"));
		
	}

	@When("click on the reset button")
	public void click_on_the_reset_button() {
		driver.findElement(By.className("alt")).click();
	}

	@Then("values should get cleared")
	public void values_should_get_cleared() {
		driver.get("http://demo.guru99.com/telecom/addtariffplans.php");
	}



}
