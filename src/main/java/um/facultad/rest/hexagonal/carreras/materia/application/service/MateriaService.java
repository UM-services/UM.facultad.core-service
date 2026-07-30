package um.facultad.rest.hexagonal.carreras.materia.application.service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.application.exception.MateriaException;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.in.FindAllMateriasByPlanUseCase;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.in.FindMateriaByUniqueUseCase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaService {

    private final FindAllMateriasByPlanUseCase findAllMateriasByPlanUseCase;
    private final FindMateriaByUniqueUseCase findMateriaByUniqueUseCase;

    public List<Materia> findAllByPlan(Integer facultadId, Integer planId) {
        return findAllMateriasByPlanUseCase.findAllByPlan(facultadId, planId);
    }

    public Materia findByUnique(Integer facultadId, Integer planId, String materiaId) {
        return findMateriaByUniqueUseCase.findByUnique(facultadId, planId, materiaId)
                .orElseThrow(() -> new MateriaException(facultadId, planId, materiaId));
    }

}
