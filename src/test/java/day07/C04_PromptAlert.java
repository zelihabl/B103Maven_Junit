package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

public class C04_PromptAlert extends TestBase {
    //    3. butona tıklayın,
//    uyarıdaki metin kutusuna isminizi yazin,
//    OK butonuna tıklayın
//    ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void sendKeysMethod() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");
        //    3. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Zeliha");
        Thread.sleep(5000);
        //    OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.id("result")).getText();
        String expectedResult="Zeliha";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
