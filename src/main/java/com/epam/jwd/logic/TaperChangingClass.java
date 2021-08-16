package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.register.Subscriber;
import com.epam.jwd.register.TaperRegister;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaperChangingClass implements Published {

   InputDataReader inputDataReader = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
    Point newPoint = new Point(inputDataReader.readInputDataPoint(point));
    ArrayList<TaperRegister> listeners = new ArrayList<>();

    public TaperChangingClass() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }


    public static int createTaperID(ArrayList<Taper> newTaperArrayList){
       int identifier = 0;
       for (int i =0 ; i < newTaperArrayList.size(); i++) {
           identifier = i;
           LoggerProvider.getLOG().info(identifier);
       }

        return identifier;
    }

    public TaperRegister changeTaperParams(TaperCalculationFactory factory,ArrayList<Taper> newTaperArrayList,ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException {

           TaperRegister taperRegister = null;

            factory.getFigureCalculation(CalculationTypes.TAPER_SURFACE_AREA).calculate(newTaperArrayList, newPointArrayList);
            factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME).calculate(newTaperArrayList, newPointArrayList);
            factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME_RATIO).calculate(newTaperArrayList, newPointArrayList);


         taperRegister = new TaperRegister(factory.getFigureCalculation(CalculationTypes.TAPER_SURFACE_AREA).calculate(newTaperArrayList, newPointArrayList),
                factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME).calculate(newTaperArrayList, newPointArrayList),
                factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME_RATIO).calculate(newTaperArrayList, newPointArrayList));
         notifySubscriber(taperRegister);
          return   taperRegister;

    }

    @Override
    public void subscribe(TaperRegister taperRegister) {

        listeners.add(taperRegister);

    }

    @Override
    public void unsubscribe(TaperRegister taperRegister) {
        listeners.remove(taperRegister);

    }

    @Override
    public void notifySubscriber(TaperRegister taperRegister) {
        taperRegister.update(taperRegister.getTaperSurfaceArea(), taperRegister.getTaperVolume(), taperRegister.getTaperVolumeRatio());

    }
}
