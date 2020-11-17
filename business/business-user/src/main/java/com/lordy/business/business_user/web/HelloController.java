package com.lordy.business.business_user.web;

import com.lordy.commons.web.api.Response;
import com.lordy.user.user_api.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("{str}")
    public Response hello(@PathVariable String str){
        return Response.dataSuccess(helloService.hello(str));
    }
}
