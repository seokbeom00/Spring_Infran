package com.example.spring_introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {
    //정적 컨텐츠를 내려주는 방식
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }
    //MVC 모델을 이용하여 sprig view-resolver를 통해 템플릿으로 연결해주는 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    //API방식으로 body 내용을 담아서 그대로 넘겨주는 방식
    @GetMapping("hello-spring")
    @ResponseBody
    public String hellospring(@RequestParam("name") String name){
        return "hello " + name;
    }
    //API 방식으로 Hello 객체를 json 형식으로 넘겨주는 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName("leo");
        return hello;
    }

    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
