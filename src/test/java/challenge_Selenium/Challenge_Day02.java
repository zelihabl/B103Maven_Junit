package challenge_Selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class Challenge_Day02 extends TestBase {
    @Test
    public void test01() {
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        //3- Browseri tam sayfa yapin

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
                aramaKutusu.sendKeys("Salesforce Apex Questions Bank");
                aramaKutusu.submit();

        //6- Kac sonuc bulundugunu yaziniz
        WebElement sonuc=driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        System.out.println("sonuc = " + sonuc.getText());

        //7-Sayfayi kapatin
       // driver.close();

    }
}
