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

public class TaperRepository implements Repository, Specification {
    ArrayList<TaperRegister> tapers;
    private static int MIN_TAPER_BASE_RADIUS_RANGE = 2;
    private static int MAX_TAPER_BASE_RADIUS_RANGE = 4;

    private static int FINDABLE_ID = 1;

    private static int INDEX_ABSCISSA_AXIS_1 = 0;
    private static int INDEX_ORDINATE_AXIS_1 = 1;

    private static int NUMBER_OF_CHANCHING_STRING = 5;

    private static int NEW_TAPER_BASE_RADIUS = 30;
    private static int NEW_TAPER_TRANCATED_RADIUS = 10;
    private static int NEW_HEIGHT = 13;

    private static int NEW_ORDINATE_AXIS_1 = 30;
    private static int NEW_ABSCISSA_AXIS_2 = 30;
    private static int NEW_ORDINATE_AXIS_3 = -30;
    private static int NEW_ABSCISSA_AXIS_4 = -30;


    public TaperRepository() {
        tapers = new ArrayList<>();
    }


    @Override
    public int addAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                           ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList)
            throws InvalidInputDataException, IOException, NotEnoughDataException {

        tapers.add(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList));
        LoggerProvider.getLOG().info(tapers.indexOf(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList)));

        return tapers.indexOf(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList));


    }


    @Override
    public int removeAllTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                              ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException {
        tapers.remove(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList));
        LoggerProvider.getLOG().info(tapers);
        return tapers.indexOf(taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList));
    }

    @Override
    public void certainRangeTaperParameter(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                                           ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) {

        for (int i = 0; i < newPointArrayList.size(); i++) {
            if (newTaperArrayList.get(i).getTaperBaseRadius() >= MIN_TAPER_BASE_RADIUS_RANGE && newTaperArrayList.get(i).getTaperBaseRadius() <= MAX_TAPER_BASE_RADIUS_RANGE) {
                LoggerProvider.getLOG().info(newTaperArrayList.get(i));
            }
        }
    }

    @Override
    public void findCoordinatesByID(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                                    ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) {


        LoggerProvider.getLOG().info(newTaperArrayList.get(FINDABLE_ID));
        LoggerProvider.getLOG().info(newPointArrayList.get(FINDABLE_ID));


    }

    @Override
    public void defineIntersectsTheOrigin(ArrayList<Point> newPointArrayList) {

        if (newPointArrayList.get(0) == newPointArrayList.get(3)
                && newPointArrayList.get(0) == newPointArrayList.get(4)
                && newPointArrayList.get(0) == newPointArrayList.get(6)) {
            LoggerProvider.getLOG().info("the base of the cone lies at the origin");

        }

    }


    @Override
    public TaperRegister changeTaper(TaperChangingClass taperChangingClass, TaperCalculationFactory factory,
                                     ArrayList<Taper> newTaperArrayList, ArrayList<Point> newPointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException {

        newTaperArrayList.get(NUMBER_OF_CHANCHING_STRING).setTaperBaseRadius(NEW_TAPER_BASE_RADIUS);
        newTaperArrayList.get(NUMBER_OF_CHANCHING_STRING).setTaperHeight(NEW_HEIGHT);
        newTaperArrayList.get(NUMBER_OF_CHANCHING_STRING).setTaperTrancatedRadius(NEW_TAPER_TRANCATED_RADIUS);
        newPointArrayList.get(NUMBER_OF_CHANCHING_STRING).setOrdinateAxis1(NEW_ORDINATE_AXIS_1);
        newPointArrayList.get(NUMBER_OF_CHANCHING_STRING).setAbscissaAxis2(NEW_ABSCISSA_AXIS_2);
        newPointArrayList.get(NUMBER_OF_CHANCHING_STRING).setOrdinateAxis3(NEW_ORDINATE_AXIS_3);
        newPointArrayList.get(NUMBER_OF_CHANCHING_STRING).setAbscissaAxis4(NEW_ABSCISSA_AXIS_4);
        TaperRegister taperRegister;
        taperRegister = taperChangingClass.changeTaperParams(factory, newTaperArrayList, newPointArrayList);
        return taperRegister;
    }

    @Override
    public void findAbscissaAxis1MultiplyFive(ArrayList<Point> pointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException {
        if (pointArrayList.get(INDEX_ABSCISSA_AXIS_1).getAbscissaAxis1() % 5 == 0) {
            for (int i = 0; i < pointArrayList.size(); i++) {
                LoggerProvider.getLOG().info(tapers.get(i));
            }
        }


    }

    @Override
    public void findAbscissaAxisLessThenFive(ArrayList<Point> pointArrayList) {
        if (pointArrayList.get(INDEX_ABSCISSA_AXIS_1).getAbscissaAxis1() < 5) {
            for (int i = 0; i < pointArrayList.size(); i++) {
                LoggerProvider.getLOG().info(tapers.get(i));
            }
        }

    }

    @Override
    public void findOrdinateAxisEqualToZero(ArrayList<Point> pointArrayList) {
        if (pointArrayList.get(INDEX_ORDINATE_AXIS_1).getOrdinateAxis1() == 0) {
            for (int i = 0; i < pointArrayList.size(); i++) {
                LoggerProvider.getLOG().info(tapers.get(i));
            }
        }

    }
}
