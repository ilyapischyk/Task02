package com.pischyk.task2.creator;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.factory.PointFactory;
import com.pischyk.task2.factory.PyramidFactory;
import com.pischyk.task2.repository.PyramidRepository;

import java.util.ArrayList;

public class PyramidRepositoryCreator {

    public static void createRepository(ArrayList<double[]> listPointsCoordinate) throws CustomException {
        PyramidRepository pyramidRepository = PyramidRepository.getInstance();
        ArrayList<Point> pointArrayList = new ArrayList<>();
        for (double[] temp : listPointsCoordinate
        ) {
            for (int i = 0; i < temp.length; i += 3) {
                Point tempPoint = PointFactory.getPoint(temp[i], temp[i + 1], temp[i + 2]);
                pointArrayList.add(tempPoint);
            }
        }
        for (int i = 0; i < pointArrayList.size(); i += 5) {
            Point basePoint1 = pointArrayList.get(i);
            Point basePoint2 = pointArrayList.get(i + 1);
            Point basePoint3 = pointArrayList.get(i + 2);
            Point basePoint4 = pointArrayList.get(i + 3);
            Point topPoint = pointArrayList.get(i + 4);
            Pyramid pyramid = PyramidFactory.getPyramid(basePoint1, basePoint2, basePoint3, basePoint4, topPoint);
            pyramidRepository.add(pyramid);
        }
    }
}
