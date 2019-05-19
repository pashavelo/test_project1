package EatSteet;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import javax.swing.text.View;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EatStreet_registration {
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
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pashavelo+test4@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@id='passwordAgain']")).sendKeys("1234567");

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
        //WebElement Checkbox=driver.findElement(By.xpath("//input[@id='showRestNotes']"));
        //Checkbox.click();

        //Save changes
        driver.findElement(By.xpath("//input[@id='confirm-modal-btn']")).click();

        //Wait 3 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//img[@class='logo-alternate']")).click();
        driver.findElement(By.xpath("//a[@id='menu-my-account']")).click();
        //Trying to change password
        WebElement changepassword = driver.findElement(By.xpath("//a[@id='change-password']"));
        System.out.println(changepassword);
        // Click the element
        Thread.sleep((int) (3000));
        changepassword.click();

        //Change password
        driver.findElement(By.xpath("//input[@id='currentPassword']")).sendKeys("1234567");
        driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='newPasswordConfirm']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@id='confirm-modal-btn']")).click();

        //Singout
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement signout = driver.findElement(By.xpath("//a[@id='signout']"));
        Thread.sleep((int) (3000));
        signout.click();
        System.out.println(driver.getTitle());
            if (driver.getTitle().contains("EatStreet"))
                System.out.println("Good");
            else
                System.out.println("Bad"+driver.getTitle());
        //New Sing in
        driver.findElement(By.xpath("//a[@id='menu-signin']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pashavelo+test4@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@id='signin']")).click();
        System.out.println(driver.getTitle());
            if (driver.getTitle().contains("EatStreet"))
                System.out.println("Good");
            else
                System.out.println("Bad"+driver.getTitle());

        driver.findElement(By.xpath("//a[@id='menu-my-account']")).click();
            System.out.println(driver.getTitle());

        driver.quit();
    }
}
