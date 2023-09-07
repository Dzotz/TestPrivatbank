package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoPage extends AbstractPage{

    By videoAuthorAvatar = By.xpath(".//div[@id='owner']//*[@id='avatar']");
    By videoAuthorName = By.xpath(".//div[@id='owner']//*[@id='channel-name']//a");
    public VideoPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> d.findElement(videoAuthorName));
    }

    public ChannelPage clickVideoAuthorAvatar(){
        driver.findElement(videoAuthorAvatar).click();
        return new ChannelPage(driver);

    }

    public String getAuthorName(){
        return driver.findElement(videoAuthorName).getText();
    }
}
