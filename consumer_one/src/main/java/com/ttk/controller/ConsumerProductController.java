package com.ttk.controller;

import com.ttk.config.ConfigBean;
import com.ttk.entities.CommonResult;
import com.ttk.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerProductController {

//    private static String URL = "http://localhost:8001";
    private static String URL = "http://PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/product/findById/{pid}")
    public CommonResult findById(@PathVariable("pid") Long pid) {
        return restTemplate.getForObject(URL + "/product/findById/" + pid, CommonResult.class);
    }

}
