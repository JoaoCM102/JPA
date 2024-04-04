package com.example.demo.Entidades;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Validated
@Data
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Socio;
	
	@Basic
	@Column(nullable = false)
	@NotBlank(message = "El nombre esta vacio ")
    private String Nombre;
	
	@Column(nullable = false)
	@NotBlank(message = "El apellido esta vacio ")
    private String Apellido;
	
	@NotBlank(message = "La direccion esta vacio ")
    private String Dirección;
	
    @Column(nullable = false)
    private String Teléfono;
    
    @Email
    private String Email;
    
    @OneToMany(
    		cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER)
    @JoinColumn(
    		name = "idSocio",
    		referencedColumnName = "ID_Socio")
    private List<Barco> barcos;
    
    
    
}
