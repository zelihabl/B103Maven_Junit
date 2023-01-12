package practice_B;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilitles.TestBase;

public class C08_Window_Handle extends TestBase {
    @Test
    public void Test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        String baslik= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("BASLIK:" +baslik);

        // 5- ilk sayfaya gecip url'i yazdırın

        driver.switchTo().window(sayfa1Handle);
        System.out.println(driver.getCurrentUrl());


    }
}
