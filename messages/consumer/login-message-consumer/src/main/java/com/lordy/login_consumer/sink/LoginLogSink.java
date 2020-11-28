package com.lordy.login_consumer.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface LoginLogSink {

    @Input("login-log-topic")
    SubscribableChannel loginLog();
}
