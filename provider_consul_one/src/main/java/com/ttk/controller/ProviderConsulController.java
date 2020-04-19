package com.ttk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderConsulController {

    @RequestMapping(value = "/zk")
    public String zk() {
        return "zk" + UUID.randomUUID().toString();
    }

}
