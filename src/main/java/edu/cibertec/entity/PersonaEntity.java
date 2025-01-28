package edu.cibertec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("persona")
public class PersonaEntity {
    
    @Id
    private Integer idpersona;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellido;

    @Min(value = 0, message = "La edad debe ser mayor o igual a 0")
    private Integer edad;



}
