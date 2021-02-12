package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputerPage {
    private WebDriver driver;

    @FindBy(xpath = ".//*[id='column-center']/section/div[4]/article[3]/div/div/a")
                      //*[@id="column-center"]/section/div[4]/article[3]/div/div/a
    private WebElement ITService;
    //*[@id="column-center"]/section/div[4]/article[3]/div/div/a
    @FindBy(xpath = "html/body/div[1]/div[2]/div/div/div[1]/ul/li[1]/a/span")
    private WebElement returnHomePage;

    public ComputerPage(WebDriver driver){
        this.driver = driver;
        //ITService = driver.findElement(By.xpath(".//*[@id=\"column-center\"]/section/div[4]/article[3]/div/div/a"));
        PageFactory.initElements(driver, this);
    }

    public HomePage returnHomePage(){
        returnHomePage.click();
        return new HomePage(driver);
    }

    public String getTextITService()  {
        return ITService.getText();
    }

}
