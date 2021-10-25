package co.com.sofka.userinterfaces.practiceform;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class PracticeForm extends PageObject {

    public static final Target USERNAME_LOGIN = Target
            .the("User name login")
            .located(id("txtUsername"));

    public static final Target PASSWORD_LOGIN = Target
            .the("Password login")
            .located(id("txtPassword"));
    public static final Target SUBMIT_LOGIN = Target
            .the("Submit Login")
            .located(id("btnLogin"));

    public static final Target RECRUITMENT = Target
            .the("Admin")
            .located(id("menu_recruitment_viewRecruitmentModule"));

    public static final Target SEARCH = Target
            .the("Search")
            .located(id("btnSrch"));
    public static final Target NAME_CANDIDATE_VALIDATION = Target
            .the("name candidate Admin")
            .located(id("candidateSearch_candidateName"));

    public static final Target ADD = Target
            .the("ADD")
            .located(id("btnAdd"));


    public static final Target FIRST_NAME = Target
            .the("first name")
            .located(id("addCandidate_firstName"));

    //For validations.
    public static final Target MIDDLE_NAME = Target
            .the("Middle Name")
            .located(id("addCandidate_middleName"));


    public static final Target LAST_NAME = Target
            .the("Last Name")
            .located(id("addCandidate_lastName"));

    public static final Target EMAIL = Target
            .the("Email ")
            .located(id("addCandidate_email"));


    public static final Target CONTACT_NO = Target
            .the("Contact No")
            .located(id("addCandidate_contactNo"));
    public static final Target JOB_VANCANCY = Target
            .the("Job Vacancy")
            .located(id("addCandidate_vacancy"));
    public static final Target RESUME = Target
            .the("Resume")
            .located(xpath("//input[@id='addCandidate_resume']"));
    public static final Target KEYWORDS = Target
            .the("Keywords")
            .located(id("addCandidate_keyWords"));
    public static final Target COMMENT = Target
            .the("Comment")
            .located(id("addCandidate_comment"));
    public static final Target DATE_APPLICATION = Target
            .the("Date_application")
            .located(id("addCandidate_appliedDate"));
    public static final Target CONSENT_KEEP_DATA = Target
            .the("ConsentKeepData")
            .located(xpath("//*[@id=\"frmAddCandidate\"]/fieldset/ol[2]/li[6]/label"));
    public static final Target SAVE = Target
            .the("Save")
            .located(id("btnSave"));
    public static final Target BACK = Target
            .the("Back")
            .located(id("btnBack"));
    public static final Target CANDIDATE_NAME_VALIDATION = Target
            .the("Candidate name")
            .located(id("candidateSearch_candidateName"));
    public static final Target KEYWORD_VALIDATION = Target
            .the("Keyword name")
            .located(id("candidateSearch_keywords"));



   /* public static final Target STUDENT_NAME_VALIDATION = Target
            .the("Student Name")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"));
    */
   /* public static final Target GENDER_VALIDATION = Target
            .the("Gender")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]"));

    public static final Target MOBILE_VALIDATION = Target
            .the("Gender")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]"));

    public static final Target DATE_OF_BIRTH_VALIDATION = Target
            .the("Gender")
            .located(xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]"));
*/
}
