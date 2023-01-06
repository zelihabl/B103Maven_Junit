package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class Excercise_07 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/",actualUrl);

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//*[@class=\"fa fa-list\"])[1]")).click();
        waitFor(3);

        //5. Verify user is navigated to test cases page successfully
        WebElement testCasePage = driver.findElement(By.xpath("/html/body"));//???BU KISMI ALAMADIM
        Assert.assertTrue(testCasePage.isDisplayed());
    }
}
