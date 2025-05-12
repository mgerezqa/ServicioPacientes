package com.example.CrudJPAHibernateTodoCode.controller;

import com.example.CrudJPAHibernateTodoCode.domain.Paciente;
import com.example.CrudJPAHibernateTodoCode.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService iPacienteService;

    @GetMapping("/pacientes/get")
    public List<Paciente> getPacientes() {
        return iPacienteService.getPersonas();
    }

    @GetMapping("/paciente/traerPorId/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {return  iPacienteService.findPersona(id);}


    @GetMapping("/paciente/traerPorDni/{dni}")
    public Paciente getPacientesByDni(@PathVariable String dni) {return  iPacienteService.findPersonaPorDni(dni);}

    @PostMapping("/pacientes/post")
    public String postPaciente(@RequestBody Paciente paciente) {
        iPacienteService.savePersona(paciente);
        return "La persona se ha creado correctamente";
    }

    @DeleteMapping("/pacientes/borrar/{id}")
    public String borrarPaciente(@PathVariable Long id) {
        iPacienteService.deletePersona(id);
        return "La persona se ha borrado correctamente";
    }

//    @PutMapping("/pacientes/editar/{id_original}")
//    public Paciente editPaciente(@PathVariable Long id_original,
//                                 @RequestParam (required = false, name = "id") Long nuevaId,
//                                 @RequestParam (required = false, name = "nombre") String nombre,
//                                 @RequestParam (required = false, name = "apellido") String apellido,
//                                 @RequestParam (required = false, name = "dni") String dni,
//                                 @RequestParam (required = false, name = "fechaNacimiento") LocalDate fechaNacimiento) {
//
//        iPacienteService.updatePersona(id_original, nuevaId, nombre, apellido, dni, fechaNacimiento);
//        Paciente paciente = iPacienteService.findPersona(id_original);
//        return paciente;
//
//    }

    @PutMapping("/pacientes/editar/{id_original}")
    public ResponseEntity<?> editPaciente(
            @PathVariable Long id_original,
            @RequestBody Paciente pacienteActualizado) {

        // Verificar que el ID en el path coincide con el ID en el body (si lo incluyes)
        if (pacienteActualizado.getId() != null && !id_original.equals(pacienteActualizado.getId())) {
            return ResponseEntity.badRequest().body("El ID en la URL no coincide con el ID del paciente");
        }

        // Actualizar el paciente
        Paciente pacienteActualizadoObj = iPacienteService.updatePersona(id_original, pacienteActualizado);

        return ResponseEntity.ok(pacienteActualizadoObj);
    }

}
