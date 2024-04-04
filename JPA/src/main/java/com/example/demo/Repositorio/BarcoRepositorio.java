package com.example.demo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidades.Barco;


@Repository
public interface BarcoRepositorio extends JpaRepository<Barco, Long>{
	
    Optional<Barco> findById(Long id);

    @Query("select c from Barco c where c.Nombre = ?1")
    Barco getBarcoByName(String nombre);
    

    
}
