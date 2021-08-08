package com.epam.jwd.logic;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;

public interface FigureCalculation {
    float calculate(Taper taper , Point point);
}
