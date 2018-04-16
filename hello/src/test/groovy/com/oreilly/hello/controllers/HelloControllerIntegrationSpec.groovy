package com.oreilly.hello.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class HelloControllerIntegrationSpec extends Specification {

    @Autowired
    WebApplicationContext webApplicationContext

    private MockMvc mockMvc

    def setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    def "sayHelloWithoutName"() {
        expect:
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "World"))
    }

    def "sayHelloWithName"() {
        expect:
        mockMvc.perform(get("/hello")
                .param("name", "Joy")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", "Joy"))
    }
}
