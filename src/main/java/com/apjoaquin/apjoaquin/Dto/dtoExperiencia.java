package com.apjoaquin.apjoaquin.Dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;

/**
 * DataTransferObject DTO
 */

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private int anioE;
    
    //constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    //getter and setter
    public String getNombreE() {
        return nombreE;
    }

    public int getAnioE() {
        return anioE;
    }

    public void setAnioE(int anioE) {
        this.anioE = anioE;
    }


    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
}
