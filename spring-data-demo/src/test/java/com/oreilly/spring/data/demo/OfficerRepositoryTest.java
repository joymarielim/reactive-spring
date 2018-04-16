package com.oreilly.spring.data.demo;

import com.oreilly.spring.data.demo.entities.Officer;
import com.oreilly.spring.data.demo.entities.Rank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class OfficerRepositoryTest {

    @Autowired
    @Qualifier("officerRepository")
    private OfficerRepository officerRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testSave(){
        Officer officer = new Officer(Rank.LIEUTENANT, "Nyota", "Uhuru");
        officer = officerRepository.save(officer);
        assertNotNull(officer.getId());
        assertEquals(officer.getFirst(), "Nyota");
        assertEquals(officer.getLast(), "Uhuru");

    }

    @Test
    public void findOne(){
        jdbcTemplate.query("select id from officers", (rs, rowNum) -> rs.getInt("id") )
        .forEach(id -> {
            Optional<Officer> officer = officerRepository.findById(id);
            assertNotNull(officer);
            assertEquals(officer.get().getId(), id);
        });
    }

    @Test
    public void findByRank() {
    }

    @Test
    public void findByLast() {
    }
}