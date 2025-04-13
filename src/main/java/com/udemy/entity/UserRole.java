package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_roles",uniqueConstraints = @UniqueConstraint(columnNames = {"rol","username"}))

public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue  Indica que esa clave se auto genera por medio de auto increment
    @Column(name="user_role_id", unique = true, nullable = false)    
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username",nullable=false)
    private User user;

    @Column(name="rol",nullable = false, length = 45)    
    private String Rol;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public UserRole(Integer userRoleId, User user, String rol) {
        this.userRoleId = userRoleId;
        this.user = user;
        Rol = rol;
    }
    
    public UserRole(){}
}
