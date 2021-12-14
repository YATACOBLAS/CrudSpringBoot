package com.codes.blas.servicio;

import com.codes.blas.dao.IRolDAO;
import com.codes.blas.domain.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImp implements RolService{

    @Autowired
    IRolDAO iRolDAO;

    @Override
    public void guardar(Rol rol) {
        iRolDAO.save(rol);
    }
}
