package com.pischyk.task2.comparator;

import com.pischyk.task2.entity.Pyramid;

import java.util.Comparator;

public class PyramidTopPointXcoordinateComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        return Double.compare(o1.getTopPoint().getX(), o2.getTopPoint().getX());
    }
}
