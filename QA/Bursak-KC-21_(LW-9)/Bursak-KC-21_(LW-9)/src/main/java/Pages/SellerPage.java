package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerPage {
    private WebDriver driver;

    public SellerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "html/body/div[1]/div[2]/div/div[5]/div[1]/ul/li[4]/h1/span")
    private WebElement seller;


    public String getTextSeller(){
        return seller.getText();
    }
}