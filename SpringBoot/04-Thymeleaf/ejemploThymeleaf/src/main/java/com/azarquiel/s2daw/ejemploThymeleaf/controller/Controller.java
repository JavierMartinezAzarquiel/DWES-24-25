package com.azarquiel.s2daw.ejemploThymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String index(Model model) {  //el objeto model es el contenedor donde enviamos los objetos a la vista

        //añadir un objeto al modelo
        model.addAttribute("fecha",java.time.LocalDateTime.now());

        return "index"; // el modelo se envía a el archivo index.html
    }

}
