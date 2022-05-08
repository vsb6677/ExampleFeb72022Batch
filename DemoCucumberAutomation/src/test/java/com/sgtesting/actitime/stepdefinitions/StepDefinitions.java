package com.sgtesting.actitime.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class StepDefinitions {
	public static WebDriver oBrowser=null;
	/*
	 * Created By:
	 * Created Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 */
	@Given("^I launch a Chrome browser$")
	public void I_launch_a_Chrome_browser()
	{
		try
		{
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Created By:
	 * Created Date:
	 * Parameters:
	 * Return Type:
	 * Description:
	 */
	@And("^I navigate the URL of the application$")
	public void I_navigate_the_URL_of_the_application()
	{
		try
		{
			oBrowser.get("http://localhost:81/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
