package com.pischyk.task2.service.impl;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateServiceTest {
    CalculateServiceImpl calculatePyramidService;

    @BeforeClass
    public void setUp() {
        calculatePyramidService = new CalculateServiceImpl();
    }

    @Test(expectedExceptions = CustomException.class)
    public void surfaceAreaOfPyramidTestWithNull() throws CustomException {
        calculatePyramidService.surfaceAreaOfPyramid(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void baseAreaOfPyramidTestWithNull() throws CustomException {
        calculatePyramidService.baseArea(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void allAreaOfPyramidTestWithNull() throws CustomException {
        calculatePyramidService.allArea(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void volumeOfPyramidTestWithNull() throws CustomException {
        calculatePyramidService.volumeOfPyramid(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void cutOffRatioTestWithNull() throws CustomException {
        calculatePyramidService.cutOffRatio(null);
    }

    @Test(expectedExceptions = CustomException.class)
    public void cutOffRatioTestWithNonIntersectParameters() throws CustomException {
        Pyramid pyramid = new Pyramid();
        pyramid.setTopPoint(new Point(4.0, 4.0, 5.0));
        pyramid.setBasePoint1(new Point(6.0, 6.0, 1.0));
        pyramid.setBasePoint2(new Point(2.0, 6.0, 1.0));
        pyramid.setBasePoint3(new Point(2.0, 2.0, 1.0));
        pyramid.setBasePoint4(new Point(6.0, 2.0, 1.0));
        calculatePyramidService.cutOffRatio(pyramid);
    }

    @Test(expectedExceptions = CustomException.class)
    public void pyramidHeightTestWithNull() throws CustomException {
        calculatePyramidService.pyramidHeight(null);
    }
}