package com.lordy.userclient.web;

import com.lordy.commons.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
public class TestController {

    @GetMapping("hello/{name}")
    public Response example(@PathVariable String name){
        return Response.dataSuccess("hello : " + name);
    }
}
