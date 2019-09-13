package com.mmelo.rabbit.repository;

import com.mmelo.rabbit.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLogin(final String login);
}