package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.register.TaperRegister;

import java.io.IOException;
import java.util.ArrayList;

public class TaperRepository implements Repository{
    ArrayList<TaperRegister> tapers;


    public TaperRepository()
    {
        tapers = new ArrayList<>();
    }




    @Override
    public int addTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                        ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList)
            throws InvalidInputDataException, IOException, NotEnoughDataException {
        for (int i = 0, j = 0; i < newTaperArrayList.size() - 1 && j < newPointArrayList.size() - 1; i++, j++) {
            tapers.add(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList));
            LoggerProvider.getLOG().info(tapers);
        }
        return tapers.indexOf(taperChangingClass.changeTaperParams(factory,newTaperArrayList,newPointArrayList));


    }



    @Override
    public int removeAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                           ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException {
        int i = tapers.indexOf(taperChangingClass.changeTaperParams(factory,newTaperArrayList,newPointArrayList));
        if (i > 0) {
            tapers.remove(i);
        }
        LoggerProvider.getLOG().info("remove" + tapers);
        return i;
    }

//    @Override
//    public TaperRegister changeTaper() {
//        return null;
//    }

    @Override
    public TaperRegister certainRangeTaperParameter() {
        return null;
    }

    @Override
    public TaperRegister findByID() {
        return null;
    }

    @Override
    public TaperRegister findByName() {
        return null;
    }

    @Override
    public TaperRegister defineIntersectsTheOrigin() {
        return null;
    }
}
