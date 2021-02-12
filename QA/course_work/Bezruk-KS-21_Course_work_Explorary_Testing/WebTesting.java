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
        WebElement element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span[2]/a"));
        element.click();
    }
    @Test
    public void secondTest() throws InterruptedException {
        driver.get("https://pn.com.ua//ct//1003");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span[2]/a"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span/a[1]"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]"));
        String[] strs = element.getAttribute("class").split(" ")ж
        Assert.assertTrue(! (strs[strs.length-1].contains("active")));
    }
    @Test
    public void thirdTest(){
        driver.get("https://pn.com.ua//ct//1003");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span[2]/a"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span/a[2]"));
        element.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("compare"));
    }
    @Test
    public void fourthTest() {
        driver.get("https://pn.com.ua//ct//1003");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[3]/article[1]/div[2]/div[3]/span[2]/a"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[1]/div[1]/a"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/div/div/a"));
        element.click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"mCSB_1_container\"]/div[1]/div/div"));
        Assert.assertEquals(0, elements.size());
    }
    @Test
    public void fifthTest() {
        driver.get("https://pn.com.ua//ct//1003");
        String Listxpath = "//*[@id=\"column-center\"]/section/div[3]/article/div[2]/div[3]/span[2]/a";
        List<WebElement> elements = driver.findElements(By.xpath(Listxpath));
        for(int i=0; i<4; i++)
            elements.get(i).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"column-center\"]/section/div[1]/div[1]/a"));
        element.click();
        Listxpath = "//*[@id=\"mCSB_1_container\"]/div[1]/div/div";
        elements = driver.findElements(By.xpath(Listxpath));
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/section/div[1]/ul/li[2]/a"));
        element.click();
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/section/div[1]/ul/li[2]/ul/li[2]/a"));
        element.click();
        List<WebElement> changed = driver.findElements(By.xpath(Listxpath));
        boolean isChanged = false;
        for(int i=0; i<4; i++)
            if(elements.get(i) != changed.get(i))
                isChanged=true;
        Assert.assertTrue(isChanged);
    }
    @AfterClass
    public static void finish(){

    }
}
