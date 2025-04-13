package com.udemy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.udemy.model.ContactoModel;

@Entity
@Table(name = "Contacto")
public class ContactoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue  Indica que esa clave se auto genera por medio de auto increment
    @Column(name="id")    
    private int id;
    
    @Column(name="nombre")    
    private String nombre;
    @Column(name="apellido")    
    private String apellido;
    @Column(name="ciudad")    
    private String ciudad;
    @Column(name="telefono")    
    private String telefono;

    
    
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
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return String
     */
    public String getApellido() {
        return apellido;
    }

    
    /** 
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    /** 
     * @return String
     */
    public String getCiudad() {
        return ciudad;
    }

    
    /** 
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    /** 
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    
    /** 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ContactoEntity(int id, String nombre, String apellido, String ciudad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public ContactoEntity(){}
    
    public ContactoEntity(ContactoModel model){
        this.id=model.getId();
        this.apellido=model.getApellido();
        this.nombre=model.getNombre();
        this.ciudad=model.getCiudad();
        this.telefono=model.getTelefono();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "ContactoEntity [apellido=" + apellido + ", ciudad=" + ciudad + ", id=" + id + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }

    

}
