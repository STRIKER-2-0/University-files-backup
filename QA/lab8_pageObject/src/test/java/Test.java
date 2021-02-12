import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
public class Test {
    static String siteHomePage = "https://pn.com.ua/";
    private static WebDriver driver;
    private HomePage homePage;
    private ComputerPage computerPage;

    @BeforeClass
    public static void testBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "G:\\QA\\lab7_serenity\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(siteHomePage);
    }

    @org.junit.Test
    public void testComputerCategory() throws Exception {
        homePage = PageFactory.initElements(driver, HomePage.class);
        computerPage = homePage.choisecomputerCategory();
        System.out.println(computerPage.getTextITService());
        computerPage.getTextITService();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        assertThat(computerPage.getTextITService()).contains("IT услуги");
        driver.close();
    }
}
