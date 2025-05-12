package com.example.CrudJPAHibernateTodoCode.repository;

import com.example.CrudJPAHibernateTodoCode.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNombreLikeIgnoreCase(String nombre);

    @Override
    List<Paciente> findAll();

    @Override
    <S extends Paciente> S save(S entity);

    @Override
    Optional<Paciente> findById(Long id);

    Optional<Paciente> findByDni(String dni);

    long deleteByIdAllIgnoreCase(Long id);


}
