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
import java.util.List;


public class TaperChangingClass implements Published {
//    private List tapers;
    private float taperSurfaceArea;
    private float taperVolume;
    private float taperVolumeRatio;


   InputDataReader inputDataReader = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
    Point newPoint = new Point(inputDataReader.readInputDataPoint(point));

    public TaperChangingClass() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }


//    public TaperRepository() throws InvalidInputDataException, IOException, NotEnoughDataException {
//        tapers = new ArrayList();
//
//
//    }

//    @Override
//    public void addTaper(TaperRegister taperRegister) {
//        tapers.add(taperRegister);
//        LoggerProvider.getLOG().info(tapers);
//    }

//    @Override
//    public void removeTaper(TaperRegister taperRegister) {
//        int i = tapers.indexOf(taperRegister);
//        if (i > 0) {
//            tapers.remove(i);
//        }
//        LoggerProvider.getLOG().info("remove" + tapers);
//    }

//    @Override
//    public void notifySubscriber(TaperRegister taperRegister) {
//       //  for (int i = 0; i  <=tapers.size() ; i++) {
//
//           //  taperRegister = (TaperRegister) tapers;
//             taperRegister.update(taperSurfaceArea, taperVolume, taperVolumeRatio);
//        // }
//
//    }


    public static int createTaperID(int i){
       int identifier = 0;
       identifier = i +1;
       LoggerProvider.getLOG().info(identifier);

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
            //notifySubscriber(taperRegister);

        return taperRegister;
    }

}
