package logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.InputDataReaderFactory;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.logic.TaperSurfaceArea;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.reader.InputDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static com.epam.jwd.logic.CalculationTypes.TAPER_VOLUME;

public class TaperVolumeTest {
    public TaperVolumeTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }

    TaperVolume taperVolumeTest = new TaperVolume();
    TaperCalculationFactory factory = new TaperCalculationFactory();
    InputDataReader inputDataReader = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
    Point newPoint = new Point(inputDataReader.readInputDataPoint(point));


    @Test
    public void calculateTaperVolume() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertEquals(factory.getFigureCalculation(TAPER_VOLUME).calculate(inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)),
                taperVolumeTest.calculate(inputDataReader.readInputDataTaper(taper),
                        inputDataReader.readInputDataPoint(point)));

    }

}
