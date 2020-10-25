package com.wcq.controller;

import com.wcq.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    //动态代理对象
    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/service")
    public String service(){
        //远程调用
        String service = providerClient.service();

        return "consumer invoke" + "|" + service;
    }
}
