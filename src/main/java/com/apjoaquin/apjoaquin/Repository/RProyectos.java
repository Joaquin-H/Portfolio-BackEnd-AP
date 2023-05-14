package com.apjoaquin.apjoaquin.Repository;

import com.apjoaquin.apjoaquin.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByDescripcion(String desc);
    public boolean existsByDescripcion(String desc);
}
