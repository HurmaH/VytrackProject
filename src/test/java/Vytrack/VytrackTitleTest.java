package Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.util.concurrent.TimeUnit;

public class VytrackTitleTest {

    public static WebDriver driver;

    public static void main(String[] args) {

        //1. Open browser
        //2. Go to Vytrack login page
        openBrowserUrl("chrome", "http://qa2.vytrack.com/user/login");

        //3. Login as any user
        WebElement userField = driver.findElement(By.id("prependedInput"));//creating WebElement for username
        userField.sendKeys("storemanager202"); //sending username

        WebElement passField = driver.findElement(By.id("prependedInput2"));//creating WebElement for password
        passField.sendKeys("UserUser123"+ Keys.ENTER);                  //sending password

        waitTime(7000);
        //4. Click on your name on top right
        driver.findElement(By.id("user-menu")).click(); //finding name element on right top corner


        //5. Click on My Configuration
        driver.findElement(By.linkText("My Configuration")).click();

        waitTime(5000);
        //6. Verify that title start with the same name on top right
        boolean startsWith = driver.getTitle().startsWith("Alex Jones");
        System.out.println(startsWith? "Title starts with Alex Jones": "Title does not start with Alex Jones");

        driver.close();

    }


    public static void openBrowserUrl(String browser, String url) {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new IllegalArgumentException("Wrong browser name!");
        }

        driver.manage().window().maximize();
        driver.get(url);
    }


    public static void waitTime(long millis) {

        try {
            Thread.sleep(millis);

        } catch (Exception e) {
        }
    }

}


