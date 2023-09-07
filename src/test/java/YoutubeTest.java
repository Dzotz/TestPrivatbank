import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.ChannelPage;
import page.objects.MainPage;
import page.objects.SearchResultPage;
import page.objects.VideoPage;

import java.time.Duration;


public class YoutubeTest {

    private WebDriver driver;

    @BeforeSuite
    public void setup(){
        System.out.println("Executing on Chrome");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=ru");
        driver = new ChromeDriver(opt);
    }

    @Parameters({"url", "pageTitle", "loginBtnText"})
    @Test
    public void youtubeUserStoryRepeat(String url, String pageTitle, String loginBtnText){
        //Open Youtube Page

        driver.get(url);
        Assert.assertEquals(driver.getTitle(), pageTitle, "Title of page is not YouTube");

        //Search on Main page
        MainPage mainPage = new MainPage(driver);
        String text = String.valueOf((int)(Math.random()*9900+100));
        mainPage.enterSearchText(text);

        driver.manage().window().fullscreen();

        //Open Video

        SearchResultPage searchResultPage = mainPage.pressSearchVariant();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.titleContains(text));
        String videoName = searchResultPage.getVideoName();
        VideoPage videoPage = searchResultPage.clickVideoLink();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.titleContains(videoName));

        //Open Author

        String authorName = videoPage.getAuthorName();
        ChannelPage channelPage = videoPage.clickVideoAuthorAvatar();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.titleContains(authorName));

        //Check Log In button after Subscribe being pressed
        channelPage.clickSubscribeBtn();
        String actualLoginText = channelPage.getLoginText();

        Assert.assertEquals(actualLoginText, loginBtnText, "Wrong Login btn text");
    }


    @AfterSuite
    public void close(){
        driver.close();
    }

}
