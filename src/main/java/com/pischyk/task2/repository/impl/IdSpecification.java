package com.pischyk.task2.repository.impl;

import com.pischyk.task2.entity.Pyramid;
import com.pischyk.task2.repository.Specification;

public class IdSpecification implements Specification {
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        boolean result = pyramid.getId()==id;
        return result;
    }
}
