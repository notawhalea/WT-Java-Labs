package main.code.com.service.validator;

import main.code.com.service.validator.impl.*;

public class ValidatorFactory {
    private final EmailValidatorImpl emailValidator = new EmailValidatorImpl();
    private final NameValidatorImpl nameValidator = new NameValidatorImpl();
    private final PriceValidatorImpl priceValidator = new PriceValidatorImpl();
    private final PhoneValidatorImpl phoneValidator=new PhoneValidatorImpl();
    private final NaturalNumberValidator naturalNumberValidator=new NaturalNumberValidator();
    private final IdValidatorImpl idValidator=new IdValidatorImpl();
    private final YearValidatorImpl yearValidator=new YearValidatorImpl();
    private final MonthValidatorImpl monthValidator=new MonthValidatorImpl();
    private final HourValidatorImpl hourValidator=new HourValidatorImpl();
    private final MinuteValidatorImpl minuteValidator=new MinuteValidatorImpl();
    private final DayValidatorImpl dayValidator=new DayValidatorImpl();
    private final StatusValidatorImpl statusValidator=new StatusValidatorImpl();


    public StatusValidatorImpl getStatusValidator() {
        return statusValidator;
    }

    public static ValidatorFactory getInstance() {
        return Holder.INSTANCE;
    }

    public EmailValidatorImpl getEmailValidator() {
        return emailValidator;
    }

    public DayValidatorImpl getDayValidator() {
        return dayValidator;
    }

    public IdValidatorImpl getIdValidator() {
        return idValidator;
    }

    public MinuteValidatorImpl getMinuteValidator() {
        return minuteValidator;
    }

    public HourValidatorImpl getHourValidator() {
        return hourValidator;
    }

    public YearValidatorImpl getYearValidator() {
        return yearValidator;
    }

    public MonthValidatorImpl getMonthValidator() {
        return monthValidator;
    }


    public NameValidatorImpl getNameValidator() {
        return nameValidator;
    }

    public PriceValidatorImpl getPriceValidator() {
        return priceValidator;
    }

    public PhoneValidatorImpl getPhoneValidator() {
        return phoneValidator;
    }

    public NaturalNumberValidator getNaturalNumberValidator() {
        return naturalNumberValidator;
    }

    private static class Holder {
        static final ValidatorFactory INSTANCE = new ValidatorFactory();
    }
}
