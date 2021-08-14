package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;

import java.util.ArrayList;

public interface FigureCalculation {
    float calculate(ArrayList <Taper> taperArrayList,ArrayList <Point> pointArrayList);
}
