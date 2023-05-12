package com.apjoaquin.apjoaquin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, max = 50, message = "Supera el maximo de caracteres")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Supera el maximo de caracteres")
    private String apellido;
    
    @Size(min = 1, max = 50, message = "Supera el maximo de caracteres")
    private String img;

    //aqui estan los getters y setters para que se vean, se podia colocar las dos notation 
    //"@Getter y "@Setter" funcionando igual pero sin ver el codigo.
    
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
