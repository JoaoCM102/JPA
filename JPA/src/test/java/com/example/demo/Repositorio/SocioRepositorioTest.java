package com.example.demo.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entidades.Patron;
import com.example.demo.Entidades.Socio;

@SpringBootTest
public class SocioRepositorioTest {
    
    @Autowired
    SocioRepositorio socioRepositorio;


    @Test
    void anyadirSocio(){
        Socio patron =  new Socio();
        patron.setNombre("pedro");
        patron.setApellido("Peluca");
        patron.setDireccion("Calle la Ruta");
        patron.setEmail("juan@gmail.com");
        patron.setTelefono("1234567");
        socioRepositorio.save(patron);
        
    }

    @Test
    void modificarSocio(){
        Long id = 1L;
        Socio socio = socioRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        socio.setNombre("Nuevo Dato");
        socio.setApellido("Nuevo apellido");
        socio.setTelefono("555555555");

        socioRepositorio.save(socio);
    }


    @Test
    void getSocioByName(){

        Socio socio = socioRepositorio.getSocioByName("");
        
        socio.toString();

    }


    @Test
    void deleteById(){
        Long id = 1L;
        if (socioRepositorio.existsById(id)) {
            socioRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}
