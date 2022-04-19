package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
public void userSholdLoginSuccessfullyWithValidCredentials(){
    //find Username field and insert value
        driver.findElement(By.id("username")).sendKeys("tomsmith");
//find password field and insert value
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //find login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
                loginButton.click();

    //Verify the text “Secure Area”
    WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']//h2"));
   // System.out.println(secureArea.getText());
    String acutalMessage = secureArea.getText();
    //Verify the text “Secure Area”
    Assert.assertEquals("Incorrect Login detail", "Secure Area", acutalMessage);

}

@Test
    public void verifyTheUsernameErrorMessage(){
    //find Username field and insert value
    driver.findElement(By.id("username")).sendKeys("tomsmith1");
//find password field and insert value
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

    //find login button and click it
    WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    loginButton.click();

    //Verify the text “Error message”
    WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));

    String acutalMessage = errorMessage.getText();
    //Verify the text “Your username is invalid!” appear
    Assert.assertEquals("Error message appear...", "Your username is invalid!", acutalMessage);
}

@Test
    public void verifyThePasswordErrorMessage(){
//find Username field and insert value
    driver.findElement(By.id("username")).sendKeys("tomsmith");
//find password field and insert value
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

    //find login button and click it
    WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
    loginButton.click();

    //Verify the text “Error message”
    WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));

    String acutalMessage = errorMessage.getText();
    //Verify the text “Your Password is invalid!” appear
    Assert.assertEquals("Error message appear...", "Your Password is invalid!", acutalMessage);
}

    @After
    public void tearDown(){
        closeBrowser();
    }

}
