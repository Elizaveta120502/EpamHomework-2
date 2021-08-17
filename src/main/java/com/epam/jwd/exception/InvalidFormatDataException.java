package com.epam.jwd.exception;

import com.epam.jwd.logger.LoggerProvider;


public class InvalidFormatDataException extends Exception {


    public InvalidFormatDataException() {
        super();
    }

    public CharSequence InvalidInputDataExceptionLOG() {
        LoggerProvider.getLOG().error("InvalidFormatDataException:The entered data is incorrect");
        return null;
    }
}
