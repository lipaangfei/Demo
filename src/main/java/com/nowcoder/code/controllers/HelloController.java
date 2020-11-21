package com.nowcoder.code.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.var.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/helloworld")
public class HelloController {
    @Get("")
    public String hello(){
        return "@Hello World";
    }

    /*@Get("{name}")
    public String hello(Model model, @Param("name") String name){
        model.add("name", name);
        return "test/hello";
    }*/

    @Get("{name}")
    public String hello(Invocation inv, @Param("name") String name){
        inv.addModel("name", name);
        return "test/hello";
    }
}
