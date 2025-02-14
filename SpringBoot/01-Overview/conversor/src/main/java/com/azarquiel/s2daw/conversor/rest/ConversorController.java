package com.azarquiel.s2daw.conversor.rest;

import com.azarquiel.s2daw.conversor.dto.ConversorResultado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
public class ConversorController {

    @Value("${conversion.millaskm}")
    private String millaskm;
    @Value("${conversion.kmmillas}")
    private String kmmillas;

    @GetMapping("/millaskm/{valor}")
    public ConversorResultado millasAKm(@PathVariable BigDecimal valor){
        BigDecimal resultado = valor.multiply(new BigDecimal(millaskm));
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return new ConversorResultado(resultado);
    }

    @GetMapping("/kmmillas/{valor}")
    public ConversorResultado kmAMillas(@PathVariable BigDecimal valor){
        BigDecimal resultado = valor.multiply(new BigDecimal(kmmillas));
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return new ConversorResultado(resultado);
    }
}
