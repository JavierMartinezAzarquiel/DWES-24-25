package com.azarquiel.s2daw.conversor.dto;

import java.math.BigDecimal;

public class ConversorResultado {

    private BigDecimal resultado;

    public ConversorResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }
}
