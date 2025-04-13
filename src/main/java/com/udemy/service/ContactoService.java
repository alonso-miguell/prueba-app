package com.udemy.service;

import java.util.List;

import com.udemy.model.ContactoModel;

public interface ContactoService {
    
    public abstract ContactoModel addContacto(ContactoModel contacto);
    public abstract ContactoModel updateContacto(ContactoModel contacto);
    public abstract int deleteContacto(int id);
    public abstract List<ContactoModel> listContacto();
    public abstract ContactoModel findbyID(int id);
}
