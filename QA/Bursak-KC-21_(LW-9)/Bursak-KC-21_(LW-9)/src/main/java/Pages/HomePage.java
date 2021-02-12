package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//*[@id='producers-filter-block']/div[2]/span[2]/a")
    WebElement FirstSeller;

    public SellerPage Choose_first_seller(){
        FirstSeller.click();
        return new SellerPage(driver);
    }
}
