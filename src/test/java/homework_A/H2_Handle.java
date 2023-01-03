package homework_A;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilitles.TestBase;

import java.util.Set;

public class H2_Handle extends TestBase {
    @Test
    public void test01(){


        //+https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

       // +Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows",driver.getTitle());

        //Click here a tiklayin
        String window1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@href='index.php?page=new-windows']")).click();


        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        //Bu soruda 3 farklı yöntem yaptık; ilk yöntem for each

        //Set<String> a =driver.getWindowHandles();
        // for (String w : a){
        //     if (!w.equals(window1)){
        //         driver.switchTo().window(w);
        //     }
        // }
        //Assert.assertEquals("New Window",driver.getTitle());

        //2.yontem testbase de olusturduğumuz list method
        //List<String> list = new ArrayList<>(a);
        //driver.switchTo().window(list.get(1));
        switchToWindow2(1);

        //3.yöntem testbase de olusturduğumuz method
        // switchToWindow("New Window");

    }
}
