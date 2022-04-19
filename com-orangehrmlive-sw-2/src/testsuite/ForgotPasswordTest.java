package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void  userShouldNavigateToForgotPasswordPageSuccessfully(){

        // Verify the text ‘Forgot Your Password?’
        String expectedMessage = "Forgot your password?";

        String actualMessage = driver.findElement(By.xpath("//a[@href = '/index.php/auth/requestPasswordResetCode']")).getText();

        System.out.println("actual msg = "+ actualMessage );
        //compare message
        Assert.assertEquals("Can not verify Forgot Your Pasword Message : ", expectedMessage, actualMessage);

        //varify navigate to forgot password reset page
        WebElement forgotPassLink = driver.findElement(By.xpath("//a[text() = 'Forgot your password?']"));
        forgotPassLink .click();

    }

    /*
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        driver.findElement(By.id("forgotPasswordLink")).click();

//this is from requirement
        String expectedMessage = "Forgot Your Password?";

        // find the welcome text element and get the text
        WebElement acutalMessage = driver.findElement(By.className("head"));
        String actualMessage = acutalMessage.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to forgot password page.",expectedMessage,actualMessage);
    */





//    @After
//    public void tearDown(){
//        closeBrowser();
//    }
//
}
