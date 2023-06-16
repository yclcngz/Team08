package day_04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    public static void main(String[] args) {

        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Techproeducation sayfasına gidelim
        driver.get("https://www.Techproeducation.com");
        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //Arama bölümünde qa aratalım
        WebElement aramaKutusu =  driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']"));
        aramaKutusu.sendKeys("qa",Keys.ENTER);
        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expected = "qa";
        if (actualTitle.contains(expected)) {
            System.out.println("Title Test1 : PASSED");
        }else System.out.println("Title Test1 : FAILED");
        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement  link = driver.findElement(By.xpath("(//*[@href='https://techproeducation.com/software-career-opportunities-qa/'])[2]"));

        if (link.isEnabled()) {
            System.out.println("Link Test2 :PASSED");
        }else System.out.println("Link Test2 :PASSED");
        //Başlığın Opportunities içerdiğini test edelim
        if (actualTitle.contains("Opportunities")) {
            System.out.println("Test3 : PASSED");
        }else System.out.println("Test3 : PASSED");
        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test4 : PASSED");
        }else System.out.println("Test4 : PASSED");
        //sayfayı kapat
        driver.close();
    }
}
