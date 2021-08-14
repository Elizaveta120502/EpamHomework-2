package logic;


import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.factory.InputDataReaderFactory;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.reader.InputDataReaderObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.jwd.logic.CalculationTypes.TAPER_SURFACE_AREA;

public class TaperSurfaceAreaTest {
    public TaperSurfaceAreaTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }
    TaperSurfaceArea taperSurfaceAreaTest = new TaperSurfaceArea();
    TaperCalculationFactory factory = new TaperCalculationFactory();
   // InputDataReader inputFactory = new InputDataReader();
//    Taper taper = new Taper();
//    Point point = new Point();
//    Taper newTaper = new Taper(inputFactory.readInputDataTaper(taper));
//    Point newPoint = new Point (inputFactory.readInputDataPoint(point));
//
//    @Test
//    public void calculateTaperSurfaceArea() throws InvalidInputDataException {
//        Assert.assertEquals(factory.getFigureCalculation(TAPER_SURFACE_AREA).calculate(taper,point),taperSurfaceAreaTest.calculate(taper,point));
//
//    }

}
