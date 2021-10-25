package co.com.sofka.tasks.practiceform;

import co.com.sofka.userinterfaces.practiceform.PracticeForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import static co.com.sofka.userinterfaces.practiceform.PracticeForm.*;

public class SearchUser implements Task {
     private String assercionUserName;
     private String assercionKeyword;


    public SearchUser andUsingAserssionUserName(String assercionUserName) {
        this.assercionUserName = assercionUserName;
        return this;
    } public SearchUser andUsingAserssionKeyword(String assercionKeyword) {
        this.assercionKeyword = assercionKeyword;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(KEYWORD_VALIDATION),
                Enter.theValue(assercionKeyword).into(KEYWORD_VALIDATION),

                Scroll.to(SEARCH),
                Click.on(SEARCH),
                Scroll.to(NAME_CANDIDATE_VALIDATION),
                Enter.theValue(assercionUserName).into(NAME_CANDIDATE_VALIDATION)

           );


    }

    public static SearchUser searchUserPracticeForm(){
        return new SearchUser();
    }
}
