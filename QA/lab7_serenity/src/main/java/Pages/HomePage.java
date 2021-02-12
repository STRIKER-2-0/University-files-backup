package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"column-center\"]/section/div[4]/a")
    private WebElement computerCategory;

    @FindBy(xpath = ".//*[@id='column-center']/section/div[6]/a")
    private WebElement buildingCategory;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public ComputerPage choisecomputerCategory() throws InterruptedException{
        computerCategory.click();
        return new ComputerPage(driver);
    }
}
