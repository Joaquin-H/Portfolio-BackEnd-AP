/* el nombre es I de interface Persona Repository*/

package com.apjoaquin.apjoaquin.Repository;

import com.apjoaquin.apjoaquin.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}