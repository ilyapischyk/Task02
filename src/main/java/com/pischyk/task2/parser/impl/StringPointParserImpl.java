package com.pischyk.task2.parser.impl;

import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.parser.StringPointParser;
import com.pischyk.task2.validator.impl.StringPointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringPointParserImpl implements StringPointParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = "\\s+";

    public double[] parsePointsForPyramid(String pointLine) throws CustomException {
        logger.info("Method parsePointsForPyramid called with parameters: " + pointLine);
        if (pointLine.isBlank()) {
            throw new CustomException("Data is empty");
        }
        StringPointValidatorImpl stringValidator = new StringPointValidatorImpl();
        double pointsCoordinate[] = null;
        if (stringValidator.isValidPointsString(pointLine)) {
            String[] elements = pointLine.split(REGEX_FOR_SPLIT);
            pointsCoordinate = new double[elements.length];
            for (int i = 0; i < elements.length; i++) {
                pointsCoordinate[i] = Double.parseDouble(elements[i]);
            }
        }
        if (pointsCoordinate == null) {
            throw new CustomException("Invalid string of point coordinates");
        }
        return pointsCoordinate;
    }
}
