package com.pischyk.task2.service;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;

public interface FindService {
    public boolean baseLiesOnXY(Pyramid pyramid) throws CustomException;

    public boolean baseLiesOnXZ(Pyramid pyramid) throws CustomException;

    public boolean baseLiesOnYZ(Pyramid pyramid) throws CustomException;

    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) throws CustomException;

    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) throws CustomException;

    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) throws CustomException;
}
