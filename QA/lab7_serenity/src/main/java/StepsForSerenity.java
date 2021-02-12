import Pages.ComputerPage;
import Pages.HomePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class StepsForSerenity {
    public HomePage homePage;
    public WebDriver driver;
    public ComputerPage computerPage;
    public String siteHomePage = "https://pn.com.ua/";
    @Step("Given the user visits a page {0}")
    public void a_user_visits_a_page(String homePage){
        this.siteHomePage = homePage;
    }
    @Step("When the user chooses category Computer {0}")
    public void the_user_chooses_category_Computer() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "G:\\QA\\lab7_serenity\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get(siteHomePage);
        computerPage = homePage.choisecomputerCategory();
    }
    @Step("Then the user sees {0} subcategory")
    public void the_user_can_see_subcategory_ITService(String subCategory) throws InterruptedException {
        assertThat(computerPage.getTextITService()).overridingErrorMessage("testComputerCategory failed").contains(subCategory);
        driver.close();
    }
}
