package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

public class GearTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //  Mouse Hover on Gear Menu
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//span[normalize-space()='Gear']"));

        // Click on Bags
        Thread.sleep(2000);
        mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Bags']"));

        // Click on Product Name ‘Overnight Duffle’
        mouseHoverOnElementAndClick(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        // Verify the text ‘Overnight Duffle’
        verifyTheStringMessage(By.xpath("//span[@class='base']"), "Overnight Duffle");

        // Change Qty 3
        String s = Keys.CONTROL + "a";
        sendTextToElement(By.xpath("//input[@id='qty']"), s);
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyTheStringMessage(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Overnight Duffle to your shopping cart.");

        // * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * Verify the text ‘Shopping Cart’
        verifyTheStringMessage(By.xpath("//span[@class='base']"), "Shopping Cart");

        // * Verify the product name ‘Overnight Duffle’
        verifyTheStringMessage(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");

        // * Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']"))).getAttribute("value");
        String expectedQuantity = "3";
        Assert.assertEquals(expectedQuantity, actualQuantity);

        // * Verify the product price ‘$135.00’
        verifyTheStringMessage(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"), "$135.00");

        // * Change Qty to ‘5’
        sendTextToElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']")), s);
        sendTextToElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']")), "5");

        // * Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        // * Verify the product price ‘$225.00’
        verifyTheStringMessage(By.xpath("//td[@class='col subtotal']//span[@class='price'][normalize-space()='$225.00']"), "$225.00");
    }


    @After
    public void tearTown() {

        // calling method from BaseTest class to close the browser

        closeBrowser();


    }
}

