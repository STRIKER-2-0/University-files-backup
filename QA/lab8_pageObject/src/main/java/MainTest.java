import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    static WebDriver driver;
    static String homeURL = "https://pn.com.ua/ct/1003/";
    private StartPage startPage;

    @BeforeClass
    public static void startTest(){
        System.setProperty("webdriver.chrome.driver", "G:\\QA\\lab7_serenity\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(homeURL);
    }

    @Test
    public void test() throws InterruptedException {
        startPage = new StartPage(driver);
        int[] prices = startPage.chooseFilter();
        boolean sorted = true;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] > prices[i+1]){
                sorted = false;
                break;
            }
        }
        Assert.assertTrue(sorted);
    }
}
