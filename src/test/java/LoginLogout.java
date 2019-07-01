import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginLogout {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();   //setting chromedriver properties with WebDriverManager
        WebDriver driver = new ChromeDriver();    //creating driver object
        driver.manage().window().maximize();      //maximize window
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicit wait instead of Thread.sleep(5000)

        //Step1: Open the URL
        driver.get("http://qa2.vytrack.com/user/login"); //open URL
        String loginTitle1 = driver.getTitle();

        //Step2: input username for store manager
        WebElement userField = driver.findElement(By.id("prependedInput"));//creating WebElement for username
        userField.click();                                     //first click
        userField.sendKeys("storemanager202"); //sending username

        //Step3: input valid password for store manager
        WebElement passField = driver.findElement(By.id("prependedInput2"));//creating WebElement for password
        passField.click();                                                  //first click
        passField.sendKeys("UserUser123");                  //sending password

        //Step4: click on "Log in" Button
        driver.findElement(By.id("_submit")).click(); //finding Login button and clicking

        Thread.sleep(5000);//5s waiting time to load page

        //verify logged in successfully
        String dashboardTitle = driver.getTitle();
        if(!dashboardTitle.equals(loginTitle1)){
            System.out.println("Logging in successfully");
        }else{
            System.out.println("Logging in failed");
        }

        //Step5: Click on the name on the left top corner of the page
        driver.findElement(By.xpath("//a[contains(text(),'Alex Jones')]")).click(); //finding name element on right top corner

        Thread.sleep(3000);//3s waiting time to load page

        //Step6: Click on "Log Out" option
        driver.findElement(By.xpath("//a[@class='no-hash']")).click();            //finding Logout element and clicking

        //Step7: verify Logged out successfully
        String loginTitle2 = driver.getTitle();
        if (loginTitle1.equals(loginTitle2)){
            System.out.println("Logging out successfully");
        }else{
            System.out.println("Logging out failed");
        }







    }
}
