package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilitles.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void newWindowHandleTest() {

        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://www.techproeducation.com");
        String techProHandle=driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1.yeni pencere olusturur 2.Oraya geçiş yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1.yeni pencere olusturur 2.Oraya geçiş yapar
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //Driver Nerde?
        //LINKEDIN DE
        //TECHPRO SAYFASINA GİTMEK İCİN TEKRAR driver.switch.to().window(techproHandle)
        driver.switchTo().window(techProHandle);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);


    }
}
