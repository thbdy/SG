package com.zhangf.unnamed.http;

import rx.Subscription;

public interface LifeSubscription{
    void bindSubscription(Subscription subscription);
}

