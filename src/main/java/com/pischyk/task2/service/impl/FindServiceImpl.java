package com.pischyk.task2.service.impl;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.service.FindService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindServiceImpl implements FindService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean baseLiesOnXY(Pyramid pyramid) throws CustomException {
        logger.info("Method baseLiesOnXY called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() == 0 & pyramid.getBasePoint2().getZ() == 0 &
                pyramid.getBasePoint3().getZ() == 0 & pyramid.getBasePoint4().getZ() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean baseLiesOnXZ(Pyramid pyramid) throws CustomException {
        logger.info("Method baseLiesOnXZ called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() == 0 & pyramid.getBasePoint2().getY() == 0 &
                pyramid.getBasePoint3().getY() == 0 & pyramid.getBasePoint4().getY() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean baseLiesOnYZ(Pyramid pyramid) throws CustomException {
        logger.info("Method baseLiesOnYZ called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() == 0 & pyramid.getBasePoint2().getX() == 0 &
                pyramid.getBasePoint3().getX() == 0 & pyramid.getBasePoint4().getX() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) throws CustomException {
        logger.info("Method coordinatePlaneXYIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() < 0 && pyramid.getBasePoint3().getZ() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getZ() > 0 && pyramid.getBasePoint3().getZ() < 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) throws CustomException {
        logger.info("Method coordinatePlaneXZIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() < 0 && pyramid.getBasePoint3().getY() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getY() > 0 && pyramid.getBasePoint3().getY() < 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) throws CustomException {
        logger.info("Method coordinatePlaneYZIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new CustomException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() < 0 && pyramid.getBasePoint3().getX() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getX() > 0 && pyramid.getBasePoint3().getX() < 0) {
            flag = true;
        }
        return flag;
    }
}
