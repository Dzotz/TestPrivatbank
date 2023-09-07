package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage{

    By searchLine = By.xpath(".//input[@id='search']");
    By searchVariant = By.xpath(".//ul[@class='sbsb_b']/li[position() = 2]");
    public MainPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> d.findElement(searchLine));
    }

    public void enterSearchText(String text){
        driver.findElement(searchLine).click();
        driver.findElement(searchLine).sendKeys(text);
    }

    public SearchResultPage pressSearchVariant(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(searchVariant));
        driver.findElement(searchVariant).click();
        return new SearchResultPage(driver);
    }


}
