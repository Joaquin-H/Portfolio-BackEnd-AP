package com.apjoaquin.apjoaquin.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private int fecha;
    @NotBlank
    private String link;
    
    public dtoProyectos() {
    }

    public dtoProyectos(String descripcion, String img, int fecha, String link) {
        this.descripcion = descripcion;
        this.img = img;
        this.fecha = fecha;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
}
