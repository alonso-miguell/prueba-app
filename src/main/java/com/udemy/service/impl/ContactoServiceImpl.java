package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.udemy.controller.ContactoController;
import com.udemy.entity.ContactoEntity;
import com.udemy.model.ContactoModel;
import com.udemy.repository.ContactoRepository;
import com.udemy.service.ContactoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.pattern.Converter;

@Service("contactoServiceImpl")
public class ContactoServiceImpl implements ContactoService {

    private static final Log LOGGER =LogFactory.getLog(ContactoServiceImpl.class);
    

    @Autowired
    @Qualifier("contactoRepository")
    private ContactoRepository repository;

    @Override
    public ContactoModel addContacto(ContactoModel contacto) {
        ContactoModel modelo = new ContactoModel(repository.save(new ContactoEntity(contacto)));
        return modelo;

    }

    @Override
    public int deleteContacto(int id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public List<ContactoModel> listContacto() {
        List<ContactoEntity> listaEntidades = repository.findAll();
        List<ContactoModel> modelos = new ArrayList<>();
        for (ContactoEntity item : listaEntidades) {
            modelos.add(new ContactoModel(item));
        }
        return modelos;
    }

    @Override
    public ContactoModel updateContacto(ContactoModel contacto) {
        ContactoModel modelo = new ContactoModel(repository.save(new ContactoEntity(contacto)));
        return modelo;

    }

    @Override
    public ContactoModel findbyID(int id) {
        Optional<ContactoEntity> optionalEntity=repository.findById(id);
        ContactoEntity entidad=optionalEntity.get();
        ContactoModel temp=new ContactoModel(entidad);
        LOGGER.info("contacto encontrado: "+temp.toString());
        return temp;
    }
    
    


}
