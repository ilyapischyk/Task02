package com.pischyk.task2.validator.impl;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.service.impl.CalculateServiceImpl;
import com.pischyk.task2.service.impl.PointServiceImpl;
import com.pischyk.task2.validator.PyramidValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.Set;

public class PyramidValidatorImpl implements PyramidValidator{
    private static final int REQUIRED_NUMBER_OF_POINTS = 5;
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isPyramidValid(Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4, Point topPoint) {
        logger.info("Method of validation pyramid called with next options: " + "basePoint1= " + basePoint1 +
                "basePoint2= " + basePoint2 + "basePoint3= " + basePoint3 + "basePoint4= " + basePoint4 + "topPoint= " + topPoint);
        Set<Point> points = new HashSet<>();
        points.add(basePoint1);
        points.add(basePoint2);
        points.add(basePoint3);
        points.add(basePoint4);
        points.add(topPoint);
        if (points.size() != REQUIRED_NUMBER_OF_POINTS) {
            return false;
        }
        boolean flag = false;
        try {
            double distanceBetweenBasePoints1_2 = PointServiceImpl.distanceBetweenPoints(basePoint1, basePoint2);
            double distanceBetweenBasePoints2_3 = PointServiceImpl.distanceBetweenPoints(basePoint2, basePoint3);
            double distanceBetweenBasePoints3_4 = PointServiceImpl.distanceBetweenPoints(basePoint3, basePoint4);
            double distanceBetweenBasePoints1_4 = PointServiceImpl.distanceBetweenPoints(basePoint1, basePoint4);

            if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ() &&
                    basePoint3.getZ() == basePoint4.getZ() && basePoint1.getZ() != topPoint.getZ()) {
                if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                        distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                    flag = true;
                }
            }
            if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY() &&
                    basePoint3.getY() == basePoint4.getY() && basePoint1.getY() != topPoint.getY()) {
                if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                        distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                    flag = true;
                }
            }
            if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX() &&
                    basePoint3.getX() == basePoint4.getX() && basePoint1.getX() != topPoint.getX()) {
                if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                        distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                    flag = true;
                }
            }
        }catch (CustomException exp){
            logger.error(exp.getMessage());
        }
        logger.info("result: " + flag);
        return flag;
    }
}
