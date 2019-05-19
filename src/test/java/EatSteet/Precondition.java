package EatSteet;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

//Пример подвязки к другому класу (Public class [name] extends [our class])
public class Precondition {
    protected static WebDriver driver;


    //Initialize the chrome driver
    public void Setup () throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/pasha/Документы/Course_QA_automation/chromedriver");
        driver= new ChromeDriver();
        //Open window in full size
        driver.manage().window().maximize();
    }
}
