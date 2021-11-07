package com.pischyk.task2.creator;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.entity.PyramidValues;
import com.pischyk.task2.exception.CustomException;
import com.pischyk.task2.repository.PyramidRepository;
import com.pischyk.task2.service.impl.CalculateServiceImpl;
import com.pischyk.task2.warehouse.PyramidWareHouse;
import java.util.ArrayList;

public class PyramidWarehouseCreator {

    public static void createWarehouse(PyramidRepository pyramidRepository) throws CustomException {
        ArrayList<Pyramid> pyramidList = new ArrayList<>(pyramidRepository.getAll());
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        CalculateServiceImpl calculatePyramidService = new CalculateServiceImpl();
        for (Pyramid pyramid : pyramidList
        ) {
            PyramidValues pyramidValues = new PyramidValues();
            pyramidValues.setAllArea(calculatePyramidService.allArea(pyramid));
            pyramidValues.setBaseArea(calculatePyramidService.baseArea(pyramid));
            pyramidValues.setSurfaceAreaOfPyramid(calculatePyramidService.surfaceAreaOfPyramid(pyramid));
            pyramidValues.setVolumeOfPyramid(calculatePyramidService.volumeOfPyramid(pyramid));
            pyramidWareHouse.put(pyramid.getId(), pyramidValues);
        }
    }
}
