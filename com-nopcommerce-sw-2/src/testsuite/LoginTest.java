package testsuite;

import graphql.VisibleForTesting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import browserfactory.BaseTest;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
   public void userShouldNavigateToLoginPageSuccessfully(){
        //find loin link and click on login link
     //   WebElement loginLink = driver.findElement(By.linkText("Log in"));
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        //this is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        // find the welcome text element and get the text
        WebElement acutalMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]\n"));
        String actualMessage = acutalMessage.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to login page",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find loin link and click on login link

        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        // find email field and insert valid value in it
        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("abc@xyz.com");

        // find passworld field and insert valid value in it
        WebElement passwordField = driver.findElement(By.xpath("//input[@class='password']"));
        passwordField.sendKeys("abcxyz1");

        //find Login button and click it
     WebElement signInBtn = driver.findElement(By.xpath("//button[@class ='button-1 login-button']"));
       signInBtn.click();

       String expectedName = "Log out";

        // find the log out text is their in log out button
        WebElement actualMessageElement = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Log out is not available",expectedName,actualName);
    }
@Test
public void verifyTheErrorMessage(){
    //find loin link and click on login link

    WebElement loginLink = driver.findElement(By.className("ico-login"));
    loginLink.click();

    // find email field and insert invalid value in it
    WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
    emailField.sendKeys("abc1@xyz.com");

    // find passworld field and insert invalid value in it
    WebElement passwordField = driver.findElement(By.xpath("//input[@class='password']"));
    passwordField.sendKeys("abcxyz");

    //find Login button and click it
    WebElement signInBtn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
    signInBtn.click();

    String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";

    // to store error message in variable
    WebElement actualMessageElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
    String actualMessage = actualMessageElement.getText();

    //to check error message apper or not
    Assert.assertEquals("Error message not found",expectedMessage,actualMessage);

    }


    @After
  public void tearDown() {
        closeBrowser();
    }
}
