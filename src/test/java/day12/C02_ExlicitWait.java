package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class C02_ExlicitWait extends TestBase {
    @Test
    public void explicitWaitTest(){
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assert.assertEquals("Hello World!",helloWorldElement.getText());
        //IMPLICIT WAIT ILE TEST CASE CALISMADI
        //COZUM EXPLICIT WAITDE

    }
}
