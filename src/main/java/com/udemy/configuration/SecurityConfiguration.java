package com.udemy.configuration;

import com.udemy.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // salida a web
@EnableGlobalMethodSecurity(prePostEnabled = true) //para habilitar la preautorizacion del acceso a metodos segun el rol de usuario
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userService")
    private UserDetailsService userService;

    @Autowired // autowired a metodo
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //definimos la configuraicon del login por medio del objeto http a travesz del modiulo spring security 

        http.authorizeRequests().antMatchers("/css/*","imgs/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").loginProcessingUrl("/loginCheck")
        .usernameParameter("usuario").passwordParameter("contrasenia")
        .defaultSuccessUrl("/loginsuccess").permitAll()
        .and()
        .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
        .permitAll();

        /*
        loginProcessingUrl("/loginCheck") hace referencia a la urlaction del formulario y que sera
         manejada por el framework. NO es un metodo que sea declarado dentro del controlador
         */
    }

    

    
    
}
