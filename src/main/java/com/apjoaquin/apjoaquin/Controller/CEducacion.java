package com.apjoaquin.apjoaquin.Controller;

import com.apjoaquin.apjoaquin.Dto.dtoEducacion;
import com.apjoaquin.apjoaquin.Entity.Educacion;
import com.apjoaquin.apjoaquin.Security.Controller.Mensaje;
import com.apjoaquin.apjoaquin.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://argpr-portfolio.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if (!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"),HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if (StringUtils.isBlank(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreEd(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("Ya existe ese nombre"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombreEd(), dtoeducacion.getDescripcionEd(), dtoeducacion.getAnioEd()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Creada"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombreEd(dtoeducacion.getNombreEd()) && sEducacion.getByNombreEd(dtoeducacion.getNombreEd()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese Nombre Ya existe"),HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoeducacion.getNombreEd())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setNombreEd(dtoeducacion.getNombreEd());
        educacion.setDescripcionEd(dtoeducacion.getDescripcionEd());
        educacion.setAnioEd(dtoeducacion.getAnioEd());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Actualizada"),HttpStatus.OK);
    }
    
}
