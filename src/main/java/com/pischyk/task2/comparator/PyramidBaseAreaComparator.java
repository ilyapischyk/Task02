package com.pischyk.task2.comparator;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.service.impl.CalculateServiceImpl;

import java.util.Comparator;

public class PyramidBaseAreaComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        CalculateServiceImpl calculatePyramidService = new CalculateServiceImpl();
        double baseArea1;
        double baseArea2;
        try {
            baseArea1 = calculatePyramidService.baseArea(o1);
            baseArea2 = calculatePyramidService.baseArea(o2);
        } catch (CustomException e) {
            return o1 == null ? -1 : 1;
        }
        return Double.compare(baseArea1, baseArea2);
    }
}
