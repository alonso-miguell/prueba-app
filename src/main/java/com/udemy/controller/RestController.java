package com.udemy.controller;

import com.udemy.model.ContactoModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @GetMapping("/rest1")
    public ResponseEntity<String> checkRest(){
        return new ResponseEntity<String>("rest1",HttpStatus.OK);
    }
    
    @GetMapping("/rest2")
    public ResponseEntity<ContactoModel> checkRest2(){
        ContactoModel cm=new ContactoModel(2,"Miguel","Alonso","43365465","CDMX");
        return new ResponseEntity<ContactoModel>(cm,HttpStatus.OK);
    }
    
}
