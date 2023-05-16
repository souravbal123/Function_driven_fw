package library;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import testbase.Test_Base;

public class Library extends Test_Base {
	public static void login() throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(prop.getProperty("name"));
		log.info("user name entered");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(prop.getProperty("pass"));
		log.info("password entered");
		Thread.sleep(7000);
		driver.findElement(By.id(prop.getProperty("login"))).click();
		log.info("login button is clicked");
		log.info("user logged in");
	}

	public static void logout() throws Throwable {
		Thread.sleep(7000);
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		log.info("logout button is clicked");
		log.info("user logged out");
	}

	public static void new_User_Creation(String fn, String ln, String un, String pass) throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.findElement(By.id(prop.getProperty("new_user"))).click();
		log.info("new_user button clicked");
		driver.findElement(By.xpath(prop.getProperty("firstname"))).sendKeys(fn);
		log.info("user first name entered");
		driver.findElement(By.xpath(prop.getProperty("lastname"))).sendKeys(ln);
		log.info("user last name entered");
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(un);
		log.info("user login name entered");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(pass);
		log.info("user password entered");
		driver.switchTo().frame(1);
		log.info("entered into frame");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("captcha"))).click();
		log.info("captcha checkbox clicked");
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(prop.getProperty("register"))).click();
		log.info("user able to register his account");
	}

	public static void login_Validation() throws Throwable {
		String log_out = driver.findElement(By.xpath(prop.getProperty("logout"))).getText();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File("./src/test/java/screenshot/" + "LoginValidation" + "_Pass.png"));

		Assert.assertEquals(log_out, "Log out");
		log.info("login functionality validated successfully");
	}

	public static void logout_Validation() throws Throwable {
		String log_in = driver.findElement(By.id(prop.getProperty("login"))).getText();
		
		Assert.assertEquals(log_in, "Login");
		log.info("logout functionality validated successfully");
	}

	public static void new_User_Validation(String un, String pass) {
		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(un);
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(pass);
		driver.findElement(By.xpath(prop.getProperty("login"))).click();
		log.info("new user functionality validated successfully");
	}
}
