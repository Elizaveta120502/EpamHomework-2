package com.epam.jwd.register;


import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.logic.TaperVolumeRatio;

import java.util.ArrayList;

public interface Subscriber {

    void update(ArrayList<Float> taperSurfaceArea, ArrayList<Float> taperVolume,ArrayList<Float> taperVolumeRatio);

}
