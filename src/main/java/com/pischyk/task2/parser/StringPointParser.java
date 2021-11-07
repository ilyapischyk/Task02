package com.pischyk.task2.parser;

import com.pischyk.task2.exception.CustomException;

public interface StringPointParser {
    public double[] parsePointsForPyramid(String pointLine) throws CustomException;
}
