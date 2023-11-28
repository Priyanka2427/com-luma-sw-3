package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    // calling method from BaseTest class to open and set-up the browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        // Mouse Hover on Men Menu
        mouseHoverOnElement(By.linkText("Men"));

        // Mouse Hover on Bottoms
        mouseHoverOnElement(By.linkText("Bottoms"));

        // * Click on Pants
        mouseHoverOnElementAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        // * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverOnElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        // * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverOnElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        // * Mouse Hover on product name Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverOnElementAndClick(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));

        // * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyTheStringMessage(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");

        // * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        // * Verify the text ‘Shopping Cart.’
        verifyTheStringMessage(By.xpath("//span[@class='base']"), "Shopping Cart");

        // * Verify the product name ‘Cronus Yoga Pant’
        verifyTheStringMessage(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");

        // * Verify the product size ‘32’
        verifyTheStringMessage(By.xpath("//dd[contains(text(),'32')]"), "32");

        // * Verify the product colour ‘Black’
        verifyTheStringMessage(By.xpath("//dd[contains(text(),'Black')]"), "Black");
    }





    @After
    public void tearTown() {

        // calling method from BaseTest class to close the browser

        closeBrowser();
    }


































}
