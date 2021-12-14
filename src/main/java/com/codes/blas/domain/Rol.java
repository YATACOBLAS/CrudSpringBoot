package com.codes.blas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @NotEmpty
    private String nombre;

    private int id_usuario;

    //usa JpinColumn porque es el lado propietario del la clave
     /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "rol_ibfk_1"), name = "id_usuario",referencedColumnName = "idUsuario",columnDefinition = "int")
    private Usuario usuario;
    */
}
