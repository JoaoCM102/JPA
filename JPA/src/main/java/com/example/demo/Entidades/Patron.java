package com.example.demo.Entidades;


import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Validated
@Data
public class Patron {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Patron;
	
	@Basic
	@Column(nullable = false)
	@NotBlank(message = "El nombre esta vacio ")
    private String Nombre;
	
	@Column(nullable = false)
	@NotBlank(message = "El apellido esta vacio ")
    private String Apellido;
	
	@NotBlank(message = "La direccion esta vacio ")
    private String Dirección;
	
	@NotBlank(message = "El telefono no puede estar vacio ")
    @Column(nullable = false)
    private String Teléfono;
    
    @Email
    private String Email;
    
    @OneToOne(
    		mappedBy = "patron")
    private Salida salida;
}
