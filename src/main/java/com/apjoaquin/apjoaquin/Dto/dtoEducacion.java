package com.apjoaquin.apjoaquin.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;
    @NotBlank
    private int anioEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String descripcionEd, int anioEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.anioEd = anioEd;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

    public int getAnioEd() {
        return anioEd;
    }

    public void setAnioEd(int anioEd) {
        this.anioEd = anioEd;
    }
    
    
    
}
