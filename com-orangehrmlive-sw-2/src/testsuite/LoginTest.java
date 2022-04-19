package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find Username field and insert value
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //find password field and insert value
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        //find login button and click login button
        driver.findElement(By.id("btnLogin")).click();
        //this is from requirement
        String expectedMessage = "Welcome Anderson";

        // find the welcome text element and get the text
        WebElement acutalMessage = driver.findElement(By.id("welcome"));
        String actualMessage = acutalMessage.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
