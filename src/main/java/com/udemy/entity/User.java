package com.udemy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue  Indica que esa clave se auto genera por medio de auto increment
    @Column(name="username", unique = true, nullable = false, length = 45)    
    private String username;
    
    @Column(name="password", nullable = false, length = 60)    
    private String password;

    @Column(name="enabled", nullable = false )    
    private Boolean enabled;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user") //mappedBy indica el nombre de la entidad por la que sera mapeada. En este caso la misma entidad User
    private Set<UserRole> userRols= new HashSet<UserRole>();

    public User(String username, String password, Boolean enabled, Set<UserRole> userRols) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRols = userRols;
    }

    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<UserRole> userRols) {
        this.userRols = userRols;
    }

    
    
}
