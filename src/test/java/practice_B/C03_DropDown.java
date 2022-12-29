package practice_B;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin

    WebDriver driver;

    //** INTERVIEW QUESTION ** implicitlyWait() nereden gelir? -> Selenium
   //                         Thread.sleep() nereden gelir -> Java

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın

        //dropdown 3 adımda handle edilir
        //1-dropdown locate alınır
        WebElement ddm=driver.findElement(By.xpath(" //select[@id='dropdown']"));
        //2.select objesi olustur
        Select select=new Select(ddm);
        //3.option seçer
        select.selectByIndex(1);
        String sectigimOptionindex=select.getFirstSelectedOption().getText();
        System.out.println("SECTİĞİM OPTİON INDEX: " +sectigimOptionindex);
        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigımOptionValue= select.getFirstSelectedOption().getText();
        System.out.println("SECTİĞİM OPTION VALUE: "+sectigımOptionValue);
        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
       String sectigımOptionVisible= select.getFirstSelectedOption().getText();
        System.out.println("SECTİĞİM OPTION VISIBLE: "+sectigımOptionVisible);

        // Tüm option'ları yazdırın
        List<WebElement> tumOptionlar=select.getOptions(); //list içindeki tüm elemanları yazdırmak için for-each yaptık

        int sayac=1;
        for(WebElement each:tumOptionlar){
            System.out.println(sayac+".OPTION " +each.getText());
            sayac++;
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin

        int expected=3;//beklenen
        int actual=tumOptionlar.size();//gerçek olan
        Assert.assertEquals(expected,actual);//beklenen=gerçek eşit miii??







    }
}
