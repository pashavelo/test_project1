package EatSteet;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Authorization_validation {
    protected static WebDriver driver;

    @Before
    //Initialize the chrome driver
    public void Setup () throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/pasha/Документы/Course_QA_automation/chromedriver");
        driver= new ChromeDriver();
        //Open window in full size
        driver.manage().window().maximize();
    }

    @Test
    //1st Test Case
    public void validation() throws InterruptedException {
        driver.get("https://eatstreet.com/signin");
        //Select Sign in button
        WebElement SignINbutton = driver.findElement(By.xpath("//button[@id='signin']"));

        //Click sign in button
        SignINbutton.click();

        //Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Check for required fields
            if (driver.findElement(By.xpath("//div[@id='email-validation-tag']")).isDisplayed())
                System.out.println("Email and password fields is required");
            else
                System.out.println("ERROR: Email and password fields is not required");

        //Next case for wrong data entered
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pashavelo+test1gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        //Click Sign in button
        Thread.sleep((int) (3000));
        SignINbutton.click();
        Thread.sleep((int) (3000));

        //Wait
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            if (driver.findElement(By.xpath("//span[@class='alert text-red ng-scope']")).isDisplayed())

                System.out.println("Wrong data validation PASS");
            else
                System.out.println("ERROR: Wrong data validation failed");


        driver.quit();
    }
}
