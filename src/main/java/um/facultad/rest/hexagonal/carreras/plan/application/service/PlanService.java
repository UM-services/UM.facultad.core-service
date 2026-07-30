package um.facultad.rest.hexagonal.carreras.plan.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.plan.application.exception.PlanException;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.in.FindAllPlanesUseCase;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.in.FindPlanByUniqueUseCase;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final FindAllPlanesUseCase findAllPlanesUseCase;
    private final FindPlanByUniqueUseCase findPlanByUniqueUseCase;

    public List<Plan> findAll() {
        return findAllPlanesUseCase.findAll();
    }

    public Plan findByUnique(Integer facultadId, Integer planId) {
        return findPlanByUniqueUseCase.findByUnique(facultadId, planId)
                .orElseThrow(() -> new PlanException(facultadId, planId));
    }

}
