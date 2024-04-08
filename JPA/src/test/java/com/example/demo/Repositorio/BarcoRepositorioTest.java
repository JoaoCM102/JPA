package com.example.demo.Repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entidades.Barco;
import com.example.demo.Entidades.Socio;
@SpringBootTest
public class BarcoRepositorioTest {


    
    @Autowired
    SocioRepositorio socioRepositorio;
    @Autowired
    BarcoRepositorio barcoRepositorio;
    @Autowired
    SalidaRepositorio salidaRepositorio;




    


    @Test
    void anyadirBarco(){
        Barco barco =  new Barco();

        //Socio socio = socioRepositorio.findById(1L).orElseThrow(()-> new IllegalArgumentException("No esta ese socio en la base"));

        barco.setNumeroMatricula("Nuevo");
        barco.setNombre("Ver si funciona");
        barco.setNumeroAmarre(5);
        barco.setCuota(1000.50);
        //barco.setSocio(socio);
        barcoRepositorio.save(barco);
        
    }

    @Test
    void modificarBarco(){
        Long id = 1L;
        Barco DatosInicial = barcoRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        Barco barco = barcoRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        barco.setNombre("Nuevo Dato");
        barco.setCuota(200);
        barco.setNumeroAmarre(15);

        barcoRepositorio.save(barco);
        

        Barco barcoProbar = barcoRepositorio.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el barco con id" + id));
        

        assertNotEquals(DatosInicial, barcoProbar);
       
    }


    @Test
    void getBarcoByName(){

        Barco barco = barcoRepositorio.getBarcoByNombreBarco("Barco de Ejemplo");
        Barco prueba = new Barco();
        prueba.setNumeroAmarre(5);

        assertEquals(barco.getNumeroAmarre(), prueba.getNumeroAmarre());

    }


    @Test
    void deleteById(){

        Long id = 1L;
        if (barcoRepositorio.existsById(id)) {
            barcoRepositorio.deleteById(id);
        }else{throw new IllegalArgumentException("No se pudo encontrar este Id");}



    }


    @Test
    void unir(){

        Barco barco = barcoRepositorio.findById(3L).get(); 

        Socio socio = socioRepositorio.findById(1L).get();


        barco.setSocio(socio);

        barcoRepositorio.save(barco);
        
    }
}
