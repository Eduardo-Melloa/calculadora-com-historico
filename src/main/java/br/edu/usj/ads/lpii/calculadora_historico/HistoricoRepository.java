package br.edu.usj.ads.lpii.calculadora_historico;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HistoricoRepository extends CrudRepository<Historico,Long> {
    List <Historico> findAll(); 
}
