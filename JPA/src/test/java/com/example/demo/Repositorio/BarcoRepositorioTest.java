package com.example.demo.Repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entidades.Barco;
@SpringBootTest
public class BarcoRepositorioTest {

    @Autowired
    BarcoRepositorio barcoRepositorio;


    @Test
    void anyadirBarco(){
        Barco barco =  new Barco();
        barco.setNúmero_Matrícula("Vamo");
        barco.setNombre("Barco de Ejemplo");
        barco.setNúmero_Amarre(5);
        barco.setCuota(1000.50);
        barcoRepositorio.save(barco);
        
    }

    @Test
    void modificarBarco(){
        Long id = 1L;
        Barco barco = barcoRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        barco.setNombre("Nuevo Dato");
        barco.setCuota(200);
        barco.setNúmero_Amarre(15);

        barcoRepositorio.save(barco);
    }


    @Test
    void getBarcoByName(){

        Barco barco = barcoRepositorio.getBarcoByName("Barco de Ejemplo");

    }


    @Test
    void deleteById(){

        Long id = 2L;
        if (barcoRepositorio.existsById(id)) {
            barcoRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}

    }
}
