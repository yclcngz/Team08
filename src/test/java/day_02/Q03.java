package day_02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Position;
import java.time.Duration;

public class Q03 {
    public static void main(String[] args) {

        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon soyfasina gidelim. "https://www.amazon.com/"
        driver.get("https://www.amazon.com/");
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("PagePosition : "+driver.manage().window().getPosition());
        System.out.println("PageSize : "+driver.manage().window().getSize());
        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(4,4));
        driver.manage().window().setSize(new Dimension(400,500));
        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point myPoint = new Point(4,4);
        driver.manage().window().setPosition(myPoint);
        Point actualPosition = driver.manage().window().getPosition();
        if (myPoint.equals(actualPosition)){
            System.out.println("Test : PASSED");
        }else System.out.println("Test : FAILED");

        Dimension mySize = new Dimension(400,500);
        driver.manage().window().setSize(mySize);
        Dimension actualSize = driver.manage().window().getSize();

        if (mySize.equals(actualSize)){
            System.out.println("Test : PASSED");
        }else System.out.println("Test : FAILED");

        //8. Sayfayi kapatin
        driver.close();

    }

}
