package com.example.administrator.customproject.net;

public abstract class SubscriberOnNextListener<T> {
    protected abstract void onNext(T t);

    public void onError(Throwable e) {
    }
}