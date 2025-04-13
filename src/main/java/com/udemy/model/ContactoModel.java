package com.udemy.model;

import com.udemy.entity.ContactoEntity;

public class ContactoModel {
    private int id;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ContactoModel(int id, String nombre, String apellido, String ciudad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public ContactoModel(){}

    @Override
    public String toString() {
        return "ContactoModel [apellido=" + apellido + ", ciudad=" + ciudad + ", id=" + id + ", nombre=" + nombre
                + ", telefono=" + telefono + "]";
    }

    public ContactoModel(ContactoEntity entity){
        this.id=entity.getId();
        this.apellido=entity.getApellido();
        this.nombre=entity.getNombre();
        this.ciudad=entity.getCiudad();
        this.telefono=entity.getTelefono();
    }
    
}
