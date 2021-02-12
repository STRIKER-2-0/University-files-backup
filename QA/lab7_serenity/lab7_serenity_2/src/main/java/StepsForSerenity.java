import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class StepsForSerenity {
    public HomePage homePage;
    public WebDriver driver;
    public int[] prices;
    public String url = "https://pn.com.ua/";
    @Step("Given the user visits a page {0}")
    public void a_user_visits_a_page(String url){
        this.url = url;
    }
    @Step("When the user chooses filter by cost {0}")
    public void the_user_chooses_filter_by_cost() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "G:\\QA\\lab7_serenity\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(url);
        prices=homePage.chooseFilter();
    }
    @Step("Then the user sees sorted prices")
    public void the_user_sees_sorted_prices() {
        boolean condition = true;
        for (int i=0; i<prices.length-1; i++)
            if(prices[i]>prices[i+1]){
                condition = false;
                break;
            }
        assertThat(condition).isEqualTo(true);
        driver.close();
    }
}
