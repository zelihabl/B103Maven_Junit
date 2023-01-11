package practice_B;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

import javax.swing.*;

public class C06_Iframe extends TestBase {
    @Test
    public void test01() {

        // ...Exercise 1...
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe =driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        WebElement play= driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
            play.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazısı=driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazısı.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement gorunurluk =driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(gorunurluk.isDisplayed());


    }
}
