package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilitles.TestBase;

public class Excercise_6 extends TestBase {

    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Automation Exercise",actualTitle);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        assert driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed();

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@data-qa='name']")).
                sendKeys("Zeliha",Keys.TAB,"zelihabl98@gmail.com",Keys.TAB,"Java",Keys.TAB,"Java Kolaydır");
        waitFor(3);

        //7. Upload file??*?????
        //assert driver.findElement(By.name("upload_file")).isDisplayed();

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        waitFor(3);

        //9. Click OK button
        driver.switchTo().alert().accept();
        waitFor(3);

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        assert driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed();

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class=\"fa fa-angle-double-left\"]")).click();
    }
}
