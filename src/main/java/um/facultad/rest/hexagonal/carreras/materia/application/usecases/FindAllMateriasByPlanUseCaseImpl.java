package um.facultad.rest.hexagonal.carreras.materia.application.usecases;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.in.FindAllMateriasByPlanUseCase;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.out.MateriaRepository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllMateriasByPlanUseCaseImpl implements FindAllMateriasByPlanUseCase {

    private final MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAllByPlan(Integer facultadId, Integer planId) {
        return materiaRepository.findAllByPlan(facultadId, planId);
    }

}
