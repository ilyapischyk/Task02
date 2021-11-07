package com.pischyk.task2.service.impl;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FindServiceTest {
    private ArrayList<Pyramid> list;
    private FindServiceImpl findPyramidService;

    @BeforeClass
    public void setParameters() {
        findPyramidService = new FindServiceImpl();
        list = new ArrayList<>();
        Pyramid pyramid1 = new Pyramid(
                new Point(0, 0, 2.0),
                new Point(1.0, 1.0, 0),
                new Point(-1.0, 1.0, 0),
                new Point(-1.0, -1.0, 0),
                new Point(1.0, -1.0, 0));
        list.add(pyramid1);
        Pyramid pyramid2 = new Pyramid(
                new Point(0, 2.0, 0),
                new Point(1.0, 0, 1.0),
                new Point(-1.0, 0, 1.0),
                new Point(-1.0, 0, -1.0),
                new Point(1.0, 0, -1.0));
        list.add(pyramid2);
        Pyramid pyramid3 = new Pyramid(
                new Point(2.0, 0, 0),
                new Point(0, 1.0, 1.0),
                new Point(0, -1.0, 1.0),
                new Point(0, -1.0, -1.0),
                new Point(0, 1.0, -1.0));
        list.add(pyramid3);
    }

    @Test
    public void baseLiesOnXYTest() throws CustomException {
        boolean result = findPyramidService.baseLiesOnXY(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void baseLiesOnXYTestWithNull() throws CustomException {
        findPyramidService.baseLiesOnXY(null);
    }
    @Test
    public void baseLiesOnXZTest() throws CustomException {
        boolean result = findPyramidService.baseLiesOnXZ(list.get(1));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void baseLiesOnXZTestWithNull() throws CustomException {
        findPyramidService.baseLiesOnXZ(null);
    }
    @Test
    public void baseLiesOnYZTest() throws CustomException {
        boolean result = findPyramidService.baseLiesOnYZ(list.get(2));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void baseLiesOnYZTestWithNull() throws CustomException {
        findPyramidService.baseLiesOnXY(null);
    }

    @Test
    public void coordinatePlaneXZIntersectionTest() throws CustomException {
        boolean result = findPyramidService.coordinatePlaneXZIntersection(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void coordinatePlaneXZIntersectionTestWithNull() throws CustomException {
        findPyramidService.coordinatePlaneXZIntersection(null);
    }
    @Test
    public void coordinatePlaneYZIntersectionTest() throws CustomException {
        boolean result = findPyramidService.coordinatePlaneYZIntersection(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void coordinatePlaneYZIntersectionTestWithNull() throws CustomException {
        findPyramidService.coordinatePlaneYZIntersection(null);
    }
    @Test
    public void coordinatePlaneXYIntersectionTest() throws CustomException {
        boolean result = findPyramidService.coordinatePlaneXYIntersection(list.get(1));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = CustomException.class)
    public void coordinatePlaneXYIntersectionTestWithNull() throws CustomException {
        findPyramidService.coordinatePlaneXYIntersection(null);
    }
}