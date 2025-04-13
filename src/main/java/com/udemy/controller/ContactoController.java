package com.udemy.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import com.udemy.constant.ViewConstants;
import com.udemy.model.ContactoModel;
import com.udemy.service.impl.ContactoServiceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/contact")
// @PreAuthorize("permitAll()") //tyambien s epuede a nivel clase para acceder a todos los metyodos
    
public class ContactoController {

    private static final Log LOGGER =LogFactory.getLog(ContactoController.class);
    

    @Autowired
    @Qualifier("contactoServiceImpl")
    ContactoServiceImpl servicio;
    
    
    /** 
     * @return String
     */
    @PreAuthorize("hasRole('ROL_ADMIN')") //solo permitimos acceso a usuario con ese rol y sino, manda pantalla en blanco
    @GetMapping("/contactForm") 
    // public ModelAndView contactForm(){
    //     ModelAndView mav=new ModelAndView(ViewConstants.CONTACT_FORM_VIEW);
    //     mav.addObject("contacto", new ContactoModel());
    //     return mav;
    // }
    public String contactForm(Model model, @RequestParam(name = "id",required=false) int id){        
        if(id==0){ //añadimos usuario mnuevo
            model.addAttribute("contacto", new ContactoModel());
        }
        else{ //bnusca,mos mel usuario a editar
            ContactoModel usuario=servicio.findbyID(id);
            model.addAttribute("contacto", usuario);
        }
        return ViewConstants.CONTACT_FORM_VIEW;
    }

    
    /** 
     * @return RedirectView
     */
    @PostMapping("/addContact")
    // public String addContact(@ModelAttribute ("contacto") ContactoModel contacto, Model model){
    //     ContactoModel temp=servicio.addContacto(contacto);
    //     if(temp!=null){
    //         LOGGER.info(temp.toString());
    //         model.addAttribute("error", 1);
    //     }
    //     else{
    //         model.addAttribute("error", 0);
    //     }

    //     return "redirect:/contact/listaContactos";
    // }

    public RedirectView addContact(@ModelAttribute ("contacto") ContactoModel contacto, RedirectAttributes redirectAttributes){
        ContactoModel temp=servicio.addContacto(contacto);
        if(temp!=null){
            LOGGER.info(temp.toString());
            redirectAttributes.addFlashAttribute("error",0);
            return new RedirectView("/contact/listaContactos");
        }
        else{
            redirectAttributes.addFlashAttribute("error",1);
            return new RedirectView("/contact/listaContactos");
        }
    }

    
    /** 
     * @param model
     * @return ModelAndView
     */
    @PreAuthorize("permitAll()") //permitimos acceso a todos
    @GetMapping("/listaContactos")
    public ModelAndView lista(Model model ){
        ModelAndView mav=new ModelAndView(ViewConstants.CONTACTS_VIEW);
        mav.addObject("lista",servicio.listContacto() );
        // mav.addObject("error", errorContacto);

        //obtenemos usuario de spring autenticado
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        return mav;
    }

    
    /** 
     * @param model
     * @param "id"
     * @param id
     * @return String
     */
    @GetMapping("/eliminaContacto") 
    public String eliminarContacto(Model model, @RequestParam(name = "id",required=true) int id){        
         servicio.deleteContacto(id);
         return "redirect:/contact/listaContactos";
       
    }
}
// 