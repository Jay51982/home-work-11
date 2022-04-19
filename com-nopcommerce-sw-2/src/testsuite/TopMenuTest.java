package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //4.1
    public void userShouldNavigateToComputerPageSuccessfully() {

               WebElement computersTabLink = driver.findElement(By.linkText("Computers"));
        computersTabLink.click();

        String expectedName = "Computers";

        // find the log out text is their in log out button
        WebElement actualMessageElement = driver.findElement(By.linkText("Computers"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Computers Tab is not available", expectedName, actualName);
    }

    @Test
    //4.2
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        WebElement electronicsTabLink = driver.findElement(By.linkText("Electoronics"));
        electronicsTabLink.click();

        String expectedName = "Electoronics";

        // verify the Electoronics text is on the page
        WebElement actualMessageElement = driver.findElement(By.linkText("Electoronics"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Electronics Tab is not available", expectedName, actualName);
    }

    //4.3
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        WebElement apparelTabLink = driver.findElement(By.xpath("Apparel"));
        apparelTabLink.click();

        String expectedName = "Apparel";

        // verify the Apparel text is on the page
        WebElement actualMessageElement = driver.findElement(By.xpath("Apparel"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Apparel Tab is not available", expectedName, actualName);
    }

    //4.4
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        WebElement digitaldownloadsTabLink = driver.findElement(By.linkText("Digital downloads"));
        digitaldownloadsTabLink.click();

        String expectedName = "Digital downloads";

        //verify the Digital downloads is visbile on web page
        WebElement actualMessageElement = driver.findElement(By.linkText("Digital downloads"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Digital Downloads Tab is not available", expectedName, actualName);
    }

    //4.5
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        WebElement booksTabLink = driver.findElement(By.linkText("Books"));
        booksTabLink.click();

        String expectedName = "Books";

        // verify Books visible on web page

        WebElement actualMessageElement = driver.findElement(By.linkText("Books"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Books Tab is not available", expectedName, actualName);
    }

    //4.6
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        WebElement jewelryTabLink = driver.findElement(By.linkText("Jewelary"));
        jewelryTabLink.click();

        String expectedName = "Jewelary";

        // find the log out text is their in log out button
        WebElement actualMessageElement = driver.findElement(By.linkText("Jewelary"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Jewelry Tab is not available", expectedName, actualName);
    }

    //4.7
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        WebElement giftCardsTabLink = driver.findElement(By.linkText("Gift Cards"));
        giftCardsTabLink.click();

        String expectedName = "Gift Cards";

        // verify Gift Cards on visible on web page
        WebElement actualMessageElement = driver.findElement(By.linkText("Gift Cards"));
        String actualName = actualMessageElement.getAccessibleName();

        //compare both expeceted text and actual text
        Assert.assertEquals("Gift Cards Tab is not available", expectedName, actualName);
    }

//    @After
//        public void tearDown() {
//        closeBrowser();
//    }

}