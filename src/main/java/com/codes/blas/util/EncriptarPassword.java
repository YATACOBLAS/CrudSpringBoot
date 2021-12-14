package com.codes.blas.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {

        var pass="123";
        System.out.println("password:"+ pass);
        pass=encriptarPassword(pass);
        System.out.println(" new password: "+pass);
    }

    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
