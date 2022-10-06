package main.code.com.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractValidator implements Validator {
    protected abstract String getRegex();

    @Override
    public boolean isValid(String expression) {
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(expression);
        return matcher.find();
    }
}
