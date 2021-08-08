package com.epam.jwd.factory;

import com.epam.jwd.entity.Point;
import com.epam.jwd.entity.Taper;
import com.epam.jwd.exception.InvalidInputDataException;
import com.epam.jwd.reader.InputDataReader;
import com.epam.jwd.reader.InputDataReaderObject;
import com.epam.jwd.reader.Readable;

public class InputDataReaderFactory {
    public Readable readInputData(InputDataReaderObject type) throws InvalidInputDataException {
        Readable toReturn ;
        switch (type) {
            case INPUT_DATA_READER_OBJECT:
                toReturn =  new InputDataReader();
                break;
            default:
                throw new InvalidInputDataException();
        }
        return toReturn;
    }


}
