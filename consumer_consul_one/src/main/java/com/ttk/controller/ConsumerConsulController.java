package com.ttk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class ConsumerConsulController {

    @Autowired
    private RestTemplate restTemplate;

    //    private static String  url = "http://localhost:8500;
    private static String  url = "http://provider-consul";

    @RequestMapping(value = "consumer/zk")
    public String zk() {
        return restTemplate.getForObject(url + "/zk", String.class);
    }

}
