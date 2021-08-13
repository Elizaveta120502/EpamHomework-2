package com.epam.jwd.register;

import com.epam.jwd.logic.*;

public class TaperRegister implements Subscriber {
    private TaperSurfaceArea taperSurfaceArea;
    private TaperVolume taperVolume;
    private TaperVolumeRatio taperVolumeRatio;
    private Published published;

    public TaperRegister (Published published){
        this.published = published;
        published.addSubscriber(this);
        update(taperSurfaceArea,taperVolume,taperVolumeRatio);
    }


    @Override
    public void update(TaperSurfaceArea taperSurfaceArea, TaperVolume taperVolume, TaperVolumeRatio taperVolumeRatio) {
        this.taperSurfaceArea = taperSurfaceArea ;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;

    }



    public TaperSurfaceArea getTaperSurfaceArea() {

        return taperSurfaceArea;
    }

    public void setTaperSurfaceArea(TaperSurfaceArea taperSurfaceArea) {

        this.taperSurfaceArea = taperSurfaceArea;
    }

    public TaperVolume getTaperVolume() {

        return taperVolume;
    }

    public void setTaperVolume(TaperVolume taperVolume) {

        this.taperVolume = taperVolume;
    }

    public TaperVolumeRatio getTaperVolumeRatio()
    {
        return taperVolumeRatio;
    }

    public void setTaperVolumeRatio(TaperVolumeRatio taperVolumeRatio) {

        this.taperVolumeRatio = taperVolumeRatio;
    }


}
