package Step_Def;

import Base.Config;
import Page_Object.SignUp_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_Step extends Config {
    SignUp_page signUp = new SignUp_page(driver);

    @Given("I am at talentTEK Home Page")
    public void iAmAtTalentTEKHomePage() {
        signUp.goToSignupPage();

    }

    @And("I click on Create New Account button")
    public void iClickOnCreateNewAccountButton() {
        signUp.createNewAccountButton();

    }

    @And("I filled out the form with valid information")
    public void iFilledOutTheFormWithValidInformation() {
        signUp.EnterFirstName();
        signUp.EnterLastName();
        signUp.EnterEmail();
        signUp.EnterPassword();
        signUp.EnterConfirmPassword();
        signUp.enterDOB();
        signUp.Female();
    }

    @And("I clicked on agree checkbox")
    public void iClickedOnAgreeCheckbox() {
        signUp.Agree();
    }

    @When("I click Create My Account button")
    public void iClickCreateMyAccountButton() {
        signUp.createNewAccountButton();
    }

    @Then("I will verify Thank you message")
    public void iWillVerifyThankYouMessage() {
        signUp.verifyThankYouMessage();
    }
}
