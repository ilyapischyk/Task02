package com.pischyk.task2.comparator;

import com.pischyk.task2.entity.Pyramid;

import java.util.Comparator;

public class PyramidTopPointZcoordinateComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        return Double.compare(o1.getTopPoint().getZ(), o2.getTopPoint().getZ());
    }
}
