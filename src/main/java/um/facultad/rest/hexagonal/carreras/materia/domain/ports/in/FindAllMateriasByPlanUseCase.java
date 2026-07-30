package um.facultad.rest.hexagonal.carreras.materia.domain.ports.in;

import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;

import java.util.List;

public interface FindAllMateriasByPlanUseCase {

    List<Materia> findAllByPlan(Integer facultadId, Integer planId);

}
