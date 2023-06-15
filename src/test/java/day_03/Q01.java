package day_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {

    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2-Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        //3- Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //4-Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test : PASSED ");
        }else {
            System.out.println("Test : FAILED");
        }



        //5-Gift Cards sekmesine basin
        driver.findElement(By.xpath("(//*[@class='nav-a  '])[4]")).click();

        //6-Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday']")).click();

        //7-Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@class='a-truncate-cut']")).click();

        //8-Gift card details'den 25 $'i secin
        driver.findElement(By.xpath("//*[@class='a-button a-button-toggle']")).click();

        //9-Urun ucretinin 25$ oldugunu test edin
        String urunFiyati = driver.findElement(By.xpath("//*[@class='a-button a-button-toggle a-button-selected']")).getText();
        String beklenenUrunFiyati = "25$";

        if (urunFiyati.equals(beklenenUrunFiyati)){
            System.out.println("Test : PASSED");
        }else {
            System.out.println("Test : FAILED");
        }

        //10-Sayfayi kapatin
        driver.close();


    }








}
