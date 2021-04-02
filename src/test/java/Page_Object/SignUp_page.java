package Page_Object;

import Base.Config;
import Base.TestData;
import Base.Util;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUp_page extends Config {
    Faker faker = new Faker();
    Util util = new Util();

    public SignUp_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='wrap']/div/div/div/a")
    public WebElement createNewAccount;
    // firstName edit box
    @FindBy(how = How.NAME, using = "firstName")
    public WebElement firstName;
    // lastName edit box
    @FindBy(how = How.NAME, using = "lastName")
    public WebElement lastName;
    // email edit box
    @FindBy(how = How.NAME, using = "email")
    public WebElement email;
    // password edit box
    @FindBy(how = How.NAME, using = "password")
    public WebElement password;
    // confirm password edit box
    @FindBy(how = How.NAME, using = "confirmPassword")
    public WebElement confirmPassword;
    // Month drop down
    @FindBy(how = How.NAME, using = "month")
    public WebElement month;
    // Day drop down
    @FindBy(how = How.NAME, using = "day")
    public WebElement day;
    // Year drop down
    @FindBy(how = How.NAME, using = "year")
    public WebElement year;
    // radio button
    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    public WebElement radioButton;
    // male radio button
    @FindBy(how = How.ID, using = "male")
    public WebElement male;
    // female radio button
    @FindBy(how = How.ID, using = "female")
    public WebElement female;
    // agree checkbox
    @FindBy(how = How.ID, using = "defaultCheck1")
    public WebElement agreeCheckBox;
    // Create My Account button
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement createMyAccountButton;
    // Thank you message
    @FindBy(how = How.XPATH, using = "//*[@id='success_message']/div")
    public WebElement thankYouMsg;
    // Get Student Id
    @FindBy(how = How.XPATH, using = "//*[@id='success_message']/div")
    public WebElement studentId;
    // Sign in Link from Global Navigation Bar
    @FindBy(how = How.XPATH, using = "//li[2]/a")
    public WebElement signInLinkFromGNB;
    //_________________________________________________________________
    public void goToSignupPage() {
        String getCurrentUrl = driver.getCurrentUrl();}
    public void createNewAccountButton() {
        createNewAccount.click();
    }

    public void EnterFirstName() {
        TestData.studentFirstName = faker.name().firstName();
        firstName.sendKeys(studentFirstName);
        System.out.println("Student First Name" + studentFirstName);
    }

    public void EnterLastName() {
        TestData.studentLastName = faker.name().lastName();
        lastName.sendKeys(studentLastName);
        System.out.println("Student Last Name" + studentLastName);
    }

    public void EnterEmail() {
        TestData.studentEmail = faker.internet().emailAddress();
        email.sendKeys(studentEmail);
        System.out.println("Student Email" + studentEmail);
    }

    public void EnterPassword() {
        password.sendKeys(studentPassword);
    }

    public void EnterConfirmPassword() {
        confirmPassword.sendKeys(studentConfirmPassword);
    }

    public void enterDOB() {
        util.dropdownByVisibleText(month, "Aug");
        util.dropdownByVisibleText(day, "26");
        util.dropdownByValue(year, "2003");
    }

    public void Female() {
        female.click();
    }

    public void Agree() {
        agreeCheckBox.click();
    }

    public void clickCreateMyAccountButton() {
        createMyAccountButton.click();
    }

    public void verifyThankYouMessage() {
        String exp = "Thank you for sign up";
        String act = thankYouMsg.getText().substring(0, 21);
        System.out.println("act message is ==>" + act);
        Assert.assertEquals(act, exp);
    }

    public void getStudentId() {
        TestData.studentId = studentId.getText().substring(38);
    }

    public void clickOnSignInLinkFromGNB() {
        signInLinkFromGNB.click();
    }

}
