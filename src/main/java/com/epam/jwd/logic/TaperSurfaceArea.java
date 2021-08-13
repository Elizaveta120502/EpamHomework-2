package com.epam.jwd.logic;

import com.epam.jwd.entity.Taper;
import com.epam.jwd.entity.Point;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;

import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;


public class TaperSurfaceArea implements FigureCalculation {

    private float PI = (float) 3.14;
    //private static TaperSurfaceArea taperSurfaceArea;


//    public static TaperSurfaceArea provideTaperSurfaceArea(){
//        if (taperSurfaceArea == null){
//            new TaperSurfaceArea();
//        }
//        return taperSurfaceArea;
//    }

    public TaperSurfaceArea() {

    }

@Override
    public float calculate (Taper taper , Point point) {
        try{
            new TaperBaseOnPlain().defineTaperBasePlane(taper,point);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Calculating Taper Surface Area failed.");
        }
        try {
            new TaperExistence().detectTaperExistance(taper);
        } catch (InvalidInputDataException e){
            LoggerProvider.getLOG().error("Can NOT build this figure");
        }
       float area = (float) ((PI * Math.pow(taper.getTaperBaseRadius(), 2)) +
               (PI * taper.getTaperBaseRadius() * (Math.pow(taper.getTaperBaseRadius()*
                       taper.getTaperBaseRadius()+ taper.getTaperHeight()*taper.getTaperHeight(),1/2))));
        LoggerProvider.getLOG().info("Surface area calculated correctly:  " + area);

        return area;

    }

}
