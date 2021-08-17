package com.epam.jwd.validation;


import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.logger.LoggerProvider;


public class TaperBaseOnPlain {


    public void defineTaperBasePlane(Taper newTaper, Point newPoint) throws InvalidInputDataException {

        if (newPoint.getAbscissaAxis1() == newPoint.getAbscissaAxis3()
                && newPoint.getOrdinateAxis4() == newPoint.getOrdinateAxis2()
                && newTaper.getTaperBaseRadius() != newTaper.getTaperTrancatedRadius()
                && 2 * newTaper.getTaperBaseRadius() == newPoint.getOrdinateAxis1() - newPoint.getOrdinateAxis3()
                && 2 * newTaper.getTaperBaseRadius() == newPoint.getAbscissaAxis2() - newPoint.getAbscissaAxis4()
                && newTaper.getTaperBaseRadius() > 0 && newTaper.getTaperTrancatedRadius() > 0) {
            LoggerProvider.getLOG().info("the base of the figure belongs to the coordinate plane");
        } else {
            throw new InvalidInputDataException();
        }

    }
}
