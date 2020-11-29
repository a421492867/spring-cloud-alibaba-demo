//package com.lordy.login_producer.web;
//
//import com.lordy.commons.web.api.Response;
//import com.lordy.log.log_api.entity.LoginLog;
//import com.lordy.login_producer.producer.LoginLogMessageProducer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("message")
//public class LoginLogController {
//
//    @Autowired
//    private LoginLogMessageProducer loginLogMessageProducer;
//
//    @PostMapping("login_log")
//    public Response sendLoginLog(@RequestBody LoginLog loginLog){
//        return new Response(200, "", loginLogMessageProducer.sendLoginLog(loginLog));
//    }
//}
