package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    
    //Method : isExist
    //Masa ustunden bir dosyanın varligini test et

    @Test
    public void isExistTest() {
        String userDIR= System.getProperty("user.dir");
        System.out.println(userDIR);//C:\Users\zelih\IdeaProjects\B103Maven_Junit ==>dosya yolu, kullanma amacımız dinamik path alma

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\zelih  ==>bilgisayarın ismine kadar olan kısmı veirir

        //String dosyaYolu=userHome + "/Desktop/logo.jpeg";
       // String dosyaYolu = userHome + "\\Desktop\\logo.jpeg";==>onedrive olduğu için bu kodlar bende çalışmadı

        String dosyaYolu = userHome+"\\OneDrive\\Masaüstü\\logo.jpeg"; //==>onedrive olduğu için koduma eklemek zorunda kaldım
        System.out.println(dosyaYolu);
        boolean isExist=Files.exists(Paths.get(dosyaYolu));//dosya var ise true,yok ise false;

        // exists(): Bu metot yapımızda “File” yapısının içerisinde belirtilen dizin adresinde
        // dosyanın var olup olmadığının karşılığını boolean veri tipinde bizlere verir.
        Assert.assertTrue(isExist);
        System.out.println(isExist);
       // 1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak






    }

    }


