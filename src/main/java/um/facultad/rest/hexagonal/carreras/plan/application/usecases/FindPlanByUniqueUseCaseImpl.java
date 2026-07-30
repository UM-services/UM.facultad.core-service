package um.facultad.rest.hexagonal.carreras.plan.application.usecases;

import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.in.FindPlanByUniqueUseCase;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.out.PlanRepository;

@Component
@RequiredArgsConstructor
public class FindPlanByUniqueUseCaseImpl implements FindPlanByUniqueUseCase {

    private final PlanRepository planRepository;

    @Override
    public Optional<Plan> findByUnique(Integer facultadId, Integer planId) {
        return planRepository.findByUnique(facultadId, planId);
    }

}
