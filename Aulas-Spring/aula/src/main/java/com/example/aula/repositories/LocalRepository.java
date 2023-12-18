package com.example.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.aula.entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

}
