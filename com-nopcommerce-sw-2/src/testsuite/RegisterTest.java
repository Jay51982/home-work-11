package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
   // public static WebDriver driver;
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
    //     WebElement registerLink =
        driver.findElement(By.linkText("Register")).click();
  //        registerLink.click();

        //this is from requirement
        String expectedMessage = "Register";

        // find the welcome text element and get the text
        WebElement acutalMessage = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actualMessage = acutalMessage.getText();

        //validate actual and expected message
        Assert.assertEquals("Not navigate to Register page", expectedMessage, actualMessage);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
// go to register
        driver.findElement(By.linkText("Register")).click();

        //select radio button
        driver.findElement(By.id("gender-male")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Abc");

        driver.findElement(By.id("LastName")).sendKeys("Xyz");

        driver.findElement(By.name("DateOfBirthDay")).sendKeys("11");

        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("11");

        driver.findElement(By.name("DateOfBirthYear")).sendKeys("2000");

        driver.findElement(By.id("Email")).sendKeys("abc1@xyz.com");

        driver.findElement(By.id("Password")).sendKeys("abcxyz123");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("abcxyz123");

        driver.findElement(By.id("register-button")).click();

        //this is from requirement
        String expectedMessage = "Your registration completed";

        // find the welcome text element and get the text
        WebElement acutalMessage = driver.findElement(By.linkText("Your registration completed"));
        String actualMessage = acutalMessage.getText();

        //validate actual and expected message
        Assert.assertEquals("Your registration completed", expectedMessage, actualMessage);

        driver.findElement(By.linkText("Continue")).click();
    }


   // @After
//    public void tearDown() {
//        closeBrowser();
//    }


}