package day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {

    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



              // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

              // Sayfa basligini(title) yazdirin
        String actualAmazonTitle = driver.getTitle();
        System.out.println("Amazon Sayfa Basligi : "+actualAmazonTitle);

              // Sayfa basliginin "Amazon" icerdigini test edin
        String exceptedTitle = "Amazon";
        if (actualAmazonTitle.contains(exceptedTitle)){
            System.out.println("Test : PASSED");
        }else System.out.println("Test : FAILED");


              // Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Amazon Url :"+actualUrl);

              // Sayfa url'inin "amazon" icerdigini test edin.
        String exceptedUrl = "amazon";
        if (actualUrl.contains(exceptedUrl)){
            System.out.println("Test : PASSED ");
        }else System.out.println("Test : FAILED");

              // Sayfa handle degerini yazdirin
        System.out.println("Handle Degeri : "+driver.getWindowHandle());

              // Sayfa HTML kodlarinda "Gateway" kelimesi gectigini test edin
        if (driver.getPageSource().contains("Gateway")) {
            System.out.println("Test : PASSED ");
        }else System.out.println("Test : FAILED");

              // Sayfayi kapatin.
        driver.close();




    }

}
