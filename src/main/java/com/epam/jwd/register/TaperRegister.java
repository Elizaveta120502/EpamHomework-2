package com.epam.jwd.register;

import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.logic.*;

public class TaperRegister implements Subscriber {
    private float taperSurfaceArea;
    private float taperVolume;
    private float taperVolumeRatio;
    private Published published;

    public TaperRegister (Published published){
        this.published = published;
        published.addSubscriber(this);

    }

    public TaperRegister(float taperSurfaceArea, float taperVolume, float taperVolumeRatio) {
        this.taperSurfaceArea = taperSurfaceArea;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;
    }

    @Override
    public void update(float taperSurfaceArea,float taperVolume,float taperVolumeRatio) {
      this.taperSurfaceArea = taperSurfaceArea;
      this.taperVolume = taperVolume;
      this.taperVolumeRatio = taperVolumeRatio;
    }





}
