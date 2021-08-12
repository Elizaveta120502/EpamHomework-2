package com.epam.jwd.logic;

import com.epam.jwd.register.Subscriber;


public interface Published {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscriber(Subscriber subscriber);
//        subscriber.update(TaperSurfaceArea.provideTaperSurfaceArea(),TaperVolume.provideTaperVolume(),
//                TaperVolumeRatio.providerTaperVolumeRatio());


}
