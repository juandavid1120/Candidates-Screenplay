package co.com.sofka.questions.practiceform;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.practiceform.PracticeForm.*;

public class PracticeForm implements Question<Boolean> {

    private String fullName;

    String fullNameValidation;
    String valueInputfirstNameValidation;
    String valueInputMiddleNameValidation;
    String valueInputLastNameValidation;

    public PracticeForm wasFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }





    public PracticeForm is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        valueInputfirstNameValidation=NAME_CANDIDATE_VALIDATION.resolveFor(actor).getTextValue();

        if(valueInputfirstNameValidation.equals(fullName)){
            return true;
        }
        return false;

    }

    public static PracticeForm practiceForm(){
        return new PracticeForm();
    }
}
