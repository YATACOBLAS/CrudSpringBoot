package com.codes.blas.servicio;

import com.codes.blas.domain.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonaService {

    public List<Persona> listarPersona();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);

}
