package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

public class Excercise_8 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Automation Exercise",actualTitle);

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        assert driver.findElement(By.xpath("//*[@id='search_product']")).isDisplayed();
        //6. The products list is visible
        assert driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed();

        //7. Click on 'View Product' of first product
      driver.findElement(By.xpath("//*[@href=\"/product_details/7\"]")).click();

        //8. User is landed to product detail page
        assert driver.findElement(By.xpath("//*[@src=\"/get_product_picture/7\"]")).isDisplayed();

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        assert driver.findElement(By.xpath("(//h2)[3]")).isDisplayed(); //product name
        assert driver.findElement(By.xpath("//*[text()='Category']")).isDisplayed();//category
        assert driver.findElement(By.xpath("//*[text()='Rs. 1000']")).isDisplayed();//price
        assert driver.findElement(By.xpath("//b[text()='Availability:']")).isDisplayed();//availability
        assert driver.findElement(By.xpath("//*[text()='Condition:']")).isDisplayed();//condition
        assert driver.findElement(By.xpath("//*[text()='Brand:']")).isDisplayed();

    }
}
