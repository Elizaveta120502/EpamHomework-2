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
   int addTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                 ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;

    int removeAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                    ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;


   // TaperRegister changeTaper();

    TaperRegister certainRangeTaperParameter();

    TaperRegister findByID();

    TaperRegister findByName();

    TaperRegister defineIntersectsTheOrigin();
}
