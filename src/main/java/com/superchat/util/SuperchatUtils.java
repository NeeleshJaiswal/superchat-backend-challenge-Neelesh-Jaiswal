package com.superchat.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.validator.routines.EmailValidator;

public class SuperchatUtils {

    public static void validatePhoneNumber(String phoneNumber) throws NumberParseException {
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber number = util.parse(phoneNumber, Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        if (!util.isValidNumber(number)) {
            throw new IllegalArgumentException("Phone number is not valid!" + phoneNumber);
        }
    }

    public static void validateEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalArgumentException("E-mail is not valid!");
        }
    }

    public static String replacePlaceHolders(String text, String name, String bitcoin) {
        if (text.contains("<name>")) {
            text = text.replaceAll("<name>",name);
        }

        if (text.contains("<bitcoin>")) {
            text = text.replaceAll("<bitcoin>",bitcoin);
        }

        return text;
    }


}