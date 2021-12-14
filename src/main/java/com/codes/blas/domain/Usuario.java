package com.codes.blas.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
}
