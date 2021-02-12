import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    static WebDriver driver;
    static DesiredCapabilities capabilities;

    @Before

    public void setUp() throws MalformedURLException {
        capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver( new URL("http://localhost:6666/wd/hub"), capabilities);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver.get("https://pn.com.ua/");
    }

    @Test
    public void testTestFirst(){
        driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[4]/a")).click();
        String IT = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[4]/article[3]/div/div/a")).getText();
        Assert.assertEquals(IT, "IT услуги");
    }

    @After
    public void simpleTest(){
        driver.quit();
    }
}
