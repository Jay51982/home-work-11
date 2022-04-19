package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
    public void userSholdLoginSuccessfullyWithValid(){
        //find Username field and insert value
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //find password field and insert value
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //find login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();

        //Verify the text “PRODUCTS”
        WebElement secureArea = driver.findElement(By.className("title"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea.getText());
    }

    @Test
public void verifyThatSixProductsAreDisplayedOnPage() {
        //find Username field and insert value
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //find password field and insert value
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //find login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        loginButton.click();

        //* Verify that six products are displayed on page
        List<WebElement> verifydisplaylist = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
        System.out.println("Item display  : "  +  verifydisplaylist.size());

        int expectedImages = 6;

        Assert.assertEquals("All Six products displayed on screen.",expectedImages,verifydisplaylist.size());
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
