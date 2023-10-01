package com.elite.project1.springboot1.controller;

import com.elite.project1.springboot1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody

@RestController //this consist both @Controller and #ResponseBody
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    //@RequestMapping("/user") //by default, if we dont define request type, it is a GET method as below. for other we need to define
    //@RequestMapping(value = "/user", method = RequestMethod.GET)

    //we have another way, instead of defining both value and request method, we can use single value in below annotation
    @GetMapping("/user")
    public User userDetails() {
        User user = new User();
        user.setId("1");
        user.setName("ashvani");
        user.setEmailId("ashvanivashist@gmail.com");
        return user;
    }

    //path variables are defined only for mandatory fields.. for optional fields we define request mapping [quary param]
    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id) {
        return "path variable is " + id;
    }

    @GetMapping("/{id}/{id1}")
    public String pathVariable1(@PathVariable String id, @PathVariable("id2") String name) {
        return "path variable is " + id + "and "+ name;
    }

    //http://localhost:8080/requestParam?name=ash
    //we can pass multiple query params as well and still it will work for ex
    //http://localhost:8080/requestParam?name=ash&name=ashvani
    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name) {
        return "Your name is "+name;
    }

    @GetMapping("/requestParam1")
    public String requestParams1(@RequestParam String name, @RequestParam String email) {
        return "Your name is "+name +" and their email Id is "+email;
    }

    //http://localhost:8080/requestParam2?name=ash&new-email=as.com
    @GetMapping("/requestParam2")
    public String requestParams2(@RequestParam String name, @RequestParam(name = "new-email") String email) {
        return "Your name is "+name +" and their email Id is "+email;
    }

    //we can make query params as optional using required = false
    //http://localhost:8080/requestParam3?name=ash
    //http://localhost:8080/requestParam3?name=ash&new-email=as.com
    @GetMapping("/requestParam3")
    public String requestParams3(@RequestParam String name, @RequestParam(name = "new-email", required = false) String email) {
        return "Your name is "+name +" and their email Id is "+email;
    }

    //we can set a value internally if it is an optional query param
    //http://localhost:8080/requestParam4?name=ash
    //http://localhost:8080/requestParam4?name=ash&address=abc
    @GetMapping("/requestParam4")
    public String requestParams4(@RequestParam String name, @RequestParam(name = "address", required = false, defaultValue = "kuch bhi nhi") String address) {
        return "Your name is "+name +" and their address is "+address;
    }


}
