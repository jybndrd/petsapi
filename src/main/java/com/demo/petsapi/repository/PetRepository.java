package com.demo.petsapi.repository;

import com.demo.petsapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jandrada
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByPersonId(Long personId);
}