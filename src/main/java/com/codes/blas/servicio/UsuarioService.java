package com.codes.blas.servicio;

import com.codes.blas.dao.IRolDAO;
import com.codes.blas.dao.IUsuarioDAO;
import com.codes.blas.domain.Rol;
import com.codes.blas.domain.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService,IUsuarioService {

    @Autowired
    private IUsuarioDAO iUsuarioDAO;

    @Autowired
    private RolService rolService;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioDAO.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        }
        var roles= new ArrayList<GrantedAuthority>();
        log.info(usuario.getRoles().toString());
        for (Rol rol: usuario.getRoles() ) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }



    @Override
    public void registrar(Usuario usuario) {
        BCryptPasswordEncoder encriptar= new BCryptPasswordEncoder();
        usuario.setPassword(encriptar.encode(usuario.getPassword()));
        Usuario usuario_registrado=iUsuarioDAO.save(usuario);
        log.info(usuario_registrado.toString());
        //var roles= new ArrayList<Rol>();
        Rol rol1= new Rol();
        rol1.setNombre("ROLE_USER");
        rol1.setId_usuario(usuario_registrado.getIdUsuario());
       // rol1.setUsuario(usuario_registrado);
        //roles.add(rol1);
        rolService.guardar(rol1);
    }
}
