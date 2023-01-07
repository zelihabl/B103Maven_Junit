package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

import javax.swing.*;
import java.nio.file.WatchEvent;
import java.sql.Driver;

public class C02_Actions2 extends TestBase {
    /*
       MANUEL
       Amazon home sayfasına git
       Account & List e uzerinde bekle
       Acılan pencerede Account linkine tıkla
       Acılan sayfanın title ının Your Account oldugunu dogrula

        */
    @Test
    public void hoverOverTest() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Account & List e uzerinde bekle
        //1.ACTIONS OBJESİ
        Actions actions=new Actions(driver);

        //2.ELEMENT LOCATE
        WebElement accountList=driver.findElement(By.id("nav-link-accountList"));
        waitFor(3);

        //2. UYGUN ACTIONS METHODUNU KULLAN. EN SONRA PERFORM KULLANAMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(3);
       // Acılan pencerede Account linkine tıkla
        driver.findElement(By.linkText("Account")).click();

        //Acılan sayfanın title ının "Your Account" oldugunu dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));







    }
}
