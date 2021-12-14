package com.codes.blas.servicio;

import com.codes.blas.dao.IPersonaDAO;
import com.codes.blas.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService{

    @Autowired
    IPersonaDAO iPersonaDAO;

    @Override
    public List<Persona> listarPersona() {
        return (List<Persona>) iPersonaDAO.findAll();
    }

    @Override
    public void guardar(Persona persona) {
        iPersonaDAO.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        iPersonaDAO.delete(persona);
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        //si no encuentra a la persona devuelve nulo
        return iPersonaDAO.findById(persona.getIdPersona()).orElse(null);
    }
}
