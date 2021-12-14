package com.codes.blas.dao;

import com.codes.blas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);

}
