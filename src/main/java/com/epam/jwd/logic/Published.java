package com.epam.jwd.logic;

import com.epam.jwd.register.TaperRegister;


public interface Published {
    void subscribe(TaperRegister taperRegister);

    void unsubscribe(TaperRegister taperRegister);

    void notifySubscriber(TaperRegister taperRegister);


}
