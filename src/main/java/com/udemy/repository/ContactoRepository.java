package com.udemy.repository;

import java.io.Serializable;

import com.udemy.entity.ContactoEntity;
import com.udemy.model.ContactoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestAttribute;

@Repository("contactoRepository")
public interface ContactoRepository extends JpaRepository<ContactoEntity, Serializable> {

   
}
