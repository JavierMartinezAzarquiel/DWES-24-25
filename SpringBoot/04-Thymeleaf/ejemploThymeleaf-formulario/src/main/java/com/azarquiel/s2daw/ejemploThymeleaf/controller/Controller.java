package com.azarquiel.s2daw.ejemploThymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.stereotype.Controller
public class Controller {

   @RequestMapping("/")
    public String index() {
       return "formulario";
   }

    @RequestMapping("/respuesta")
    public String respuesta() {
        return "respuesta";
    }
}
