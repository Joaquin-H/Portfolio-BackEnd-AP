package com.apjoaquin.apjoaquin.Service;

import com.apjoaquin.apjoaquin.Entity.Proyectos;
import com.apjoaquin.apjoaquin.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list() {
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByDescripcion(String desc) {
        return rProyectos.findByDescripcion(desc);
    }

    public void save(Proyectos proyecto) {
        rProyectos.save(proyecto);
    }

    public void delete(int id) {
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyectos.existsById(id);
    }

    public boolean existsByDescripcion(String desc) {
        return rProyectos.existsByDescripcion(desc);
    }

}
