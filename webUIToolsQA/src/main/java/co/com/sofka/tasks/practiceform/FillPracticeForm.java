package co.com.sofka.tasks.practiceform;

import co.com.sofka.userinterfaces.practiceform.PracticeForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static co.com.sofka.userinterfaces.practiceform.PracticeForm.*;

public class FillPracticeForm implements Task {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNo;
    private String jobVacancy;
    private String keywords;
    private String comment;
    /*private String dateAplication;*/
    private String consentKeepData;
    private String day;
    private String month;
    private String monthNumber;
    private String year;
    private String fullDate;
    private WebDriver browser;
    private String ruta=System.getProperty("user.dir")+"\\src\\test\\resources\\document\\resume.pdf";

    public FillPracticeForm usingWebDriver(WebDriver browser) {
        this.browser = browser;
        return this;
    }
    public FillPracticeForm usingFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillPracticeForm usingMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public FillPracticeForm usingLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillPracticeForm usingEmail(String email) {
        this.email = email;
        return this;
    }

    public FillPracticeForm usingContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public FillPracticeForm usingJobVancancy(String jobVacancy) {
        this.jobVacancy = jobVacancy;
        return this;
    }

    public FillPracticeForm usingKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public FillPracticeForm usingComment(String comment) {
        this.comment = comment;
        return this;
    }

    /*public FillPracticeForm UsingDateAplication(String dateAplication) {
        this.dateAplication = dateAplication;
        return this;
    }*/

    public FillPracticeForm UsingConsetKeep(String consentKeepData) {
        this.consentKeepData = consentKeepData;
        return this;
    }
    public FillPracticeForm usingDay(String day) {
        this.day = day;
        return this;
    }

    public FillPracticeForm usingMonth(String month) {
        this.month = month;
        return this;
    }public FillPracticeForm usingMonthNumber(String monthNumber) {
        this.monthNumber = monthNumber;
        return this;
    }

    public FillPracticeForm usingYear(String year) {
        this.year = year;
        return this;
    }public FillPracticeForm usingFullDate(String fullDate) {
        this.fullDate = fullDate;
        return this;
    }public FillPracticeForm usingRuta(String ruta) {
        this.ruta = ruta;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(FIRST_NAME),
                Enter.theValue(firstName).into(FIRST_NAME),

                Scroll.to(MIDDLE_NAME),
                Enter.theValue(middleName).into(MIDDLE_NAME),

                Scroll.to(LAST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),

                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),
                //  SelectFromOptions.byVisibleText("Enabled").from(email),

                Scroll.to(CONTACT_NO),
                Enter.theValue(contactNo).into(CONTACT_NO),

                Scroll.to(JOB_VANCANCY),
                SelectFromOptions.byVisibleText(jobVacancy).from(JOB_VANCANCY),
                
                Scroll.to(RESUME),
                Enter.keyValues(ruta).into(RESUME),

                Scroll.to(KEYWORDS),
                Enter.theValue(keywords).into(KEYWORDS),

                Scroll.to(COMMENT),
                Enter.theValue(comment).into(COMMENT),

                /*Scroll.to(DATE_APPLICATION),
                Click.on(DATE_APPLICATION),
                //ElementeDate(),*/

                Scroll.to(DATE_APPLICATION),
                Clear.field(DATE_APPLICATION),
                Enter.theValue(fullDate).into(DATE_APPLICATION),

                Click.on(CONSENT_KEEP_DATA),

                Scroll.to(SAVE),
                Click.on(SAVE),

                Scroll.to(BACK),
                Click.on(BACK)


                );

    }
   /* public Performable ElementeDate(){
        Click.on(By.xpath("//option[. = '" + year + "']"));
        Click.on(By.xpath("//option[. = '" + month + "']"));
        // clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getDay() + "') and contains(@aria-label, '" + practiceFormModel.getMonth() + "')]"));

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat3 = new SimpleDateFormat("dd");
        String strFecha = year + "-"+monthNumber+"-"+day;
        Date date2 = null;
        try {
            date2 = dateFormat2.parse(strFecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String today = dateFormat3.format(date2);

        List<WebElement> allRows = browser.findElements(By.tagName("tr"));

        int i = 0;
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int j = 0;
            for (WebElement cell : cells) {
                if (i != 0 && cell.getText().equalsIgnoreCase(today)) {
                    cell.click();
                }
                j++;
            }
            i++;
        }
        return this;
    }*/


    public static FillPracticeForm fillPracticeForm() {
        return new FillPracticeForm();
    }
}
