package com.epam.jwd.factory;

import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.logic.*;


import java.io.IOException;

public class TaperCalculationFactory {

    public TaperCalculationFactory() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }

    public FigureCalculation getFigureCalculation(CalculationTypes type) throws InvalidInputDataException{
        FigureCalculation toReturn;
        switch (type) {
            case TAPER_SURFACE_AREA:
                toReturn = new TaperSurfaceArea();
                break;
            case TAPER_VOLUME:
                toReturn = new TaperVolume();
                break;
            case TAPER_VOLUME_RATIO:
                toReturn =  new TaperVolumeRatio();
                break;
            default:
                throw new InvalidInputDataException();
        }
        return toReturn;
    }


}











//    public TaperFactory() throws InvalidInputDataException, IOException, NotEnoughDataException {
//
//    }
//
//
//    private Taper taper = new Taper(getTaper().getTaperBaseRadius(), getTaper().getTaperHeight(),
//            getTaper().getTaperTrancatedRadius());
//
//
//
//  private Point point = new Point(getPoint().getAbscissaAxis1(), getPoint().getOrdinateAxis1(),
//            getPoint().getAbscissaAxis2(), getPoint().getOrdinateAxis2(),
//            getPoint().getAbscissaAxis3(), getPoint().getOrdinateAxis3(),
//            getPoint().getAbscissaAxis4(), getPoint().getOrdinateAxis4());
//
//
//    public Taper getNewTaper() {
//        return newTaper;
//    }
//
//    public Point getNewPoint() {
//        return newPoint;
//    }
//
//    private Taper newTaper = new Taper(InputDataReader.readInputDataTaper(taper));
//    private Point newPoint = new Point (InputDataReader.readInputDataPoint(point));
//
//    private TaperComponent component = new TaperComponent();
//
//    InputDataReader data = new InputDataReader(InputDataReader.readInputDataPoint(point),
//            InputDataReader.readInputDataTaper(taper)
//
//
//    public InputDataReader getData() {
//        return data;
//    }
//    public Taper getTaper() {
//        return taper;
//    }
//
//    public Point getPoint() {
//        return point;
//    }



