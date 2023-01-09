package homework_A;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilitles.TestBase;

import java.security.Key;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class F1_Faker extends TestBase{
    @Test
    public void fakerTest() {

        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        Faker faker=new Faker();
        String fName=faker.name().firstName();
        System.out.println(fName);

        //"facebook"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();

        //“firstName” giris kutusuna bir isim yazin
        String Name=faker.name().firstName();
        System.out.println(Name);
        driver.findElement(By.xpath("//*[@name=\"firstname\"]")).sendKeys(Name);

        //“surname” giris kutusuna bir soyisim yazin
        String lastNme=faker.name().lastName();
        driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys(lastNme);

        //“email” giris kutusuna bir email yazin
        String email=faker.internet().emailAddress();
        String temail=faker.internet().emailAddress();

        driver.findElement(By.name("reg_email__")).sendKeys(email);
        //“email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);


        //Bir sifre girin
        String pwd=faker.internet().password();
        String password = faker.internet().password();
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
        //Tarih icin gun secin
        int day=faker.number().numberBetween(1,31);
        String dayy=String.valueOf(day);
        driver.findElement(By.name("birthday_day")).sendKeys(dayy);

        //Tarih icin ay secin
        int month=faker.number().numberBetween(1,12);
        String month1=String.valueOf(month);
        driver.findElement(By.name("birthday_month")).sendKeys(month1);

        //Tarih icin yil secin
        int year=faker.number().numberBetween(1990,2023);
        String yıl=String.valueOf(year);
        driver.findElement(By.id("year")).sendKeys(yıl);
        //Cinsiyeti secin
        WebElement man =driver.findElement(By.xpath("//input[@value='2']"));
        man.click();
        WebElement woman =driver.findElement(By.xpath("//input[@value='1']"));
        WebElement other =driver.findElement(By.xpath("//input[@value='-1']"));

        int randomIndex= faker.number().numberBetween(1,3);

        assertTrue(man.isSelected());
        assertFalse(woman.isSelected());
        assertFalse(other.isSelected());
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin

    }
}
