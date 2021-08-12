package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;


public class TaperVolume implements FigureCalculation{

    private float PI = (float) 3.14;
    private static TaperVolume taperVolume;

    public static TaperVolume provideTaperVolume(){
        if (taperVolume == null){
            new TaperVolume();
        }
        return taperVolume;
    }

    private TaperVolume(){

    }
@Override
    public float calculate(Taper newTaper, Point newPoint ){
        try{
            new TaperBaseOnPlain().defineTaperBasePlane(newTaper,newPoint);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Calculating Taper Volume failed.");
        }
        try {
            new TaperExistence().detectTaperExistance(newTaper);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Value CAN NOT be negative");
        }
        float volume = (float) (PI*Math.pow(newTaper.getTaperBaseRadius(),2)*newTaper.getTaperHeight());
        LoggerProvider.getLOG().info("Volume calculated correctly:  " + volume);
        return volume;
    }
}
