package com.pischyk.task2.factory;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.validator.impl.PyramidValidatorImpl;

public class PyramidFactory {
    private static int id = 1;

    public static Pyramid getPyramid(Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4, Point topPoint) throws CustomException {
        PyramidValidatorImpl pyramidValidator = new PyramidValidatorImpl();
        if (!pyramidValidator.isPyramidValid(basePoint1, basePoint2, basePoint3, basePoint4, topPoint)) {
            throw new CustomException("Incorrect data to create pyramid");
        }
        Pyramid pyramid = new Pyramid();
        pyramid.setId(id);
        pyramid.setBasePoint1(basePoint1);
        pyramid.setBasePoint2(basePoint2);
        pyramid.setBasePoint3(basePoint3);
        pyramid.setBasePoint4(basePoint4);
        pyramid.setTopPoint(topPoint);
        id++;
        return pyramid;
    }
}
