package com.pischyk.task2.entity;

public class PyramidValues {
    private double surfaceAreaOfPyramid;
    private double baseArea;
    private double allArea;
    private double volumeOfPyramid;

    public double getSurfaceAreaOfPyramid() {
        return surfaceAreaOfPyramid;
    }

    public void setSurfaceAreaOfPyramid(double surfaceAreaOfPyramid) {
        this.surfaceAreaOfPyramid = surfaceAreaOfPyramid;
    }

    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public double getAllArea() {
        return allArea;
    }

    public void setAllArea(double allArea) {
        this.allArea = allArea;
    }

    public double getVolumeOfPyramid() {
        return volumeOfPyramid;
    }

    public void setVolumeOfPyramid(double volumeOfPyramid) {
        this.volumeOfPyramid = volumeOfPyramid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PyramidValues that = (PyramidValues) o;

        if (Double.compare(that.getSurfaceAreaOfPyramid(), getSurfaceAreaOfPyramid()) != 0) return false;
        if (Double.compare(that.getBaseArea(), getBaseArea()) != 0) return false;
        if (Double.compare(that.getAllArea(), getAllArea()) != 0) return false;
        return Double.compare(that.getVolumeOfPyramid(), getVolumeOfPyramid()) == 0;
    }

    @Override
    public int hashCode() {
        int result = (int) surfaceAreaOfPyramid;
        result = 31 * result + (int) baseArea;
        result = 31 * result + (int) allArea;
        result = 31 * result + (int) volumeOfPyramid;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PyramidValues{");
        sb.append("surfaceAreaOfPyramid= ");
        sb.append(surfaceAreaOfPyramid);
        sb.append(", baseArea= ");
        sb.append(baseArea);
        sb.append(", allArea= ");
        sb.append(allArea);
        sb.append(", volumeOfPyramid= ");
        sb.append(volumeOfPyramid);
        sb.append("}");
        return sb.toString();
    }
}

