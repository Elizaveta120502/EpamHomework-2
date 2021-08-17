package com.epam.jwd.validation;

import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;


public class TaperExistence {
    public void detectTaperExistance(Taper newTaper) throws InvalidInputDataException {

        if (newTaper.getTaperBaseRadius() <= 0 || newTaper.getTaperTrancatedRadius() <= 0 || newTaper.getTaperHeight() <= 0) {

            throw new InvalidInputDataException();
        }


    }
}
