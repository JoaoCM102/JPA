package com.example.demo.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entidades.Barco;
import com.example.demo.Entidades.Patron;

public class PatronRepositorioTest {

    @Autowired
    PatronRepositorio patronRepositorio;


    @Test
    void anyadirPatron(){
        Patron patron =  new Patron();
        patron.setNombre("Juan");
        patron.setApellido("Jimenez");
        patron.setDirección("Calle la Ruta");
        patron.setEmail("juan@gmail.com");
        patron.setTeléfono("5555555");
        patronRepositorio.save(patron);
        
    }

    @Test
    void modificarPatron(){
        Long id = 1L;
        Patron patron = patronRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        patron.setNombre("Nuevo Dato");
        patron.setApellido("Nuevo apellido");
        patron.setTeléfono("555555555");

        patronRepositorio.save(patron);
    }


    @Test
    void getPatronByName(){

        Patron patron = patronRepositorio.getPatronByName("");

    }


    @Test
    void deleteById(){
        Long id = 2L;
        if (patronRepositorio.existsById(id)) {
            patronRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}
