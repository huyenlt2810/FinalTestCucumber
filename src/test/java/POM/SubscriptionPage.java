package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SubscriptionPage {
    @FindBy (css = "input[type=\"email\"]")
    public WebElement txtEmail;
    @FindBy (css = "button.next-btn-primary")
    public WebElement btnDangky;
    @FindBy (css = "div.popover-footer [id=\"allow-button\"]")
    public WebElement btcDongY;
    @FindBy (css = "button[id=\"ddlGender\"] span.content-display")
    public WebElement dropdownGender;
    @FindBy (css = "button[id=\"ddlNewsType\"] span.content-display")
    public WebElement dropdownNewsType;
    @FindBy (css = "div.popover-footer [id=\"allow-button\"]")
    public WebElement btnDongYPopup;
    @FindBy (css = "input[id=\"fullname\"]")
    public WebElement txtHoVaTen;
    @FindBy(css = "div.error")
    public WebElement errorMsgHoVaTen;
    @FindBy (css = "button[id=\"cancel-button\"]")
    public WebElement btnCancel;

    @FindBy (xpath = "//span[text()=\"* Email không đúng định dạng\"]")
    public  WebElement errorEmailMsg;
    public String colorMsgExpect = "rgba(255, 0, 0, 1)";
    public String colorBoderExpected = "rgb(255, 0, 0)";

    @FindBy (css = "div.body-message")
    public WebElement existedEmailErr;
    @FindBy (css = "div.popover-body b")
    public WebElement inforPopup;

    WebDriver driver;
    public SubscriptionPage (WebDriver driver) {
        this.driver = driver;
    }

    public void open () {
        this.driver.get("http://testmaster.vn/");
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
    public void reInnitElement () {
        PageFactory.initElements(driver, this);
    }
    public void waitEmaiErr () {
        WebDriverWait waitEmailErr = new WebDriverWait(this.driver, 10);
        waitEmailErr.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.body-message")));
    }
    public void waitInforPopup () {
        WebDriverWait waitInforPopup = new WebDriverWait(this.driver, 10);
        waitInforPopup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.popover-body b")));
    }
}
