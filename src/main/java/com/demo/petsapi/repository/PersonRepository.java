package com.demo.petsapi.repository;

import com.demo.petsapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jandrada
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
