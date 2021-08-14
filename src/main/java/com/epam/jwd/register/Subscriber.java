package com.epam.jwd.register;


import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.logic.TaperVolumeRatio;

public interface Subscriber {

     void update(float taperSurfaceArea,float taperVolume,float taperVolumeRatio,int id);

}
