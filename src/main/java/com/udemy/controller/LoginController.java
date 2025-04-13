package com.udemy.controller;

import javax.validation.Valid;

import com.udemy.constant.ViewConstants;
import com.udemy.model.UserCredential;
import com.udemy.service.impl.ContactoServiceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    // @GetMapping("/")
    // public String redirectToLogin(){
    // return "redirect:/login";
    // }

    @GetMapping(value = "/login")
    public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        // LOGGER.info("mensajeeee");
        // model.addAttribute("userCredentials", new UserCredential()); //deja de ser
        // necesaria con spring security
        return ViewConstants.LOGIN_VIEW;
    } 

    @Autowired
    @Qualifier("contactoServiceImpl")
    ContactoServiceImpl servicio;

    // @PostMapping("/logincheck")
    // public String loginCheck(@Valid @ModelAttribute(name = "userCredentials") UserCredential userCredential) {
    //     if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
    //         return "redirect:/contact/listaContactos";
    //     } else {
    //         return "redirect:/login?error";
    //     }
    // }

    @GetMapping({ "/loginsuccess", "/" })
    public String loginCheck() {
        LOGGER.info("METODO LOGIN SUCCESS, mandando a vista contactos");
        return "redirect:/contact/listaContactos";
    }

}
