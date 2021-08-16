package logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;
import com.epam.jwd.factory.TaperCalculationFactory;
import com.epam.jwd.logic.TaperVolume;
import com.epam.jwd.logic.TaperVolumeRatio;
import com.epam.jwd.reader.InputDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


import static com.epam.jwd.logic.CalculationTypes.TAPER_VOLUME_RATIO;

public class TaperVolumeRatioTest {
    public TaperVolumeRatioTest() throws InvalidInputDataException, IOException, NotEnoughDataException {
    }

    TaperVolumeRatio taperVolumeRatioTest = new TaperVolumeRatio();
    TaperCalculationFactory factory = new TaperCalculationFactory();
    InputDataReader inputDataReader = new InputDataReader();
    Taper taper = new Taper();
    Point point = new Point();
    Taper newTaper = new Taper(inputDataReader.readInputDataTaper(taper));
    Point newPoint = new Point(inputDataReader.readInputDataPoint(point));

    @Test
    public void calculateTaperVolume() throws InvalidInputDataException, IOException, NotEnoughDataException {
        Assert.assertEquals(factory.getFigureCalculation(TAPER_VOLUME_RATIO).calculate(inputDataReader.readInputDataTaper(taper),
                inputDataReader.readInputDataPoint(point)), taperVolumeRatioTest.calculate(inputDataReader.readInputDataTaper(taper), inputDataReader.readInputDataPoint(point)));

    }


}
