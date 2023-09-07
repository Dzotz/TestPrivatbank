package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage extends AbstractPage{

    By videoLink = By.xpath(".//div[@id='contents']/ytd-video-renderer[position() = 4]//a[@id='video-title']");
    public SearchResultPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(d -> d.findElement(videoLink));
    }

    public VideoPage clickVideoLink(){
        driver.findElement(videoLink).click();
        return new VideoPage(driver);
    }

    public String getVideoName(){
        return driver.findElement(videoLink).getText();
    }
}
