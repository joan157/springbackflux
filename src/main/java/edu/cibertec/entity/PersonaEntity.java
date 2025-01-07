package edu.cibertec.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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
    private String nombre;
    private String apellido;
    private Integer edad;



}
