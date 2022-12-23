package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        //BU CLASS'I KONTROL ETTT

        //SORU:
        //C01_TekrarTesti isimli bir class olusturun
        //2 https://www.google.com/ adresine gidin
        //3 cookies uyarisini kabul ederek kapatin
        //4 Sayfa basliginin "Google" ifadesi icerdigini test edin
        //5 Arama cubuguna "Nutella" yazip aratin
        //6 Bulunan sonuc sayisini yazdirin
        //7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        //8 Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin
        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String containActualTitle = "Google";
        String expextedTitle = driver.getTitle();
        String result = expextedTitle.contains(containActualTitle) ?

                "Test Title Google PASSED" : "Test Title Google FAILED";
        // 5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys("Nutella", Keys.ENTER);

        // 6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());
        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] myList = sonucSayisi.getText().split(" ");
        result = Integer.parseInt(myList[1].replace(".","")) > Integer.parseInt("10000000") ?
                "Test PASSED" : "Test FAILED";
        System.out.println("Sonuc 10 milyon'dan fazla mi? : " + result);
        // 8- Sayfayi kapatin
        driver.close();
    }
}
