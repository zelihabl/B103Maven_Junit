package practice_E;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class P09 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        WebElement alert=driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        System.out.println(driver.switchTo().alert().getText());//alert üzerindeki yazıyı yazdırdık
        driver.switchTo().alert().accept();//alertte tamama bastık

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        //    finally print on console this message "Hello TechproEducation How are you today"
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello TechproEducation How are you today");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.xpath("//*[@class=' nav nav-tabs']")).getText());
        //    aseertion these message
        Assert.assertEquals("Hello Hello TechproEducation How are you today How are you today",driver.findElement(By.xpath("//*[@class=' nav nav-tabs']")).getText());
    }
}
