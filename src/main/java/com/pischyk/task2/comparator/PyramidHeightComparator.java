package com.pischyk.task2.comparator;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class PyramidHeightComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        CalculateServiceImpl calculatePyramidService = new CalculateServiceImpl();
        double height1;
        double height2;
        try {
            height1 = calculatePyramidService.pyramidHeight(o1);
            height2 = calculatePyramidService.pyramidHeight(o2);
        } catch (CustomException e) {
            return o1 == null ? -1 : 1;
        }
        return Double.compare(height1, height2);
    }
}
