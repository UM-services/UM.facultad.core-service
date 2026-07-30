package um.facultad.rest.hexagonal.carreras.plan.application.usecases;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.in.FindAllPlanesUseCase;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.out.PlanRepository;

@Component
@RequiredArgsConstructor
public class FindAllPlanesUseCaseImpl implements FindAllPlanesUseCase {

    private final PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

}
