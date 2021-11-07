package com.pischyk.task2.service;

import com.pischyk.task2.entity.Point;
import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;

public interface CalculateService {
    public double surfaceAreaOfPyramid(Pyramid pyramid) throws CustomException;

    public double baseArea(Pyramid pyramid) throws CustomException;

    public double allArea(Pyramid pyramid) throws CustomException;

    public double volumeOfPyramid(Pyramid pyramid) throws CustomException;

    public double cutOffRatio(Pyramid pyramid) throws CustomException;

    public double pyramidHeight(Pyramid pyramid) throws CustomException;
}
