package com.oreilly.hello.entities

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Greeting {
    String message = 'Hello, World'
}
