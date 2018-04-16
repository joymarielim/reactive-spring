package com.oreilly.hello.controllers;

import org.junit.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.Assert.assertEquals;

public class HelloControllerUnitTest {

    @Test
    public void sayTest(){
        HelloController helloController = new HelloController();
        String hello = helloController.sayHello("Joy", new BindingAwareModelMap());
        assertEquals("hello", hello);
    }

}