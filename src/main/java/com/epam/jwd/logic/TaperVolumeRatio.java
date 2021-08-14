package com.epam.jwd.logic;


import java.lang.Math;
import java.util.ArrayList;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;


public class TaperVolumeRatio implements FigureCalculation{
    private static final int RATIO_CONST = 1;

    public TaperVolumeRatio(){

    }
@Override
    public float calculate(ArrayList<Taper> taperArrayList, ArrayList<Point>  pointArrayList){
    float ratio = 0;

    for (int i = 0 , j =0; i < taperArrayList.size() -1 && j < pointArrayList.size()-1; i++,j++) {
        try{
            new TaperBaseOnPlain().defineTaperBasePlane(taperArrayList.get(i),pointArrayList.get(j));
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Calculating Taper Volume Ratio failed.");
        }

        try {
            new TaperExistence().detectTaperExistance(taperArrayList.get(i));
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Value CAN NOT be negative");
        }


         ratio = (float) (RATIO_CONST - Math.pow((taperArrayList.get(i).getTaperTrancatedRadius()/taperArrayList.get(i).getTaperBaseRadius()),3));
        LoggerProvider.getLOG().info("Volume ratio calculated correctly: "   + ratio +"\n" + TaperChangingClass.createTaperID(i));
    }
        return ratio;
    }

}
