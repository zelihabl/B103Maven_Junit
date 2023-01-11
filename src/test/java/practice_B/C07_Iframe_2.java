package practice_B;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

public class C07_Iframe_2 extends TestBase {
    @Test
    public void test01() {
        // ...Exercise 2...
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslık=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(baslık.isEnabled());//isEnabled()erişilebilirlik kontrolü
        System.out.println("BASLIK:" +baslık.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);//locate ettiğim iframe içine yazdım
        WebElement textBox=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().parentFrame();
        WebElement elementalGorunurluk=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalGorunurluk.isDisplayed());
        System.out.println("Elemantal Selenium Yazısı:" +elementalGorunurluk.getText());




    }
}
