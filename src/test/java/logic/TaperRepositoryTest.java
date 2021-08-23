package logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logic.*;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.register.TaperRegister;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TaperRepositoryTest {

    private TaperRepository taperRepository = new TaperRepository();
    TaperCalculationFactory factory = new TaperCalculationFactory();
    InputDataReader inputDataReader = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
    Point newPoint = new Point(inputDataReader.readInputDataPoint(point));
    TaperChangingClass taperChangingClass = new TaperChangingClass();



    public TaperRepositoryTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }


    @Test

    public void addAllTaperTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertNotNull(taperChangingClass.changeTaperParams(factory, inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)));
        Assert.assertNotNull(taperRepository.addAllTaper(taperChangingClass, factory,
                inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)));


    }

    @Test
    public void removeAllTaperTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertEquals(taperRepository.addAllTaper(taperChangingClass, factory,
                inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)), -1);
    }

    @Test
    public void certainRangeTaperParameterTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertEquals(taperRepository.certainRangeTaperParameter(taperChangingClass, factory, inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)).size(), 2);

    }

    @Test
    public void findCoordinatesByIDTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertNotNull(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)));
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getAbscissaAxis1(), 0);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getOrdinateAxis1(), 4);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getAbscissaAxis2(), 4);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getOrdinateAxis2(), 0);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getAbscissaAxis3(), 0);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getOrdinateAxis3(), -4);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getAbscissaAxis4(), -4);
        Assert.assertEquals(taperRepository.findCoordinatesByID(inputDataReader.readInputDataPoint(point)).getOrdinateAxis4(), 0);
    }



}
