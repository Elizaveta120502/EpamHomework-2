package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.InputDataReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidInputDataException, IOException, NotEnoughDataException {


        TaperCalculationFactory factory = new TaperCalculationFactory();
        InputDataReader inputDataReader = new InputDataReader();


        Taper taper = new Taper();
        Point point = new Point();

        Taper newTaper;
        newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
        Point newPoint = new Point(inputDataReader.readInputDataPoint(point));


        TaperChangingClass taperChangingClass = new TaperChangingClass();
        TaperCalculationFactory taperCalculationFactory = new TaperCalculationFactory();
        taperChangingClass.changeTaperParams(factory, inputDataReader.readInputDataTaper(taper), inputDataReader.readInputDataPoint(point));
        TaperRepository taperRepository = new TaperRepository();

//        taperRepository.addTaper(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper),
//
//                inputDataReader.readInputDataPoint(point));
//        LoggerProvider.getLOG().info(taperRepository);

        taperRepository.addAllTaper(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point));
        LoggerProvider.getLOG().info("taper repo :" + taperRepository);

        //  taperRepository.defineIntersectsTheOrigin(inputDataReader.readInputDataPoint(point));
//        taperRepository.certainRangeTaperParameter(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper),
//                inputDataReader.readInputDataPoint(point));
//        taperRepository.findCoordinatesByID(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper),
//                inputDataReader.readInputDataPoint(point));

        taperRepository.changeTaper(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper), inputDataReader.readInputDataPoint(point));


    }


}
