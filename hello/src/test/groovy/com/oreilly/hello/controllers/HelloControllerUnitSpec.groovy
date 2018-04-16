package com.oreilly.hello.controllers

import org.springframework.validation.support.BindingAwareModelMap
import spock.lang.Specification

class HelloControllerUnitSpec extends Specification {

    def "SayHello"() {
        given:
        HelloController helloController = new HelloController()

        when:
        String result = helloController.sayHello("Joy", new BindingAwareModelMap())

        then:
        result == "hello"
    }
}
