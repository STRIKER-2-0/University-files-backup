import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;

public class WebTesting {
    static WebDriver driver;

    @BeforeClass
    public static void start(){
        System.setProperty("webdriver.opera.driver", "operadriver_win64\\operadriver.exe");
        driver = new OperaDriver();
    }
   @Test
    public void firstTest() {
        driver.get("https://pn.com.ua//ct//1003");
        WebElement element = driver.findElements(By.xpath("//*[@id=\"producers-filter-block\"]/div[2]/span[1]/a")).get(0);
        element.click();
        List<WebElement> list =  driver.findElements(By.xpath("*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[1]/a"));
        boolean condition = true;
        for (WebElement elem : list) {
           if(!elem.getText().contains(element.getText())){
               condition = false;
               break;
           }
        }
       Assert.assertTrue(condition);
    }
    @Test
    public void secondTest() throws InterruptedException {
        driver.get("https://pn.com.ua//ct//1003");
        String xpath = "//*[@id=\"producers-filter-block\"]/div[2]/span[1]/a";
        WebElement element = driver.findElement(By.xpath(xpath));
        int expected = Integer.parseInt(driver.findElement(By.xpath(xpath+"//small")).getText());
        element.click();
        Thread.sleep(3000);
        xpath = "/html/body/div[1]/div[2]/div/div[5]/div[1]/ul/li[5]/small/b";
        int actual = Integer.parseInt(driver.findElement(By.xpath(xpath)).getText());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void thirdTest(){
        driver.get("https://pn.com.ua//ct//1003");
        String xpath = "//*[@id=\"column-center\"]/section/div[3]/article";
        driver.findElement(By.xpath(xpath+"[1]/div[2]/div[3]/span[2]/a")).click();
        driver.findElement(By.xpath(xpath+"[2]/div[2]/div[3]/span[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[1]/div[1]/a")).click();
        xpath = "//*[@id=\"mCSB_1_container\"]/div[1]/div/div";
        Assert.assertEquals(2, driver.findElements(By.xpath(xpath)).size());
        Assert.assertTrue(driver.getCurrentUrl().contains("compare"));
    }
    @Test
    public void fourthTest() {
        driver.get("https://pn.com.ua//ct//1003");
        String xpath = "//*[@id=\"column-center\"]/section/div[2]/ul/li[2]/a";
        driver.findElement(By.xpath(xpath)).click();
        xpath = "//*[@id=\"column-center\"]/section/div[2]/ul/li[2]/ul/li[2]/a";
        driver.findElement(By.xpath(xpath)).click();
        xpath = "//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/a/span/strong";
        List<WebElement> prices = driver.findElements(By.xpath(xpath));
        int[] sortedprices = new int[prices.size()];
        for (int i=0; i<prices.size(); i++){
            String temp = prices.get(i).getText().replace(" грн", "");
            sortedprices[i]=Integer.parseInt(temp.replace(" ", ""));
        }
        boolean condition = true;
        for (int i=0; i<sortedprices.length-1; i++){
            if(sortedprices[i]>sortedprices[i+1]){
                condition = false;
                break;
            }
        }
        Assert.assertTrue(condition);
    }
    @Test
    public void fifthTest() {
        String url = "https://pn.com.ua/ct/1003/";
        driver.get(url);
        String xpath = "//*[@id=\"column-center\"]/section/div[3]/article/div[2]/div[3]/span[2]/a";
        List<WebElement> list = driver.findElements(By.xpath(xpath));
        for(int i = 0; i < 4; i++)
            list.get(i).click();
        driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[1]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/section/div[2]/div/div[1]/div[1]/a")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
    @AfterClass
    public static void finish(){
        driver.close();
    }
}
