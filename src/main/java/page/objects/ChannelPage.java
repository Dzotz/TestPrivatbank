package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChannelPage extends AbstractPage{

    By subscribeBtn = By.xpath(".//div[@id='channel-header']//div[@id='subscribe-button']");
    By loginText = By.xpath(".//tp-yt-iron-dropdown//ytd-button-renderer[@id='button']//span");
    public ChannelPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> d.findElement(subscribeBtn));
    }

    public void clickSubscribeBtn() {
        driver.findElement(subscribeBtn).click();
    }

    public String getLoginText(){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(loginText));
        return driver.findElement(loginText).getText();
    }
}
