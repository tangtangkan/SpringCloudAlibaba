package com.ttk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class ConsumerZkController {

    @Autowired
    private RestTemplate restTemplate;

//    private static String  url = "http://localhost:8004";
    private static String  url = "http://provider-zk";

    @RequestMapping(value = "consumer/zk")
    public String zk() {
        return restTemplate.getForObject(url + "/zk", String.class);
    }

}
