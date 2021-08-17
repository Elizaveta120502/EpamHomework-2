package com.epam.jwd.register;

import java.util.ArrayList;

public class TaperRegister implements Subscriber {
    private ArrayList<Float> taperSurfaceArea;
    private ArrayList<Float> taperVolume;


    public ArrayList<Float> getTaperSurfaceArea() {
        return taperSurfaceArea;
    }

    public ArrayList<Float> getTaperVolume() {
        return taperVolume;
    }

    public ArrayList<Float> getTaperVolumeRatio() {
        return taperVolumeRatio;
    }

    private ArrayList<Float> taperVolumeRatio;


    public TaperRegister(ArrayList<Float> taperSurfaceArea, ArrayList<Float> taperVolume, ArrayList<Float> taperVolumeRatio) {

        this.taperSurfaceArea = taperSurfaceArea;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;


    }

    @Override
    public void update(ArrayList<Float> taperSurfaceArea, ArrayList<Float> taperVolume, ArrayList<Float> taperVolumeRatio) {
        this.taperSurfaceArea = taperSurfaceArea;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;

    }


}
