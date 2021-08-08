package com.epam.jwd.reader;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable {
    Taper readInputDataTaper (Taper taper) throws FileNotFoundException, IOException, InvalidInputDataException, NotEnoughDataException;
    Point readInputDataPoint (Point point) throws FileNotFoundException, IOException, InvalidInputDataException, NotEnoughDataException;
}
