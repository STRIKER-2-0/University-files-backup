import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "G:\\QA\\lab7_serenity\\chromedriver_win32\\chromedriver.exe");
        String siteHomePage = "https://pn.com.ua/";
        WebDriver driver = new ChromeDriver();
        driver.get(siteHomePage);
        HomePage homePage;
        ComputerPage computerPage;
        homePage = PageFactory.initElements(driver, HomePage.class);
        computerPage = homePage.choisecomputerCategory();
        System.out.println(computerPage.getTextITService());
    }
}
