package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;

import java.util.ArrayList;


public class TaperVolume implements FigureCalculation {

    private float PI = (float) 3.14;
//    private static TaperVolume taperVolume;
//
//    public static TaperVolume provideTaperVolume(){
//        if (taperVolume == null){
//            new TaperVolume();
//        }
//        return taperVolume;
//    }

    public TaperVolume() {

    }

    @Override
    public float calculate(ArrayList<Taper> taperArrayList, ArrayList<Point> pointArrayList) {
        float volume = 0;

        for (int i = 0, j = 0; i < taperArrayList.size() -1  && j < pointArrayList.size() -1 ; i++, j++) {
            try {
                new TaperBaseOnPlain().defineTaperBasePlane(taperArrayList.get(i), pointArrayList.get(j));
            } catch (InvalidInputDataException e) {
                LoggerProvider.getLOG().error("Calculating Taper Volume failed.");
            }

            try {
                new TaperExistence().detectTaperExistance(taperArrayList.get(i));
            } catch (InvalidInputDataException e) {
                LoggerProvider.getLOG().error("Value CAN NOT be negative");
            }


            volume = (float) (PI * Math.pow(taperArrayList.get(i).getTaperBaseRadius(), 2) * taperArrayList.get(i).getTaperHeight());
            LoggerProvider.getLOG().info("Volume calculated correctly:  " + volume  +"\n");
        }
        return volume;
    }

}
