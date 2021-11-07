package com.pischyk.task2.service.impl;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointServiceTest {
    @Test
    public void distanceBetweenPointsTest() throws CustomException {
        Point point1 = new Point(1.0, 1.0, 0);
        Point point2 = new Point(2.0, 1.0, 0);
        double actual = PointServiceImpl.distanceBetweenPoints(point1, point2);
        double expected = 1.0;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void distanceBetweenPointsTestWithNull() throws CustomException {
        PointServiceImpl.distanceBetweenPoints(null,new Point());
    }
}