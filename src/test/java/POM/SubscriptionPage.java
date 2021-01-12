package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public SubscriptionPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
