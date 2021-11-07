package com.pischyk.task2.warehouse;

import com.pischyk.task2.entity.PyramidValues;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PyramidWareHouse {
    private Map<Integer, PyramidValues> valuesMap;
    private static PyramidWareHouse instance;

    private PyramidWareHouse() {
        valuesMap = new HashMap<>();
    }

    public static PyramidWareHouse getInstance() {
        if (instance == null) {
            instance = new PyramidWareHouse();
        }
        return instance;
    }

    public PyramidValues get(Integer key) {
        return valuesMap.get(key);
    }

    public PyramidValues put(Integer key, PyramidValues value) {
        return valuesMap.put(key, value);
    }

    public boolean remove(Integer key, PyramidValues value) {
        return valuesMap.remove(key, value);
    }

    public Collection<PyramidValues> values() {
        return valuesMap.values();
    }
}
