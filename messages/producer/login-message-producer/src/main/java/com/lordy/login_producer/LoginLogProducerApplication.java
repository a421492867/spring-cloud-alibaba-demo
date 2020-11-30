package com.lordy.login_producer;

import com.lordy.login_producer.message.LoginLogMessageProducerSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableBinding(LoginLogMessageProducerSource.class)
public class LoginLogProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginLogProducerApplication.class, args);
    }
}
