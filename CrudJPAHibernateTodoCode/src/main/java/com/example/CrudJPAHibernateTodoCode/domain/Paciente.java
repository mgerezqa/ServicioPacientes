package com.example.CrudJPAHibernateTodoCode.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor // Constructor sin argumentos generado por Lombok
@AllArgsConstructor // Constructor con todos los argumentos generado por Lombok
@Getter @Setter
@Entity

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;
    private String telefono;


}
