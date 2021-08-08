package com.epam.jwd.exception;


import com.epam.jwd.logger.LoggerProvider;

public class NotEnoughDataException extends Exception {


    public NotEnoughDataException() {

        super();
    }

    public CharSequence notEnoughDataExceptionLOG() {
        LoggerProvider.getLOG().error("NotEnoughDataException: Input data is incorrect");
        return null;
    }
}
