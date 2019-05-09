package rozetka;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class rozetka_test {

    protected static WebDriver driver;

    @Before

    public void SetupTest () throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/pasha/Документы/Course_QA_automation/chromedriver");
        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test

    public void Searchtest(){
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("rozetka.com.ua");
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("a[href='https://rozetka.com.ua/']")).click();
        System.out.println(driver.getTitle());

        if (driver.getTitle().contains("ROZETKA"))
            System.out.println("Good");
        else
            System.out.println("Bad"+driver.getTitle());

        driver.quit();
    }

}
