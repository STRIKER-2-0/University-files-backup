import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StartPage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"column-center\"]/section/div[2]/ul/li[2]/a")
    private WebElement filter;
    @FindBy(xpath = "//*[@id=\"column-center\"]/section/div[2]/ul/li[2]/ul/li[2]/a")
    private WebElement filter_by_cost;
    @FindBy(xpath = "//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/a/span/strong")
    private List<WebElement> prices;

    public StartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public int[] chooseFilter() throws InterruptedException{
        filter.click();
        filter_by_cost.click();
        int[] sortedprices = new int[prices.size()];
        for (int i=0; i<prices.size(); i++){
            String temp = prices.get(i).getText().replace(" грн", "");
            sortedprices[i]=Integer.parseInt(temp.replace(" ", ""));
        }
        return sortedprices;
    }
}
