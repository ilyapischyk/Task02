package com.pischyk.task2.validator.impl;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.factory.PointFactory;
import com.pischyk.task2.parser.StringPointParser;
import com.pischyk.task2.parser.impl.StringPointParserImpl;
import com.pischyk.task2.reader.DataReader;
import com.pischyk.task2.reader.impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class PyramidValidatorTest {
    ArrayList<Point> arrayPointList;

    @BeforeClass
    public void setArrayList() throws CustomException {
        ClassLoader classLoader = PyramidValidatorTest.class.getClassLoader();
        URL resource = classLoader.getResource("data/testdataforpyramidvalidator.txt");
        DataReader dataReader = new DataReaderImpl();
        ArrayList<String> coordinateList = dataReader.readFile(new File(resource.getFile()).getAbsolutePath());
        StringPointParser stringPointParser = new StringPointParserImpl();
        arrayPointList = new ArrayList<>();
        for (String str : coordinateList
        ) {
            double[] temp = stringPointParser.parsePointsForPyramid(str);
            for (int i = 0; i < temp.length; i += 3) {
                Point point = PointFactory.getPoint(temp[i], temp[i + 1], temp[i + 2]);
                arrayPointList.add(point);
            }
        }
    }

    @DataProvider(name = "points_dataprovider")
    public Object[][] builderDataProvider() {
        Object[][] data = new Object[3][2];
        data[0][0] = true;
        data[1][0] = true;
        data[2][0] = false;
        int counter = 0;
        ArrayList<Point> pyramidPoints;
        for (int i = 0; i < 3; i++) {
            pyramidPoints = new ArrayList<>();
            pyramidPoints.add(arrayPointList.get(counter));
            pyramidPoints.add(arrayPointList.get(counter + 1));
            pyramidPoints.add(arrayPointList.get(counter + 2));
            pyramidPoints.add(arrayPointList.get(counter + 3));
            pyramidPoints.add(arrayPointList.get(counter + 4));
            data[i][1] = pyramidPoints;
            counter += 5;
        }
        return data;
    }

    @Test(dataProvider = "points_dataprovider")
    public void isPyramidValidTest(boolean expected, ArrayList<Point> listPoints) {
        PyramidValidatorImpl pyramidValidator = new PyramidValidatorImpl();
        boolean actual = pyramidValidator.isPyramidValid(listPoints.get(0), listPoints.get(1), listPoints.get(2),
                listPoints.get(3), listPoints.get(4));
        Assert.assertEquals(actual, expected);
    }
}