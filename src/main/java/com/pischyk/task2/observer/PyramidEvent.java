package com.pischyk.task2.observer;

import com.pischyk.task2.entity.Pyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {

    public PyramidEvent(Object source) {
        super(source);
    }

    @Override
    public Pyramid getSource() {
        return (Pyramid) super.getSource();
    }
}
