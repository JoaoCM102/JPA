package com.example.demo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidades.Salida;

@Repository
public interface SalidaRepositorio extends JpaRepository<Salida, Long>{
	Optional<Salida> findById(Long id);

    @Query("select c from Salida c where c.destino = ?1")
    Salida getSalidaByDestino(String destino);
}
