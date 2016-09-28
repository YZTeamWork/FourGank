package com.yibh.fourgank.yonionyy.observerPattern;

/**
 * Created by yibh on 2016/9/23 18:44 .
 */

public interface Subject {
    void registerObserver(YObserver yObserver);

    void removeObserver(YObserver yObserver);

    void notifyObserver();
}
