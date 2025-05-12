package com.example.CrudJPAHibernateTodoCode.service;


import com.example.CrudJPAHibernateTodoCode.domain.Paciente;

import java.time.LocalDate;
import java.util.List;

public interface IPacienteService {

    public List<Paciente> getPersonas();
    public void savePersona(Paciente paciente);
    public Paciente findPersona(Long id);

    public Paciente findPersonaPorDni(String dni);

    Paciente updatePersona(Long idOriginal, Paciente pacienteActualizado);

    //    public void updatePersona(Long id, Long newId, String newName, String newApellido, String dni, LocalDate newFechaNacimiento);
    public void deletePersona(Long id);
}
