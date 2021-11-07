package com.pischyk.task2.validator.impl;

import com.pischyk.task2.validator.StringPointValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringPointValidatorTest {

    @Test
    public void isValidPointsStringTestWithValidString() {
        StringPointValidator stringPointValidator = new StringPointValidatorImpl();
        String actualString = "1.0   1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        boolean actual = stringPointValidator.isValidPointsString(actualString);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidPointsStringTestWithInvalidString() {
        StringPointValidator stringPointValidator = new StringPointValidatorImpl();
        String actualString = "1.0   1.0   0c    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        boolean actual = stringPointValidator.isValidPointsString(actualString);
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidPointsStringTestWithEmptyString() {
        StringPointValidator stringPointValidator = new StringPointValidatorImpl();
        String actualString = " ";
        boolean actual = stringPointValidator.isValidPointsString(actualString);
        Assert.assertFalse(actual);
    }
}