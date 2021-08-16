package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.register.TaperRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Repository {
    int addAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                    ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;

    int removeAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                       ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;


    void certainRangeTaperParameter(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                                    ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList);

    void findCoordinatesByID(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                             ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList);


    void defineIntersectsTheOrigin(ArrayList<Point> newPointArrayList);

    TaperRegister changeTaper (TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                               ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;
}
