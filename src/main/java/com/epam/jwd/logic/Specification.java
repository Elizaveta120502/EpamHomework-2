package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.exception.NotEnoughDataException;

import java.io.IOException;
import java.util.ArrayList;

public interface Specification {

    void findAbscissaAxis1MultiplyFive(ArrayList<Point> pointArrayList) throws InvalidInputDataException, IOException, NotEnoughDataException;

    void findAbscissaAxisLessThenFive(ArrayList<Point> pointArrayList);

    void findOrdinateAxisEqualToZero(ArrayList<Point> pointArrayList);
}
