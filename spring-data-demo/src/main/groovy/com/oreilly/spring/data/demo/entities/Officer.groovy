package com.oreilly.spring.data.demo.entities

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Officer {
    Integer id
    Rank rank
    String first
    String last

    Officer(Rank rank, String first, String last) {
        this.rank = rank
        this.first = first
        this.last = last
    }
}
