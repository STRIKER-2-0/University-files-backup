import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumGrid {
    static WebDriver driver;
    static DesiredCapabilities capabilities;
    private static String siteHomePage = "https://pn.com.ua/ct/1047/";

    @BeforeClass
    public static void setUp()throws Exception {
        capabilities=DesiredCapabilities.chrome();
        driver=new RemoteWebDriver(new URL("http://localhost:6666/wd/hub"),capabilities);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver.get(siteHomePage);
    }

    @Test
    public void testSeller()throws Exception{
        driver.findElement(By.xpath(".//*[@id='producers-filter-block']/div[2]/span[2]/a")).click();
        //assertThat( driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[5]/div[1]/ul/li[4]/h1/span")).getText()).contains("AsRock в Харькове");
    }

    @AfterClass
    public static void simpleTest()throws Exception{
        driver.quit();
    }
}
