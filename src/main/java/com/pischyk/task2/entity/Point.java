package com.pischyk.task2.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;
        return Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result = (int) x;
        result = 31 * result + (int) y;
        result = 31 * result + (int) z;
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point{");
        sb.append("x= ");
        sb.append(x);
        sb.append(", y= ");
        sb.append(y);
        sb.append(", z= ");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
