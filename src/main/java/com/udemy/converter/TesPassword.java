package com.udemy.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesPassword {

    //clase d perueba para generar contraseñás
    public static void main(String[] args){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        System.out.println(encoder.encode("user"));
    }
    
}
