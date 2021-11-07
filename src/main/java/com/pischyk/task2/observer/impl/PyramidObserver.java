package com.pischyk.task2.observer.impl;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.entity.PyramidValues;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.observer.Observer;
import com.pischyk.task2.observer.PyramidEvent;
import com.pischyk.task2.service.impl.CalculateServiceImpl;
import com.pischyk.task2.warehouse.PyramidWareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserver implements Observer {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void updatePyramidValues(PyramidEvent pyramidEvent) {
        Pyramid pyramid = pyramidEvent.getSource();
        int id = pyramid.getId();
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        PyramidValues pyramidValues = pyramidWareHouse.get(id);
        CalculateServiceImpl calculatePyramidService = new CalculateServiceImpl();
        try {
            pyramidValues.setVolumeOfPyramid(calculatePyramidService.volumeOfPyramid(pyramid));
            pyramidValues.setSurfaceAreaOfPyramid(calculatePyramidService.surfaceAreaOfPyramid(pyramid));
            pyramidValues.setBaseArea(calculatePyramidService.baseArea(pyramid));
            pyramidValues.setAllArea(calculatePyramidService.allArea(pyramid));
        } catch (CustomException e) {
            logger.error("Exception in update pyramid method: " + e);
        }
    }
}
