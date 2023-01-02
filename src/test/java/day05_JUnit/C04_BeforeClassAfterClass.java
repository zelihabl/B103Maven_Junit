package day05_JUnit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
/*
    @BeforeClass--->Test01, Test02, Test03....-->@AfterClass
    Before--> Test01---> After
    Before--> Test02---> After

 */

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */
    @BeforeClass
    public static void setUp() {
        System.out.println("Bütün testlerden önce çalıştı");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün testlerden sonra calıştı");
    }
    @Before
    public void setUp01(){
        System.out.println("Her Testen Önce Çalışır");
    }
    @After
    public void teardown01(){
        System.out.println("Her testen Sonra Çalışır");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("İkinci Test");
    }
    @Test
    @Ignore //çalışmak istemediğiniz testi calışıtrmaz
    public void test03(){
        System.out.println("Üücncü Test");
    }

}
