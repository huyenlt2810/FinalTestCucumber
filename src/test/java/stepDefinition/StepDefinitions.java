package stepDefinition;

import POM.SubscriptionPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    SubscriptionPage subscriptionPage;

    @Before
    public void initTest () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        subscriptionPage = new SubscriptionPage(this.driver);
    }
    @After
    public void close (Scenario scenario) {
//        if (scenario.isFailed()) {
//            byte[] img = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(img, "image/png", "error");
//        }
        byte[] img = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(img, "image/png", "error");
        this.driver.close();
    }
    @Given("^Testmaster page is showed$")
    public void testmaster_page_is_showed() {
        this.subscriptionPage.open();
    }
//    @Given("^The user input valid email \"([^\"]*)\"$")
//    public void the_user_input_valid_email_something(String email){
//        this.driver.get("http://testmaster.vn/");
//        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        subscriptionPage.txtEmail.sendKeys(email);
//        subscriptionPage.btnDangky.click();
//    }
//
//    @Given("^Information pop up is showed$")
//    public void information_pop_up_is_showed() {
//        WebDriverWait waitInforPopup = new WebDriverWait(this.driver, 10);
//        WebElement inforPopup = waitInforPopup.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.popover-body b")));
//    }

    @When("^The user input in email textbox with \"([^\"]*)\"$")
    public void the_user_input_in_email_textbox_with_something(String email) {
        subscriptionPage.txtEmail.sendKeys(email);
        subscriptionPage.btnDangky.click();
    }
    @When("^The user input in email textbox with \"([^\"]*)\" and click Đồng ý button in pop up$")
    public void the_user_input_in_email_textbox_with_something_and_click_ng_button_in_pop_up(String email)  {
        subscriptionPage.txtEmail.sendKeys(email);
        subscriptionPage.btnDangky.click();
        this.subscriptionPage.waitEmaiErr();
        subscriptionPage.btcDongY.click();
    }
//    @When("^The user input Ho va ten field with blank data$")
//    public void the_user_input_ho_va_ten_field_with_blank_data() {
//        subscriptionPage.btnDongYPopup.click();
//    }
//
//    @When("^The user click Escape on screen$")
//    public void the_user_click_escape_on_screen() {
//        subscriptionPage.btnCancel.click();
//    }

//    @When("^The user input correct infomation with Họ và tên: \"([^\"]*)\"$")
//    public void the_user_input_correct_infomation_with_h_v_tn_something(String name)  {
//        subscriptionPage.txtHoVaTen.sendKeys(name);
//        subscriptionPage.btnDongYPopup.click();
//    }

    @Then("^The message \"([^\"]*)\" with red border will be showed$")
    public void the_message_something_with_red_border_will_be_showed(String msg) {
        this.subscriptionPage.reInnitElement();
        Assert.assertEquals(msg, this.subscriptionPage.errorEmailMsg.getText());
        Assert.assertEquals(this.subscriptionPage.colorMsgExpect, this.subscriptionPage.errorEmailMsg.getCssValue("color"));
        Assert.assertEquals(this.subscriptionPage.colorBoderExpected, this.subscriptionPage.txtEmail.getCssValue("border-color"));
    }
    @Then("^The message \"([^\"]*)\" will be showed$")
    public void the_message_something_will_be_showed(String email) {
        this.subscriptionPage.waitEmaiErr();
        Assert.assertEquals(email, this.subscriptionPage.existedEmailErr.getText());
    }

    @Then("^Popup is closed, focus on Email field and clear data in Email field$")
    public void popup_is_closed_focus_on_email_field_and_clear_data_in_email_field(){

    }
    @Then("^information screen will be showed with title: \"([^\"]*)\", Giới tính: \"([^\"]*)\", Loại tin muốn nhận: \"([^\"]*)\"$")
    public void information_screen_will_be_showed_with_title_something_gii_tnh_something_loi_tin_mun_nhn_something(String title, String gender, String newsType) {
        this.subscriptionPage.reInnitElement();
        this.subscriptionPage.waitInforPopup();
        Assert.assertEquals(title, this.subscriptionPage.inforPopup.getText());
        Assert.assertEquals(gender, subscriptionPage.dropdownGender.getText());
        Assert.assertEquals(newsType, subscriptionPage.dropdownNewsType.getText());
    }

//    @Then("^The message \"([^\"]*)\" with red color and red border and yellow background$")
//    public void the_message_something_with_red_color_and_red_border_and_yellow_background(String errorMsg)  {
//        Assert.assertEquals(errorMsg, subscriptionPage.errorMsgHoVaTen.getText());
//        Assert.assertEquals("", subscriptionPage.txtHoVaTen.getCssValue("border-color"));
//        Assert.assertEquals("", subscriptionPage.txtHoVaTen.getCssValue("background-color"));
//    }
//    @Then("^Popup is closed and focus on Email field$")
//    public void popup_is_closed_and_focus_on_email_field() {
//
//    }

//    @Then("^The message \"([^\"]*)\" is showed$")
//    public void the_message_something_is_showed(String msg){
//        WebDriverWait waitMsg = new WebDriverWait(this.driver, 10);
//        WebElement msgSuccess = waitMsg.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.body-message")));
//        Assert.assertEquals(msg, msgSuccess.getText());
//    }

//    @After
//    public void end () {
//        driver.close();
//    }

}
