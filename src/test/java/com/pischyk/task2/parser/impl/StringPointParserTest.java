package com.pischyk.task2.parser.impl;

import com.pischyk.task2.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringPointParserTest {

    @Test
    public void testParsePointsForPyramid() throws CustomException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = "1.0   1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        double[] expected = {1.0, 1.0, 0, -1.0, 1.0, 0, -1.0, -1.0, 0, 1.0, -1.0, 0, 0, 0, 2.0};
        double[] actual = stringPointParser.parsePointsForPyramid(actualString);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomException.class)
    public void testParsePointsForPyramidWithInvalidString() throws CustomException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = "1.c0  1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        stringPointParser.parsePointsForPyramid(actualString);
    }

    @Test(expectedExceptions = CustomException.class)
    public void testParsePointsForPyramidWithNullString() throws CustomException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = null;
        stringPointParser.parsePointsForPyramid(actualString);
    }
}