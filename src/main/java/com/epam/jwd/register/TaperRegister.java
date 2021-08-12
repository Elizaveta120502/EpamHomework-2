package com.epam.jwd.register;

import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.logic.TaperVolumeRatio;

public class TaperRegister implements Subscriber {
    private TaperSurfaceArea taperSurfaceArea;
    private TaperVolume taperVolume;
    private TaperVolumeRatio taperVolumeRatio;

    public TaperRegister(TaperSurfaceArea TAPER_SURFACE_AREA,
                         TaperVolume TAPER_VOLUME,TaperVolumeRatio TAPER_VOLUME_RATIO) {
        this.taperSurfaceArea = TAPER_SURFACE_AREA;
        this.taperVolume = TAPER_VOLUME;
        this.taperVolumeRatio = TAPER_VOLUME_RATIO;

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

    public TaperVolumeRatio getTaperVolumeRatio() {
        return taperVolumeRatio;
    }

    public void setTaperVolumeRatio(TaperVolumeRatio taperVolumeRatio) {
        this.taperVolumeRatio = taperVolumeRatio;
    }

    @Override
    public TaperRegister update(TaperSurfaceArea taperSurfaceArea, TaperVolume taperVolume, TaperVolumeRatio taperVolumeRatio) {
        return new TaperRegister(TaperSurfaceArea.provideTaperSurfaceArea(),
                TaperVolume.provideTaperVolume(),TaperVolumeRatio.providerTaperVolumeRatio());
    }
}
