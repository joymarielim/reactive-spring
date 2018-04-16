package com.oreilly.spring.data.demo

import com.oreilly.spring.data.demo.entities.Officer
import com.oreilly.spring.data.demo.entities.Rank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OfficerRepository extends JpaRepository<Officer, Integer>{
    List<Officer> findByRank(@Param('rank') Rank rank)
    List<Officer> findByLast(@Param('last') String last)
}