package com.example.demo.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entidades.Salida;
import com.example.demo.Entidades.Socio;

@SpringBootTest
public class SalidaRepositorioTest {

    @Autowired
    SalidaRepositorio salidaRepositorio;


    @Test
    void anyadirSalida(){
        Salida salida =  new Salida();
        salida.setHora("2 am");
        salida.setDestino("Singapur");
        salida.setFecha("22 abil");
        salidaRepositorio.save(salida);
        
    }

    @Test
    void modificarSalida(){
        Long id = 1L;
        Salida salida = salidaRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro Salida con id" + id));
        salida.setFecha("20 de febrero");
        salida.setDestino("Añaza");
        salida.setFecha("2 PM");

        salidaRepositorio.save(salida);
    }


    @Test
    void getSalidaByName(){

        Salida salida = salidaRepositorio.getSalidaByDestino("");
        
        salida.toString();

    }


    @Test
    void deleteById(){
        Long id = 2L;
        if (salidaRepositorio.existsById(id)) {
            salidaRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}
    }
}
