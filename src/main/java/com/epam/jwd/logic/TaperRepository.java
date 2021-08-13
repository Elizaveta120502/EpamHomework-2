package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.register.Subscriber;
import com.epam.jwd.register.TaperRegister;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TaperRepository implements Published {
    private List tapers;
    private TaperSurfaceArea taperSurfaceArea;
    private TaperVolume taperVolume;
    private TaperVolumeRatio taperVolumeRatio;
    InputDataReader inputFactory = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputFactory.readInputDataTaper(taper));
    Point newPoint = new Point(inputFactory.readInputDataPoint(point));

    public TaperRepository(TaperRegister taperRegister) throws InvalidInputDataException, IOException, NotEnoughDataException {
        tapers = new ArrayList();
    }

    @Override
    public void addSubscriber(TaperRegister taperRegister) {
        tapers.add(taperRegister);
    }

    @Override
    public void removeSubscriber(TaperRegister taperRegister) {
        int i = tapers.indexOf(taperRegister);
        if (i > 0) {
            tapers.remove(i);
        }
    }

    @Override
    public void notifySubscriber() {
        for (int i = 0; i < tapers.size(); i++) {
            TaperRegister taperRegister = (TaperRegister) tapers.get(i);
            taperRegister.update(taperSurfaceArea, taperVolume, taperVolumeRatio);
        }

    }

    public void changeTaperParams(FigureCalculation taperSurfaceArea, FigureCalculation taperVolume,
                                  FigureCalculation taperVolumeRatio) {
        taperSurfaceArea.calculate(taper, point);
        taperVolume.calculate(taper, point);
        taperVolumeRatio.calculate(taper, point);
        notifySubscriber();
    }

}
