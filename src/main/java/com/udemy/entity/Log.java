package com.udemy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue  Indica que esa clave se auto genera por medio de auto increment
    @Column(name="id")    
    private int id;
    
    @Column(name="fecha")    
    private Date fecha;
    @Column(name="detalles")    
    private String detalles;
    @Column(name="usuario")    
    private String usuario;
    @Column(name="url")    
    private String url;

    public Log(){}

    
    /** 
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return Date
     */
    public Date getFecha() {
        return fecha;
    }

    
    /** 
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    /** 
     * @return String
     */
    public String getDetalles() {
        return detalles;
    }

    
    /** 
     * @param detalles
     */
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    /** 
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    
    /** 
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    /** 
     * @return String
     */
    public String getUrl() {
        return url;
    }

    
    /** 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Log(Date fecha, String detalles, String usuario, String url) {
        this.fecha = fecha;
        this.detalles = detalles;
        this.usuario = usuario;
        this.url = url;
    }

}
