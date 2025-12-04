package com.microservices.notificationengine.observers;

interface IObservable {
    public void addObserver(IObserver o);

    public void removeObserver(IObserver o);

    public void notifyObservers();
}
