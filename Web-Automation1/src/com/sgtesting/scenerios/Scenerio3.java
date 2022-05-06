package com.sgtesting.scenerios;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenerio3 {
	
	public static WebDriver wb=null;

	@Test(priority=1)
	public static void LaunchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Javaautomation\\Web-Automation1\\library\\Driver\\chromedriver.exe");
			wb=new ChromeDriver();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public static void navigate()
	{
		try
		{
			wb.get("http://localhost:81/login.do");

		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=3,dataProvider="credentails")
	public static void Login(String user,String pwd)
	{
		try 
		{
			wb.findElement(By.id("username")).sendKeys(user);
			wb.findElement(By.name("pwd")).sendKeys(pwd);
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(1000);
			wb.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="credentails")
	public Object[][] getLoginDetails()
	{
		return new Object[][] {{"admin","manager"}};
	}

	@Test(priority=4,dataProvider="createcustomer")
	public static void CreateCustomer(String cn)
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[3]/a/div[2]")).click();
			wb.findElement(By.xpath("//div[text()='Add New']")).click();
			Thread.sleep(2000);
			wb.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			Thread.sleep(2000);
			wb.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
			Thread.sleep(2000);
			wb.findElement(By.xpath("//*[@id=\'customerLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createcustomer")
	public Object[][] getCreateCustomerDetails()
	{
		return new Object[][] {{"Infinite"}};
	}

	@Test(priority=5)
	public static void DeleteCustomer()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div/div[2]")).click();
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]/div")).click();
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'customerPanel_deleteConfirm_submitBtn\']/div")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=6)
	public static void Logout()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'logoutLink\']")).click();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test(priority=7)
	public static void CloseApplication()
	{
		try
		{
			wb.quit();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
