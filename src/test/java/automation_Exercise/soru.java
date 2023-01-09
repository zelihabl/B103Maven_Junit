package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

import java.util.List;

public class soru extends TestBase {


    @Test
    public void test1() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Automation Exercise",actualTitle);

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPage.isDisplayed());
        //6. The products list is visible
        WebElement productList = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(productList.isDisplayed());
        //7. Click on 'View Product' of first product
        driver.switchTo().frame(0).findElement(By.id("google_esf")).click();
        List<WebElement>ürün = driver.findElements(By.xpath("//*[@href='/product_details/1']"));
        ürün.get(1).click();


        //driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
        //8. User is landed to product detail page
        WebElement proDetail = driver.findElement(By.xpath("//*[@class='product-information']"));
        Assert.assertTrue(proDetail.isDisplayed());
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));


    }
}
