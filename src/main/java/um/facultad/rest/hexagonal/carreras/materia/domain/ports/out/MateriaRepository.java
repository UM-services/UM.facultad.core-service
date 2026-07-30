package um.facultad.rest.hexagonal.carreras.materia.domain.ports.out;

import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaRepository {

    List<Materia> findAllByPlan(Integer facultadId, Integer planId);

    Optional<Materia> findByUnique(Integer facultadId, Integer planId, String materiaId);

}
