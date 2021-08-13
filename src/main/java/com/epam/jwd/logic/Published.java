package com.epam.jwd.logic;

import com.epam.jwd.register.Subscriber;
import com.epam.jwd.register.TaperRegister;


public interface Published {
    void addSubscriber(TaperRegister taperRegister);

    void removeSubscriber(TaperRegister taperRegister);

    void notifySubscriber();



}
