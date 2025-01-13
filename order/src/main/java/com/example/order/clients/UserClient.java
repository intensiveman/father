package com.example.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user")
public interface UserClient {

    @GetMapping("/fund/get")
    String getFund(@RequestParam("id") Integer id);
}
