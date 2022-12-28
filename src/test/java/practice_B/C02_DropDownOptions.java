package practice_B;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

        // ...Exercise 2...
       // https://www.amazon.com/ sayfasina gidin
       // dropdown'dan "Baby" secenegini secin
       // sectiginiz option'i yazdirin
       // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test02() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin

        //1.adım:locate edilmeli
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2.adım:select objesi olusturulmalı
        Select select=new Select(ddm);
        //3.adım:opsiyon secilir
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String sectigimOption= select.getFirstSelectedOption().getText();
        System.out.println("SECTİĞİM OPTİON:" +sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tümOptionlar= select.getOptions();
        int actualOptionSayısı=tümOptionlar.size();
        int expectedOpionSayısı=24;

    }
}

