package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilitles.TestBase;

public class Excercise_5 extends TestBase {

    @Test
    public void Test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String actual=driver.getCurrentUrl();
        System.out.println(actual);
        Assert.assertEquals("https://automationexercise.com/",actual);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        assert driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed();

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Zeliha", Keys.TAB,"zelihabl98@gmail.com",Keys.ENTER);

        //8. Verify error 'Email Address already exist!' is visible
        assert driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed();


    }
}
