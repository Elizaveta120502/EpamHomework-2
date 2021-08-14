package com.epam.jwd.register;

import com.epam.jwd.logic.Published;

public class TaperRegister implements Subscriber {
    private float taperSurfaceArea;
    private float taperVolume;
    private float taperVolumeRatio;
  //  private Published published;
    private int id;

//    public TaperRegister (Published published){
//        this.published = published;
//        published.addTaper(this);
//
//    }

    public TaperRegister(float taperSurfaceArea, float taperVolume, float taperVolumeRatio) {
        this.taperSurfaceArea = taperSurfaceArea;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;
    }

    @Override
    public void update(float taperSurfaceArea,float taperVolume,float taperVolumeRatio , int id) {
        taperSurfaceArea = this.taperSurfaceArea  ;
        taperVolume = this.taperVolume  ;
        taperVolumeRatio = this.taperVolumeRatio  ;
        id = this.id;
    }





}
