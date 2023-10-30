package com.example.demo.repo;

import com.example.demo.person.PersonEntity;
import com.example.demo.projections.PersonProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
//    PersonProjection saveAndReturnProjection(PersonEntity personEntity);

    @Query(value = "SELECT PERSON_ID as personId, FIRST_NAME as firstName FROM PERSON", nativeQuery = true)
    Page<PersonProjection> findAllPersons(Pageable pageable);
}
