package com.epam.jwd.register;

import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.logic.TaperVolumeRatio;

public interface Subscriber {

        TaperRegister update(TaperSurfaceArea taperSurfaceArea, TaperVolume taperVolume, TaperVolumeRatio taperVolumeRatio);

}
