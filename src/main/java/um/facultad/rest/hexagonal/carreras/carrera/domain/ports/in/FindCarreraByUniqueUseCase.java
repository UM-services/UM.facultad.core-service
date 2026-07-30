package um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in;

import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;

import java.util.Optional;

public interface FindCarreraByUniqueUseCase {
    Optional<Carrera> findByUnique(Integer facultadId, Integer planId, Integer carreraId);
}
