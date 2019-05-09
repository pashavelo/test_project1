package EatSteet;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EatStreet_test {
    protected static WebDriver driver;

    @Before
    //Initialize the chrome driver
    public void SetupTest () throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/pasha/Документы/Course_QA_automation/chromedriver");
        driver= new ChromeDriver();
        //Open window in full size
        driver.manage().window().maximize();
    }

    @Test

    public void Searchtest() throws InterruptedException {
        //Opening google.com
        driver.get("https://google.com");

        //Waiting 3 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Finding text field for search and clear it
        driver.findElement(By.name("q")).clear();

        //Filling a text field
        driver.findElement(By.name("q")).sendKeys("EatStreet.com");

        //driver.findElement(By.name("btnK")).click();
        //Push enter button on keyboard
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //Finding a eatstreet.com in search results and go to the site
        driver.findElement(By.cssSelector("a[href='https://eatstreet.com/']")).click();

        //Check is the desired site was opened
        System.out.println(driver.getTitle());

            if (driver.getTitle().contains("EatStreet"))
                System.out.println("Good");
            else
                System.out.println("Bad"+driver.getTitle());

        //Wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Find Sign in at the menu and click it
        driver.findElement(By.xpath("//a[@id='menu-signin']")).click();

        //Check is the desired site was opened
        System.out.println(driver.getTitle());
            if (driver.getTitle().contains("Sign In"))
                System.out.println("Good");
            else
                System.out.println("Bad"+driver.getTitle());

        //Wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Search Sing Up and clicking it
        driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
        System.out.println(driver.getTitle());
            if (driver.getTitle().contains("Create an Account"))
                System.out.println("Good");
            else
                System.out.println("Bad"+driver.getTitle());

        //Wait for 3 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Find email field and clear it
        driver.findElement(By.xpath("//input[@id='email']")).clear();

        //Fill fields
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pashavelo+test2@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='passwordAgain']")).sendKeys("123456");

        //Clicking button Sing up
        driver.findElement(By.xpath("//button[@id='signup']")).click();

        //Go to account settings
        driver.findElement(By.xpath("//a[@id='menu-my-account']")).click();

        //Edit account
        driver.findElement(By.xpath("//a[@id='edit-info']")).click();
        //Filling Fields
        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Pavel");
        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Gridasov");
        driver.findElement(By.xpath("//input[@id='phoneNumber']")).clear();
        driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("+380431111111");
        //Не разобрался как отметить чекбокс
        //WebElement tcCheckbox=driver.findElement(By.xpath("//input[@id='showRestNotes']"));
        //tcCheckbox.click();

        //Save changes
        driver.findElement(By.xpath("//input[@id='confirm-modal-btn']")).click();

        //Wait 3 seconds
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

        //Trying to change password
        //driver.findElement(By.id("change-password")).wait(5,);
        driver.findElement(By.xpath("//a[@id='change-password']")).click();






        //driver.findElement(By.xpath("//input[@id='currentPassword']")).sendKeys("123456");
        //driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("1234567");
        //driver.findElement(By.xpath("//input[@id='newPasswordConfirm']")).sendKeys("1234567");
        //driver.findElement(By.xpath("//input[@id='confirm-modal-btn']")).click();



        //driver.findElement(By.xpath("//a[@id='signout']")).click();
        //System.out.println(driver.getTitle());
        //driver.findElement(By.xpath("//a[@id='menu-signin']")).click();
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pashavelo+test1@gmail.com");
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        //driver.findElement(By.xpath("//button[@id='signin']")).click();






        driver.quit();
    }
}
