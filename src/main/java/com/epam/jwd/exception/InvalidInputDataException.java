package com.epam.jwd.exception;

import com.epam.jwd.logger.LoggerProvider;


public class InvalidInputDataException extends Exception {

    public InvalidInputDataException() {
        super();
    }

    public CharSequence invalidInputDataExceptionLOG() {

        LoggerProvider.getLOG().error("InvalidInputDataException:Input data is incorrect");
        return null;
    }

}
