package com.pischyk.task2.entity;

import com.pischyk.task2.observer.Observable;
import com.pischyk.task2.observer.Observer;
import com.pischyk.task2.observer.PyramidEvent;

import java.util.ArrayList;

public class Pyramid implements Observable {
    private int id;
    private Point topPoint;
    private Point basePoint1;
    private Point basePoint2;
    private Point basePoint3;
    private Point basePoint4;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Pyramid() {
    }

    public Pyramid(Point topPoint, Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4) {
        this.topPoint = topPoint;
        this.basePoint1 = basePoint1;
        this.basePoint2 = basePoint2;
        this.basePoint3 = basePoint3;
        this.basePoint4 = basePoint4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
    }

    public Point getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(Point topPoint) {
        this.topPoint = topPoint;
        notifyObservers();
    }

    public Point getBasePoint1() {
        return basePoint1;
    }

    public void setBasePoint1(Point basePoint1) {
        this.basePoint1 = basePoint1;
        notifyObservers();
    }

    public Point getBasePoint2() {
        return basePoint2;
    }

    public void setBasePoint2(Point basePoint2) {
        this.basePoint2 = basePoint2;
        notifyObservers();
    }

    public Point getBasePoint3() {
        return basePoint3;
    }

    public void setBasePoint3(Point basePoint3) {
        this.basePoint3 = basePoint3;
        notifyObservers();
    }

    public Point getBasePoint4() {
        return basePoint4;
    }

    public void setBasePoint4(Point basePoint4) {
        this.basePoint4 = basePoint4;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        PyramidEvent pyramidEvent = new PyramidEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.updatePyramidValues(pyramidEvent);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pyramid pyramid = (Pyramid) o;

        if (getId() != pyramid.getId()) return false;
        if (getTopPoint() != null ? !getTopPoint().equals(pyramid.getTopPoint()) : pyramid.getTopPoint() != null)
            return false;
        if (getBasePoint1() != null ? !getBasePoint1().equals(pyramid.getBasePoint1()) : pyramid.getBasePoint1() != null)
            return false;
        if (getBasePoint2() != null ? !getBasePoint2().equals(pyramid.getBasePoint2()) : pyramid.getBasePoint2() != null)
            return false;
        if (getBasePoint3() != null ? !getBasePoint3().equals(pyramid.getBasePoint3()) : pyramid.getBasePoint3() != null)
            return false;
        return getBasePoint4() != null ? getBasePoint4().equals(pyramid.getBasePoint4()) : pyramid.getBasePoint4() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getTopPoint() != null ? getTopPoint().hashCode() : 0);
        result = 31 * result + (getBasePoint1() != null ? getBasePoint1().hashCode() : 0);
        result = 31 * result + (getBasePoint2() != null ? getBasePoint2().hashCode() : 0);
        result = 31 * result + (getBasePoint3() != null ? getBasePoint3().hashCode() : 0);
        result = 31 * result + (getBasePoint4() != null ? getBasePoint4().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pyramid{");
        sb.append("id= ");
        sb.append(id);
        sb.append(", topPoint= ");
        sb.append(topPoint);
        sb.append(", basePoint1= ");
        sb.append(basePoint1);
        sb.append(", basePoint2= ");
        sb.append(basePoint2);
        sb.append(", basePoint3= ");
        sb.append(basePoint3);
        sb.append(", basePoint4= ");
        sb.append(basePoint4);
        sb.append("}");
        return sb.toString();
    }


}
