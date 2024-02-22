package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ZeroBankPage {

    public ZeroBankPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(id = "user_login")
    public WebElement loginName;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signinSubmitButton;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLink;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLink;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignLink;

    @FindBy(id = "pc_currency")
    public WebElement currencyDdm;

}