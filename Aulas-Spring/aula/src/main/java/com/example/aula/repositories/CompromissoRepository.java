package com.example.aula.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.aula.entities.Compromisso;
import com.example.aula.entities.Contato;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{

	List<Compromisso> findAllByContato(Contato contato);
	List<Compromisso> findAllByData(Date data);
	
	@Query("SELECT c FROM Compromisso c WHERE c.data BETWEEN :dataInicio AND :dataFinal")
	List<Compromisso> findAllByEntreDatas(Date dataInicio, Date dataFinal);
}
