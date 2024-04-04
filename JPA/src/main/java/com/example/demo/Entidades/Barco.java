package com.example.demo.Entidades;


import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Validated
@Data
public class Barco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Barco;
	
	@Basic
	@Column(nullable = false)
	@NotBlank
    private String Número_Matrícula;
	
	@NotBlank(message = "El campo nombre esta vacio")
    private String Nombre;
	
	@NotNull
    private int Número_Amarre;
    private double Cuota; 
    
    @OneToOne
    @JoinColumn(
    		name = "salida",
    		referencedColumnName = "ID_Salida")
    private Salida salida;
    
    @ManyToOne
    @JoinColumn(
    		name = "idSocio",
    		referencedColumnName = "ID_Socio")
    private Socio socio;
}
