package Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class VytrackShortcut {
    public static WebDriver driver;

    public static void main(String[] args) {
        //1. Open browser
        //2. Go to Vytrack login page
        openBrowserUrl("chrome", "http://qa2.vytrack.com/user/login");

        //3. Login as a sales manager
        WebElement userField = driver.findElement(By.id("prependedInput"));//creating WebElement for username
        userField.sendKeys("salesmanager264"); //sending username

        WebElement passField = driver.findElement(By.id("prependedInput2"));//creating WebElement for password
        passField.sendKeys("UserUser123"+ Keys.ENTER);                  //sending password

        //4. Verify Dashboard page is open
        String currentTitle = driver.getTitle();
        System.out.println( currentTitle.equals("Dashboard") ? "Dashboard page is open" : "Dashboard page is not open");

        waitTime(5000);
        //5. Click on Shortcuts icon
        driver.findElement(By.className("fa-share-square")).click();

        //6. Click on link See full list
        driver.findElement(By.linkText("See full list")).click();

        waitTime(5000);
        //7. Click on link Opportunities
        driver.findElement(By.linkText("Opportunities")).click();

        //8. Verify Open opportunities page is open
        String openOppPage = driver.getTitle();
        System.out.println( openOppPage.startsWith("Open Opportunities") ? "Open opportunities page is open":"Open opportunities page is not open");


        waitTime(5000);
        //9. Click on Shortcuts icon
        driver.findElement(By.className("fa-share-square")).click();
        driver.findElement(By.linkText("See full list")).click();

        waitTime(5000);
        //10. Click on link Vehicle Service Logs
        driver.findElement(By.linkText("Vehicle Services Logs")).click();

        //11. Verify error message text is You do not have permission to perform this action.
        //12. Verify Open opportunities page is still open

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
                System.out.println("Wrong browser name!");
        }

        driver.manage().window().maximize();
        driver.get(url);
    }


    public static void waitTime(long millis){

        try{
            Thread.sleep(millis);

        }catch (Exception e){}
    }

}
