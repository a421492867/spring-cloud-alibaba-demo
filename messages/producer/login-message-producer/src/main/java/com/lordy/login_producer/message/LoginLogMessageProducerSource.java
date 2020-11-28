package com.lordy.login_producer.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface LoginLogMessageProducerSource {

    @Output("login-log-topic")
    MessageChannel loginLog();
}
