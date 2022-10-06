package main.code.com.service.validator.impl;

import main.code.com.service.validator.AbstractValidator;

public class DayValidatorImpl extends AbstractValidator {
    private static final String DAY_REGEX = "^(([1-9])|(1[0-9])|(2[0-9])|(3[0-1]))$";

    @Override
    protected String getRegex() {
        return DAY_REGEX;
    }
}