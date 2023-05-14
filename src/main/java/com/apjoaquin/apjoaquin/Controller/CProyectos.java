package com.apjoaquin.apjoaquin.Controller;

import com.apjoaquin.apjoaquin.Dto.dtoProyectos;
import com.apjoaquin.apjoaquin.Entity.Proyectos;
import com.apjoaquin.apjoaquin.Security.Controller.Mensaje;
import com.apjoaquin.apjoaquin.Service.SProyectos;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.BAD_REQUEST);
        }

        Proyectos Proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(Proyectos, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoProyectos) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        if (sProyectos.existsByDescripcion(dtoProyectos.getDescripcion()) && sProyectos.getByDescripcion(dtoProyectos.getDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Proyecto Ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyectos.getDescripcion())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Proyectos Proyectos = sProyectos.getOne(id).get();

        Proyectos.setDescripcion(dtoProyectos.getDescripcion());
        Proyectos.setImg(dtoProyectos.getImg());
        Proyectos.setLink(dtoProyectos.getLink());
        Proyectos.setFecha(dtoProyectos.getFecha());

        sProyectos.save(Proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

    //CREACION Y ELIMINACION DE USUARIOS (NO UTILIZADO)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoProyectos) {
        if (StringUtils.isBlank(dtoProyectos.getDescripcion())) {
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyectos.existsByDescripcion(dtoProyectos.getDescripcion())) {
            return new ResponseEntity(new Mensaje("Ya existe ese proyecto"), HttpStatus.BAD_REQUEST);
        }
        Proyectos Proyecto = new Proyectos(
                dtoProyectos.getDescripcion(),dtoProyectos.getImg(), dtoProyectos.getFecha(),
                dtoProyectos.getLink()
        );
        sProyectos.save(Proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Creado"), HttpStatus.OK);
    }
}

