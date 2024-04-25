package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
//    @GetMapping("hello") //argument represents the URL pattern...
//    @ResponseBody //plain text response, no template
//    public String hello()
//    {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye") //argument represents the URL pattern...
    @ResponseBody //plain text response, no template
    public String goodbye()
    {
        return "Goodbye, Spring!";
    }

    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name)
    {
        return "Hello," + name + "!";
    }
}
