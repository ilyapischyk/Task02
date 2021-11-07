package com.pischyk.task2.factory;

import com.pischyk.task2.entity.Point;

public class PointFactory {

    public static Point getPoint(double xCoordinate, double yCoordinate, double zCoordinate){
        Point point = new Point(xCoordinate, yCoordinate, zCoordinate);
        return point;
    }
}
