package com.pischyk.task2.repository;

import com.pischyk.task2.entity.Pyramid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidRepository {
    private List<Pyramid> pyramidList;
    private static PyramidRepository instance;

    private PyramidRepository() {
        pyramidList = new ArrayList<>();
    }

    public static PyramidRepository getInstance() {
        if (instance == null) {
            instance = new PyramidRepository();
        }
        return instance;
    }

    public boolean add(Pyramid pyramid) {
        return pyramidList.add(pyramid);
    }

    public boolean addAll(Collection<? extends Pyramid> c) {
        return pyramidList.addAll(c);
    }

    public boolean remove(Pyramid pyramid) {
        return pyramidList.remove(pyramid);
    }

    public boolean removeAll(Collection<?> c) {
        return pyramidList.removeAll(c);
    }

    public Pyramid getPyramid(int index) {
        return pyramidList.get(index);
    }

    public List<Pyramid> getAll() {
        List<Pyramid> copy = new ArrayList<>(pyramidList);
        return copy;
    }

    public void setPyramid(int index, Pyramid pyramid) {
        pyramidList.set(index, pyramid);
    }

    public List<Pyramid> queryStream(Specification specification) {
        List<Pyramid> list = pyramidList.stream().filter(o -> specification.specified(o)).collect(Collectors.toList());
        return list;
    }

    public List<Pyramid> query(Specification specification) {
        List<Pyramid> list = new ArrayList<>();
        for (Pyramid pyramid : pyramidList
        ) {
            if (specification.specified(pyramid)) {
                list.add(pyramid);
            }
        }
        return list;
    }

    public List<Pyramid> sort(Comparator<? super Pyramid> comparator) {
        return pyramidList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
