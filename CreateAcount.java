/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outboundmarketing.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Douglas
 */
public class CreateAcount {
    
    public CreateAcount() {
    }
    
   private WebDriver driver;
   private String baseUrl;
    
    @Before
    public void setUpClass() throws Exception {
       //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
       System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe");
       //driver = new ChromeDriver();
       driver = new InternetExplorerDriver();
       baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDownClass() throws Exception {
        //driver.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreateAcount() throws Exception {
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(baseUrl + "/index.php?controller=authentication&back=my-account");
    assertEquals(driver.findElement(By.linkText("Sign in")).getText(), "Sign in");
    
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).clear();
    driver.findElement(By.id("email_create")).sendKeys("douglas.dcm@gmail2.com");    
    driver.findElement(By.id("SubmitCreate")).click();
    
    int i = 0;
    boolean condition = true;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    while (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")))) {
        
        //if (driver.findElement(By.id("create_account_error")).isDisplayed()) {
            driver.findElement(By.id("email_create")).clear();
            driver.findElement(By.id("email_create")).sendKeys("douglas.dcm@gmail"+i+".com");  
            driver.findElement(By.id("SubmitCreate")).click();
            i++;
            //WebDriverWait wait = new WebDriverWait(driver, 10);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));
        //}
        
        //caso a próxima página seja carregada, sai o loop
        /*
        if (driver.findElements (By.className("page-heading")).size() > 0){
            condition = false;
            
            //espera o objeto ser carregado corretamente
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page-heading")));
        }
        */
        
    }
    
    assertEquals(driver.findElement(By.className("page-heading")).getText(), "AUTHENTICATION");
    
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).clear();
    driver.findElement(By.id("customer_firstname")).sendKeys("Douglas");
    driver.findElement(By.id("customer_lastname")).clear();
    driver.findElement(By.id("customer_lastname")).sendKeys("Cardoso");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("123456");
    new Select(driver.findElement(By.id("days"))).selectByValue("4");
    driver.findElement(By.cssSelector("option[value=\"4\"]")).click();
    new Select(driver.findElement(By.id("months"))).selectByValue("6");
    driver.findElement(By.cssSelector("#months > option[value=\"6\"]")).click();
    new Select(driver.findElement(By.id("years"))).selectByValue("1985");
    driver.findElement(By.cssSelector("option[value=\"1985\"]")).click();
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("NA");
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys("Rua K");
    driver.findElement(By.id("address2")).clear();
    driver.findElement(By.id("address2")).sendKeys("NA");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Belo Horizonte");
    new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Tennessee");
    driver.findElement(By.cssSelector("option[value=\"42\"]")).click();
    driver.findElement(By.id("postcode")).clear();
    driver.findElement(By.id("postcode")).sendKeys("00000");
    driver.findElement(By.id("other")).clear();
    driver.findElement(By.id("other")).sendKeys("NA");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("3199999999");
    driver.findElement(By.id("phone_mobile")).clear();
    driver.findElement(By.id("phone_mobile")).sendKeys("3199999999");
    driver.findElement(By.id("submitAccount")).click();
    assertEquals(driver.findElement(By.className("page-heading")).getText(), "MY ACCOUNT");
    
    }
}
