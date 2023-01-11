package practice_E;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilitles.TestBase;

import java.util.Set;

public class P16_Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() {

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        waitFor(3);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println("Cookilerin Sayısı:" +cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie c:cookies) {
            System.out.println(c.getName()+":"+c.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie =new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);
        waitFor(3);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2=driver.manage().getCookies();
        System.out.println("Cookilerin Sayısı:" +cookies2.size());
        for (Cookie w:cookies2) {
            System.out.println(w.getName() + " " + w.getValue());

        }


        //Oluşturduğumuz cookie'i sileli
        driver.manage().deleteCookie(myCookie);
        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3=driver.manage().getCookies();
        System.out.println(cookies2.size());
    }
}