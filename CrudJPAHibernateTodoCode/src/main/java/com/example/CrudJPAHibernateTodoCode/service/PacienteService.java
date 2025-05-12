package com.example.CrudJPAHibernateTodoCode.service;


import com.example.CrudJPAHibernateTodoCode.domain.Paciente;
import com.example.CrudJPAHibernateTodoCode.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getPersonas() {
        return pacienteRepository.findAll();
    }

    @Override
    public void savePersona(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente findPersona(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return paciente;

    }

    @Override
    public Paciente findPersonaPorDni(String dni) {
        Paciente paciente = pacienteRepository.findByDni(dni).orElse(null);
        return paciente;

    }

//    @Override
//    public void updatePersona(Long idOriginal, Long newId, String newName, String newApellido, String newDni, LocalDate newFechaNacimiento) {
//        Paciente paciente = pacienteRepository.findById(idOriginal).orElse(null);
//        paciente.setNombre(newName);
//        paciente.setApellido(newApellido);
//        paciente.setFechaNacimiento(newFechaNacimiento);
//        paciente.setDni(newDni);
//        pacienteRepository.save(paciente);
//    }

    @Override
    public Paciente updatePersona(Long idOriginal, Paciente pacienteActualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(idOriginal)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Actualizar solo los campos no nulos
        if (pacienteActualizado.getNombre() != null) {
            pacienteExistente.setNombre(pacienteActualizado.getNombre());
        }
        if (pacienteActualizado.getApellido() != null) {
            pacienteExistente.setApellido(pacienteActualizado.getApellido());
        }
        if (pacienteActualizado.getDni() != null) {
            pacienteExistente.setDni(pacienteActualizado.getDni());
        }
        if (pacienteActualizado.getFechaNacimiento() != null) {
            pacienteExistente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
        }

        return pacienteRepository.save(pacienteExistente);
    }


    @Override
    public void deletePersona(Long idPersona) {
        pacienteRepository.deleteByIdAllIgnoreCase(idPersona);

    }
}
