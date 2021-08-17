package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.validation.TaperBaseOnPlain;
import com.epam.jwd.validation.TaperExistence;

import java.io.IOException;
import java.util.ArrayList;


public class TaperSurfaceArea implements FigureCalculation {

    private float PI = (float) 3.14;


    public TaperSurfaceArea() throws InvalidInputDataException, IOException, NotEnoughDataException {

    }

    @Override
    public ArrayList<Float> calculate(ArrayList<Taper> taperArrayList, ArrayList<Point> pointArrayList) {
        float area = 0;
        ArrayList<Float> taperSurfaceAreaList = new ArrayList<Float>();


        for (int i = 0, j = 0; i < taperArrayList.size() - 1 && j < pointArrayList.size() - 1; i++, j++) {
            try {

                new TaperBaseOnPlain().defineTaperBasePlane(taperArrayList.get(i), pointArrayList.get(j));

            } catch (InvalidInputDataException e) {
                LoggerProvider.getLOG().error("Calculating Taper Surface Area failed.");
            }
            try {
                new TaperExistence().detectTaperExistance(taperArrayList.get(i));
            } catch (InvalidInputDataException e) {
                LoggerProvider.getLOG().error("Can NOT build this figure");
            }

            area = (float) ((PI * Math.pow(taperArrayList.get(i).getTaperBaseRadius(), 2)) +
                    (PI * taperArrayList.get(i).getTaperBaseRadius() * (Math.pow(taperArrayList.get(i).getTaperBaseRadius() *
                            taperArrayList.get(i).getTaperBaseRadius() + taperArrayList.get(i).getTaperHeight() * taperArrayList.get(i).getTaperHeight(), 1 / 2))));
            taperSurfaceAreaList.add(area);
            LoggerProvider.getLOG().info("Surface area calculated correctly:  " + area + "\n");

        }
        return taperSurfaceAreaList;

    }
}


