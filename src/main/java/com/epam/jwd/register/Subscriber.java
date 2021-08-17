package com.epam.jwd.register;


import java.util.ArrayList;

public interface Subscriber {

    void update(ArrayList<Float> taperSurfaceArea, ArrayList<Float> taperVolume, ArrayList<Float> taperVolumeRatio);

}
