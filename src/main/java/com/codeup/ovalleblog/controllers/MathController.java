package com.codeup.ovalleblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 + num2;
        return num1 + " plus " + num2 + " is " + total;
    }

    @GetMapping("subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtraction(@PathVariable int num1, @PathVariable int num2) {
        int total = num2 - num1;
        return num2 + " minus " + num1 + " is " + total;
    }

    @GetMapping("multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplication(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 * num2;
        return num1 + " times " + num2 + " is " + total;
    }

    @GetMapping("divide/{num1}/by/{num2}")
    @ResponseBody
    public String division(@PathVariable int num1, @PathVariable int num2) {
        int total = num1 / num2;
        return num1 + " divided by " + num2 + " is " + total;
    }
}
