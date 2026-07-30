package um.facultad.rest.hexagonal.carreras.carrera.domain.ports.out;

import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;

import java.util.List;
import java.util.Optional;

public interface CarreraRepository {
    List<Carrera> findAll();

    Optional<Carrera> findByUnique(Integer facultadId, Integer planId, Integer carreraId);
}
