package pl.karnecki.validator;


import pl.karnecki.model.Message;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private SimpleDateFormat simpleDateFormat;

    @Override
    public void initialize(DateFormat dateFormat) {
        simpleDateFormat = new SimpleDateFormat(Message.DATE_FORMAT);
    }

    public boolean isValid(String date, ConstraintValidatorContext constraintContext) {
        if (date == null) {
            return false;
        }

        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

}
