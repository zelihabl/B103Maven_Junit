package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest() {
        //1.FAKER OBJESİ OLUSTUR
        Faker faker=new Faker();
        //2.FAKER OBJESİ İLE FAKE DATA OLUSTUR
        String fName=faker.name().firstName();
        System.out.println(fName);

        String lName=faker.name().lastName();
        System.out.println(lName);

        //kullanıcı adı
        String username=faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full adres
        System.out.println(faker.address().fullAddress());

        //cep telefon numrası
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //rasgele 15 haneli numra
        System.out.println(faker.number().digits(15));

        /*
          *******TEST DATA : kullanici adi, sifre, tel no, e-mail, sehir, kredi kart no,...
          Test datalari kimden alinir?
          1- BA-Business Analyst (Acceptance Criteria'lari yazar)
          2- Test Lead
          3- Manual Tester
          4- Tech Lead & Team Lead & DEV Lead
          5- Developer
          6- Database
          7- API call'lar
          8- Documentations. Ornegin, API swagger dokumani.
          9- Java Faker da fake data almak icin kullaniyoruz.
          NERDEN GELMEZ : kullanicidan alinmaz, scrum master,..
         */




    }
}
