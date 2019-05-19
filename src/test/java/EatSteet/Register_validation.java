package EatSteet;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Register_validation {
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
        driver.get("https://eatstreet.com/create-account");
        //Find Sing Up button
        WebElement SingUpButton = driver.findElement(By.xpath("//button[@id='signup']"));
        if (SingUpButton.isDisplayed())
            System.out.println("SignUpButton is displayed");
        else
            System.out.println("ERROR: SignUPButton is not displayed");
        //Click to button
        SingUpButton.click();

        //Waiting a little bit
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Find all required elements
        WebElement email = driver.findElement(By.id("email-validation-tag"));

        if (email.isDisplayed())
            System.out.println("Email field is required");
        else
            System.out.println("ERROR: Email field is not required");

        WebElement password = driver.findElement(By.xpath("//div[@id='password-validation-tag']"));

        if (password.isDisplayed())
            System.out.println("Password field is required");
        else
            System.out.println("ERROR: password field is not required");

        WebElement passwordagain = driver.findElement(By.xpath("//div[@id='passwordAgain-validation-tag']"));
        if (passwordagain.isDisplayed())
            System.out.println("PasswordAgain field is required");
        else
            System.out.println("ERROR: PasswordAgain field is not required");


    //2nd Test Case
        //Find email field for input
        WebElement EmailField = driver.findElement(By.id("email"));
        EmailField.sendKeys("testgmail.com");
        //Clicking button
        SingUpButton.click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //Find validation of wrong email input
        WebElement Invalid = driver.findElement(By.xpath("//div[@id='email-validation-tag']"));
            if (Invalid.isDisplayed())
                System.out.println("Email field pass validation");
            else
                System.out.println("ERROR: Email field validation failed");

    //3d Test Case
        //Clearing field
        EmailField.clear();
        //Fill Email field
        EmailField.sendKeys("test@gmail.com");
        //Fill password field
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("123");
        //Fill password again field
        WebElement PasswordAgain = driver.findElement(By.id("passwordAgain"));
        PasswordAgain.sendKeys("123");
        //Click to Sing up button
        SingUpButton.click();
        //Search for validation text of password field
        WebElement CharacterMinimum = driver.findElement(By.xpath("//div[@id='password-validation-tag']"));
            if (CharacterMinimum.isDisplayed())
                System.out.println("Password validation passed");
            else
                System.out.println("ERROR: Password validation failed");

    //4th Test Case
        //driver.navigate().refresh();
        //Fill Email field
        EmailField.clear();
        EmailField.sendKeys("test@gmail.com");
        //Fill password field
        PasswordField.clear();
        PasswordField.sendKeys("123456");
        //Fill password again field
        PasswordAgain.clear();
        PasswordAgain.sendKeys("123");
        //Click to Sing up button
        SingUpButton.click();
        WebElement MustMatch = driver.findElement(By.xpath("//div[@id='passwordAgain-validation-tag']"));
            if (MustMatch.isDisplayed())
                System.out.println("Matching passwords is working");
            else
                System.out.println("ERROR: Passwords does not pass matching");

    //5th Test Case
        //Field for input
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        EmailField.clear();
        EmailField.sendKeys("testgmail.com");
        PasswordField.clear();
        PasswordField.sendKeys("12345");
        PasswordAgain.clear();
        PasswordAgain.sendKeys("123");
        //Clicking button
        SingUpButton.click();
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        //Find validation of wrong email input

            if (driver.findElement(By.xpath("//div[@id='email-validation-tag']")).isDisplayed())
                System.out.println("Email field pass validation");
            else
                System.out.println("ERROR: Email field validation failed");
            if (driver.findElement(By.xpath("//div[@id='password-validation-tag']")).isDisplayed())
                System.out.println("Password validation passed");
            else
                System.out.println("ERROR: Password validation failed");
            if (driver.findElement(By.xpath("//div[@id='password-validation-tag']")).isDisplayed())
                System.out.println("Matching passwords is working");
            else
                System.out.println("ERROR: Passwords does not pass matching");

        driver.quit();
    }

}
