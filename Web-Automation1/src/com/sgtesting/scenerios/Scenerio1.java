package com.sgtesting.scenerios;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenerio1 {

	public static WebDriver wb=null;

	@Test(priority=1)
	public static void LaunchBrowser()
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Javaautomation\\Web-Automation1\\library\\Driver\\chromedriver.exe");
			wb=new ChromeDriver();
		} catch (Exception e) 
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
			Thread.sleep(2000);
		} catch (Exception e) 
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

	@Test(priority=4,dataProvider="createuser")
	public static void CreateUser(String fn,String ln,String em,String un,String pw,String pwc)
	{
		try 
		{
			wb.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();
			Thread.sleep(1000);
			wb.findElement(By.id("userDataLightBox_firstNameField")).sendKeys(fn);
			Thread.sleep(1000);
			wb.findElement(By.id("userDataLightBox_lastNameField")).sendKeys(ln);
			Thread.sleep(1000);
			wb.findElement(By.name("email")).sendKeys(em);
			Thread.sleep(1000);
			wb.findElement(By.name("username")).sendKeys(un);
			Thread.sleep(1000);
			wb.findElement(By.id("userDataLightBox_passwordField")).sendKeys(pw);
			Thread.sleep(1000);
			wb.findElement(By.name("passwordCopy")).sendKeys(pwc);
			Thread.sleep(1000);
			wb.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div")).click();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createuser")
	public Object[][] getCreateUserDetails()
	{
		return new Object[][] {{"Sujeeth","Kumar","sujeeth@gmail.com","Sujeethkumar","Welcome123","Welcome123"}};
	}

	@Test(priority=5)
	public static void DeleteUser()
	{
		try
		{
			wb.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			Thread.sleep(1000);
			wb.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(1000);
			Alert oAlert=wb.switchTo().alert();
			oAlert.accept();
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
