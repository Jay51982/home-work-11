package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class testsuite extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Click on Login link
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginButton.click();

        //Verify the text ‘Welcome Back!
        WebElement secureArea = driver.findElement(By.className("page__heading"));

        Assert.assertEquals("Incorrect Login detail", "Welcome Back!", secureArea.getText());
    }
    @Test
    // verifyTheErrorMessage
    public void  verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginButton.click();

        // Enter invalid username
        //to find email field and insert invalid email id
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("abc@xyz.com");

        //find the password field element and insert invalid password
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("abcxyz123");

        // Click on submit button
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Sign in']"));
        submitButton.click();

        //Verify the error message ‘Invalid email or password.'
        WebElement secureArea = driver.findElement(By.className("form-error__list-item"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "Invalid email or password.", secureArea.getText());
    }
}

