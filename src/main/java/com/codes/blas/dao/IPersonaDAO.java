package com.codes.blas.dao;

import com.codes.blas.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDAO extends JpaRepository<Persona,Long> {


}
