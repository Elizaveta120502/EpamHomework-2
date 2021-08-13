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


public class TaperRepository implements Published {
    private List tapers;
    private float taperSurfaceArea;
    private float taperVolume;
    private float taperVolumeRatio;

    public TaperRepository(List tapers, float taperSurfaceArea, float taperVolume, float taperVolumeRatio) throws InvalidInputDataException, IOException, NotEnoughDataException {
        this.tapers = tapers;
        this.taperSurfaceArea = taperSurfaceArea;
        this.taperVolume = taperVolume;
        this.taperVolumeRatio = taperVolumeRatio;

    }

    public float getTaperSurfaceArea() {
        return taperSurfaceArea;
    }

    InputDataReader inputFactory = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputFactory.readInputDataTaper(taper));
    Point newPoint = new Point(inputFactory.readInputDataPoint(point));

    public TaperRepository() throws InvalidInputDataException, IOException, NotEnoughDataException {
        tapers = new ArrayList();
    }

    @Override
    public void addSubscriber(TaperRegister taperRegister) {
        tapers.add(taperRegister);
        LoggerProvider.getLOG().info(tapers);
    }

    @Override
    public void removeSubscriber(TaperRegister taperRegister) {
        int i = tapers.indexOf(taperRegister);
        if (i > 0) {
            tapers.remove(i);
        }
        LoggerProvider.getLOG().info("remove" + tapers);
    }

    @Override
    public void notifySubscriber(TaperRegister taperRegister) {
       // for (int i = 0; i < tapers.size(); i++) {
        //    TaperRegister taperRegister = (TaperRegister) tapers.get(i);
           //taperRegister.update(taperSurfaceArea, taperVolume, taperVolumeRatio);
        //}

    }

    public  TaperRegister changeTaperParams(TaperCalculationFactory factory) throws InvalidInputDataException {
        LoggerProvider.getLOG().info("taperSurfaceArea obj");
        factory.getFigureCalculation(CalculationTypes.TAPER_SURFACE_AREA).calculate(taper, point);
        LoggerProvider.getLOG().info("taperVolume obj");
        factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME).calculate(taper, point);
        LoggerProvider.getLOG().info("taperVolumeRatio obj");
        factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME_RATIO).calculate(taper, point);
        TaperRegister taperRegister = new TaperRegister(factory.getFigureCalculation(CalculationTypes.TAPER_SURFACE_AREA).calculate(taper, point),
                factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME).calculate(taper, point),
                factory.getFigureCalculation(CalculationTypes.TAPER_VOLUME_RATIO).calculate(taper, point));
       // notifySubscriber(taperRegister);
         return taperRegister ;
    }

}
