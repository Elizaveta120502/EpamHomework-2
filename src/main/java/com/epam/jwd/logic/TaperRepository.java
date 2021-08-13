package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.register.Subscriber;
import jdk.internal.loader.AbstractClassLoaderValue;

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

    public TaperRepository() throws InvalidInputDataException, IOException, NotEnoughDataException {
        tapers = new ArrayList();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        tapers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        int i = tapers.indexOf(subscriber);
        if (i > 0) {
            tapers.remove(i);
        }
    }

    @Override
    public void notifySubscriber() {
        for (int i = 0; i < tapers.size(); i++) {
            Subscriber subscriber = (Subscriber)tapers.get(i);
            subscriber.update(taperSurfaceArea, taperVolume, taperVolumeRatio);
        }
    }

    public void changeTaperParams(TaperSurfaceArea taperSurfaceArea, TaperVolume taperVolume,
                                  TaperVolumeRatio taperVolumeRatio) {
        taperSurfaceArea.calculate(taper, point);
        taperVolume.calculate(taper, point);
        taperVolumeRatio.calculate(taper, point);
    }

}
