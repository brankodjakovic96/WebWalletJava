package com.webwallet.applications.webclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Map<String, Object> model){
        model.put("message", "Hello Bryan");
        return "home";
    }

    @GetMapping("/error")
    public String error(@RequestParam(value = "message", defaultValue = "Error")String error,
                        Map<String, Object> model){
        model.put("message", error);
        return "error";
    }
}
