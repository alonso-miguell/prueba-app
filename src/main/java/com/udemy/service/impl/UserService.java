package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//UserDetailsService es la interfaz de seguridad de spring
@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    

    //creamos el usuario
    //GrantedAuthority es el tipo de objeto de Spring security, en realidad envuelve nuestra entidad
    private User buildUser(com.udemy.entity.User user, List<GrantedAuthority> authorities){
        //mapeamos nuestro usuario (entidad) con el tipo de usuario de spring security
        return 
            new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
    }

    //creamos las autoridades 
    private List<GrantedAuthority> builAuthorities (Set<UserRole> userRoles){
        Set<GrantedAuthority> auths =new HashSet<GrantedAuthority>();

        for(UserRole item: userRoles){
            auths.add( new SimpleGrantedAuthority(item.getRol()));
        }

        List<GrantedAuthority> autoridades=new ArrayList<GrantedAuthority>(auths);
        return autoridades;        
    }

    @Override //metodo a sobrescribir de la interfaz de seguridad de spring
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.udemy.entity.User user= userRepository.findByUsername(username);
        List<GrantedAuthority> autoridades=builAuthorities(user.getUserRols());

        UserDetails detalles=buildUser(user,autoridades);
        return detalles;
    }

   

}
