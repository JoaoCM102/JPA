package com.example.demo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidades.Patron;

@Repository
public interface PatronRepositorio extends JpaRepository<Patron, Long>{
	Optional<Patron> findById(Long id);

    @Query("select c from Patron c where c.Nombre = ?1")
    Patron getPatronByName(String nombre);
}
