package com.main.sbp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.sbp.dto.OrderDTO;

@RestController
@RequestMapping("/api/user-service")
public class UserController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    public static final String USER_SERVICE = "userService";

    private static final String BASEURL = "http://localhost:8081/orders";
    
    @GetMapping("/displayOrders")
    public List<OrderDTO> displayOrders(@RequestParam("category") String category) {
        String url = category == null ? BASEURL : BASEURL + "/" + category;
        return restTemplate.getForObject(url, ArrayList.class);
    }

}
