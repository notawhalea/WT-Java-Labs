package main.code.com.service.validator.impl;

import main.code.com.service.validator.AbstractValidator;

public class MinuteValidatorImpl extends AbstractValidator {
    private static final String MINUTE_REGEX = "^(([1-5]?([0-9])))$";

    @Override
    protected String getRegex() {
        return MINUTE_REGEX;
    }
}