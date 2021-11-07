package com.pischyk.task2.validator.impl;

import com.pischyk.task2.validator.StringPointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringPointValidatorImpl implements StringPointValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_ELEMENT = "(-?(\\d*\\.)?\\d+)";
    private static final String REGEX_FOR_SPLIT = "\\s+";
    private static final int ELEMENTS_IN_POINT_STRING = 15;

    public boolean isValidPointsString(String str){
        logger.info("Method validator of points string called with parameters: " + str);
        if (str.isBlank()) {
            return false;
        }
        boolean isValid = false;
        String[] elements = str.split(REGEX_FOR_SPLIT);
        if (elements.length == ELEMENTS_IN_POINT_STRING) {
            for (String element : elements) {
                if (element.matches(REGEX_FOR_ELEMENT)) {
                    isValid = true;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        logger.info("String: " + str + " - " + isValid);
        return isValid;
    }
}
