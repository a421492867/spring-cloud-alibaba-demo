package com.lordy.login_consumer;

import com.lordy.login_consumer.sink.LoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableBinding(LoginLogSink.class)
public class LoginLogConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginLogConsumerApplication.class, args);
    }
}
