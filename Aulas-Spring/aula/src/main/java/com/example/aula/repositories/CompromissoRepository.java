package com.example.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.aula.entities.Compromisso;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{

}
