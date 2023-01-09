package homework_A;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitles.TestBase;

public class A3_Actions extends TestBase {
    @Test
    public void test01() {

        //Keyboard Base Actions
        //Homework
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");
        //Link 1" e tiklayin
        WebElement firstBox=findXPath("//button[text()='Hover Over Me First!']");
        hoverOverOnElementActions(firstBox);
        driver.findElement(By.partialLinkText("Link 1")).click();
        System.out.println(driver.switchTo().alert().getText());

        //Popup mesajini yazdirin
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        Actions actioans=new Actions(driver);
        WebElement clickBox=findId("click-box");
        actioans.clickAndHold(clickBox).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBox.getText());

        //8- “Double click me" butonunu cift tiklayin
        doubleClick(findId("double-click"));
    }

}
