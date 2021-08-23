package com.epam.jwd.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Taper {

    private float taperBaseRadius;
    private float taperHeight;
    private float taperTrancatedRadius;


    public Taper(float taperBaseRadius, float taperHeight, float taperTrancatedRadius) {
        this.taperBaseRadius = taperBaseRadius;
        this.taperHeight = taperHeight;
        this.taperTrancatedRadius = taperTrancatedRadius;
    }

    public Taper() {

    }

    public Taper(ArrayList<Taper> taperArrayList) {
    }


    public float getTaperBaseRadius() {
        return taperBaseRadius;
    }

    public void setTaperBaseRadius(float taperBaseRadius) {
        this.taperBaseRadius = taperBaseRadius;
    }

    public float getTaperHeight() {
        return taperHeight;
    }

    public void setTaperHeight(float taperHeight) {
        this.taperHeight = taperHeight;
    }

    public float getTaperTrancatedRadius() {
        return taperTrancatedRadius;
    }

    public void setTaperTrancatedRadius(float taperTrancatedRadius) {
        this.taperTrancatedRadius = taperTrancatedRadius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taper)) return false;
        Taper taper = (Taper) o;
        return Float.compare(taper.getTaperBaseRadius(), getTaperBaseRadius()) == 0 && Float.compare(taper.getTaperHeight(), getTaperHeight()) == 0 && Float.compare(taper.getTaperTrancatedRadius(), getTaperTrancatedRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaperBaseRadius(), getTaperHeight(), getTaperTrancatedRadius());
    }

    @Override
    public String toString() {
        return "Taper{" +
                "taperBaseRadius=" + taperBaseRadius +
                ", taperHeight=" + taperHeight +
                ", taperTrancatedRadius=" + taperTrancatedRadius +
                '}';
    }

}
