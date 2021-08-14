package com.epam.jwd.entity;

import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.reader.Readable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Point {
    private float abscissaAxis1;
    private float ordinateAxis1;

    private float abscissaAxis2;
    private float ordinateAxis2;

    private float abscissaAxis3;
    private float ordinateAxis3;

    private float abscissaAxis4;
    private float ordinateAxis4;

    public Point(float abscissaAxis1, float ordinateAxis1, float abscissaAxis2, float ordinateAxis2,
                 float abscissaAxis3, float ordinateAxis3, float abscissaAxis4, float ordinateAxis4) {
        this.abscissaAxis1 = abscissaAxis1;
        this.ordinateAxis1 = ordinateAxis1;
        this.abscissaAxis2 = abscissaAxis2;
        this.ordinateAxis2 = ordinateAxis2;
        this.abscissaAxis3 = abscissaAxis3;
        this.ordinateAxis3 = ordinateAxis3;
        this.abscissaAxis4 = abscissaAxis4;
        this.ordinateAxis4 = ordinateAxis4;
    }

    public Point(Point readInputDataPoint) {
    }

    public Point() {

    }

    public Point(ArrayList<Point> pointArrayList) {

    }

    public float getAbscissaAxis1() {
        return abscissaAxis1;
    }

    public void setAbscissaAxis1(float abscissaAxis1) {
        this.abscissaAxis1 = abscissaAxis1;
    }

    public float getOrdinateAxis1() {
        return ordinateAxis1;
    }

    public void setOrdinateAxis1(float ordinateAxis1) {
        this.ordinateAxis1 = ordinateAxis1;
    }

    public float getAbscissaAxis2() {
        return abscissaAxis2;
    }

    public void setAbscissaAxis2(float abscissaAxis2) {
        this.abscissaAxis2 = abscissaAxis2;
    }

    public float getOrdinateAxis2() {
        return ordinateAxis2;
    }

    public void setOrdinateAxis2(float ordinateAxis2) {
        this.ordinateAxis2 = ordinateAxis2;
    }

    public float getAbscissaAxis3() {
        return abscissaAxis3;
    }

    public void setAbscissaAxis3(float abscissaAxis3) {
        this.abscissaAxis3 = abscissaAxis3;
    }

    public float getOrdinateAxis3() {
        return ordinateAxis3;
    }

    public void setOrdinateAxis3(float ordinateAxis3) {
        this.ordinateAxis3 = ordinateAxis3;
    }

    public float getAbscissaAxis4() {
        return abscissaAxis4;
    }

    public void setAbscissaAxis4(float abscissaAxis4) {
        this.abscissaAxis4 = abscissaAxis4;
    }

    public float getOrdinateAxis4() {
        return ordinateAxis4;
    }

    public void setOrdinateAxis4(float ordinateAxis4) {
        this.ordinateAxis4 = ordinateAxis4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Float.compare(point.getAbscissaAxis1(), getAbscissaAxis1()) == 0 && Float.compare(point.getOrdinateAxis1(), getOrdinateAxis1()) == 0 && Float.compare(point.getAbscissaAxis2(), getAbscissaAxis2()) == 0 && Float.compare(point.getOrdinateAxis2(), getOrdinateAxis2()) == 0 && Float.compare(point.getAbscissaAxis3(), getAbscissaAxis3()) == 0 && Float.compare(point.getOrdinateAxis3(), getOrdinateAxis3()) == 0 && Float.compare(point.getAbscissaAxis4(), getAbscissaAxis4()) == 0 && Float.compare(point.getOrdinateAxis4(), getOrdinateAxis4()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbscissaAxis1(), getOrdinateAxis1(), getAbscissaAxis2(), getOrdinateAxis2(), getAbscissaAxis3(), getOrdinateAxis3(), getAbscissaAxis4(), getOrdinateAxis4());
    }

    @Override
    public String toString() {
        return "Point{" +
                "abscissaAxis1=" + abscissaAxis1 +
                ", ordinateAxis1=" + ordinateAxis1 +
                ", abscissaAxis2=" + abscissaAxis2 +
                ", ordinateAxis2=" + ordinateAxis2 +
                ", abscissaAxis3=" + abscissaAxis3 +
                ", ordinateAxis3=" + ordinateAxis3 +
                ", abscissaAxis4=" + abscissaAxis4 +
                ", ordinateAxis4=" + ordinateAxis4 +
                '}';
    }


}




