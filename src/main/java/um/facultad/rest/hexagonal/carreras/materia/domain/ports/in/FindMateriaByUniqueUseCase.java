package um.facultad.rest.hexagonal.carreras.materia.domain.ports.in;

import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;

import java.util.Optional;

public interface FindMateriaByUniqueUseCase {

    Optional<Materia> findByUnique(Integer facultadId, Integer planId, String materiaId);

}
