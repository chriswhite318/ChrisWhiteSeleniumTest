import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.GetLeaders;

import java.io.IOException;


public class MailChimpLeadershipTeam {
    public static void main(String[] args) throws InterruptedException, IOException {

        //Setup and create headless driver
        String phantomJSDriverExePath = "/Users/ChrisWhite/Downloads/phantomjs"; //unique path to phantomJS driver
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takeScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                phantomJSDriverExePath);
        WebDriver driver = new PhantomJSDriver(caps);

        /* Option to run visually with ChromeDriver
        String chromeDriverExePath = "/Users/ChrisWhite/Downloads/chromedriver"; //unique path to chrome driver
        System.setProperty("webdriver.chrome.driver", chromeDriverExePath );
        WebDriver driver = new ChromeDriver();
        */

        // Navigate to the About page of MailChimp.com
        driver.get("http://www.mailchimp.com");
        driver.findElement(By.linkText("About MailChimp")).click();
        Thread.sleep(1500);

        // Method to get leadership information from About page
        GetLeaders gl = new GetLeaders();
        gl.getLeaders(driver);

        // Close WebDriver
        driver.close();
    }

}
