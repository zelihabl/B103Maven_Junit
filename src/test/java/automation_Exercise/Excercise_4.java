package automation_Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class Excercise_4 extends TestBase {
    @Test
    public void Test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String actual= driver.getCurrentUrl();
        System.out.println(actual);
        Assert.assertEquals("https://automationexercise.com/",actual);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        //if(driver.findElement(By.xpath("//*[@id='header']")).isDisplayed()){
            //System.out.println("görüldü");
       //}else System.out.println("görünmedi");
        assert driver.findElement(By.xpath("//*[@id='header']")).isDisplayed();

        //6. Enter correct email address and password
        //7. Click 'login' button
        WebElement email=driver.findElement(By.xpath("//*[@data-qa='login-email']"));
               email.sendKeys("zelihabl98@gmail.com", Keys.TAB,"1234",Keys.ENTER);

        //8. Verify that 'Logged in as username' is visible
       // if(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed()){
            //System.out.println("görüldü");
        //}else System.out.println("görülmedi");
        assert driver.findElement(By.xpath("//*[text()='Logged in as']")).isDisplayed();

        //9. Click 'Logout' button
        driver.findElement(By.partialLinkText("gout")).click();

        //10. Verify that user is navigated to login page
        assert driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();


    }
}
