package co.com.sofka.stepdefinition.practiceform;

import co.com.sofka.exceptions.practiceform.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.com.sofka.exceptions.practiceform.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.practiceform.PracticeForm.practiceForm;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.tasks.practiceform.BrowseToPracticeForm.browseToPracticeForm;
import static co.com.sofka.tasks.practiceform.FillPracticeForm.fillPracticeForm;
import static co.com.sofka.tasks.practiceform.SearchUser.searchUserPracticeForm;

import static co.com.sofka.userinterfaces.practiceform.PracticeForm.NAME_CANDIDATE_VALIDATION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static org.hamcrest.CoreMatchers.equalTo;

public class PracticeFormStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Student";
    private DataTable dataToValidate;
    private List<WebElement> allRows;
    private String resultValidationUser;
    private String fullName;


    @Given("the student is on landing page of Tools QA")
    public void theStudentIsOnLandingPageOfToolsQA() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandingPage()
        );
    }

    @When("him browse to registration form")
    public void himBrowseToRegistrationForm() {
        theActorInTheSpotlight().attemptsTo(
                browseToPracticeForm()
                        .usingUserName("Admin")
                        .usingPassword("admin123")
        );
    }

    @When("him has filled it and submitted")
    public void himHasFilledItAndSubmitted(io.cucumber.datatable.DataTable dataTable) {
        dataToValidate = dataTable;
        System.out.println(dataTable.row(12).get(1));
        theActorInTheSpotlight().attemptsTo(
                fillPracticeForm()
                        .usingFirstName(dataTable.row(0).get(1))
                        .usingMiddleName(dataTable.row(1).get(1))
                        .usingLastName(dataTable.row(2).get(1))
                        .usingEmail(dataTable.row(3).get(1))
                        .usingContactNo(dataTable.row(4).get(1))
                        .usingJobVancancy(dataTable.row(5).get(1))
                        .usingKeywords(dataTable.row(6).get(1))
                        .usingComment(dataTable.row(7).get(1))
                        .usingYear(dataTable.row(8).get(1))
                        .usingMonth(dataTable.row(9).get(1))
                        .usingDay(dataTable.row(10).get(1))
                        .usingMonthNumber(dataTable.row(11).get(1))
                        .usingFullDate(dataTable.row(12).get(1))
                        //.usingRuta("\\src\\test\\resources\\document\\resume.pdf")

                        .usingWebDriver(browser)
        );
    }

    @When("browse the page and search for the user")
    public void browseThePageAndSearchForTheUser() {
        fullName=dataToValidate.row(0).get(1)+" "+dataToValidate.row(1).get(1)+" "+dataToValidate.row(2).get(1);
        theActorInTheSpotlight().attemptsTo(
                searchUserPracticeForm()
                        .andUsingAserssionUserName(fullName)
                        .andUsingAserssionKeyword(dataToValidate.row(6).get(1))
        );
    }


    @Then("the student will see a registration information")
    public void theStudentWillSeeARegistrationInformation() {
        allRows = getResultTable();
        theActorInTheSpotlight().should(
                seeThat(practiceForm()

                        .wasFullName(validateUsers(allRows,fullName))



                        .is(), equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome())
                        )
        );
    }

    private String compareInWithSystemOutcome() {
        return "\n" + "Data for test : System outcome"
                + "\n" + fullName + " "+fullName+ " : " + NAME_CANDIDATE_VALIDATION.resolveFor(theActorInTheSpotlight()).getText();

    }

    public List<WebElement> getResultTable() {
        WebElement table = browser.findElement(By.id("resultTable"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        return allRows;
    }

    public String validateUsers(List<WebElement> allRows, String usuario) {

        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if (i == 2 && cell.getText().equalsIgnoreCase(usuario)) {
                     resultValidationUser = cell.getText();
                    System.out.println(resultValidationUser);
                     return resultValidationUser;
                }
                i++;
            }
        }
        return "fallo";
    }

}
