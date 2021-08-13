package com.epam.jwd.logic;


import java.lang.Math;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;


public class TaperVolumeRatio implements FigureCalculation{
    private static final int RATIO_CONST = 1;
//    private static TaperVolumeRatio taperVolumeRatio;
//
//    public static TaperVolumeRatio providerTaperVolumeRatio(){
//        if (taperVolumeRatio == null){
//            new TaperVolumeRatio();
//        }
//        return taperVolumeRatio;
//    }
    public TaperVolumeRatio(){

    }
@Override
    public float calculate(Taper newTaper, Point newPoint){
        try{
            new TaperBaseOnPlain().defineTaperBasePlane(newTaper,newPoint);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Calculating Taper Volume Ratio failed.");
        }
        try {
            new TaperExistence().detectTaperExistance(newTaper);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Value CAN NOT be negative");
        }
        float ratio = (float) (RATIO_CONST - Math.pow((newTaper.getTaperTrancatedRadius()/newTaper.getTaperBaseRadius()),3));
        LoggerProvider.getLOG().info("Volume ratio calculated correctly: "   + ratio);
        return ratio;
    }
}
