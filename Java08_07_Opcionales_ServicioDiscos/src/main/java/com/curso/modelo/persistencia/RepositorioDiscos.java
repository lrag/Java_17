package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Disco;

@Repository
public interface RepositorioDiscos extends JpaRepository<Disco, Integer>{

}
