package com.example.demo.Entidades;


import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Validated
@Data
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_Salida;
	
	@NotBlank(message = "Campo hora vacio ")
	private String hora;
	
	@NotBlank(message = "Campo fecha vacio ")
    private String fecha;
	
	@NotBlank(message = "Campo destino vacio ")
    private String destino;
   
    
    @OneToOne(
    		mappedBy = "salida",
    		fetch = FetchType.EAGER)
    private Barco barco;
    
    
    @OneToOne
    @JoinColumn(
    		name = "patron",
    		referencedColumnName = "ID_Patron")
    private Patron patron;
}
