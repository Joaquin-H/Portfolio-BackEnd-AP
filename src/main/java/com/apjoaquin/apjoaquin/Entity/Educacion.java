package com.apjoaquin.apjoaquin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;
    private int anioEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String descripcionEd, int anioEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.anioEd = anioEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
