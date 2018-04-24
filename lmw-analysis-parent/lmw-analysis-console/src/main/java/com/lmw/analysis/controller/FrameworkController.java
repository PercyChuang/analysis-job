package com.lmw.analysis.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freamwork")
public class FrameworkController {


    @RequestMapping("/test")
    public String test() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

        return "test";
    }


    public static void main(String[] args) {

        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }


}
