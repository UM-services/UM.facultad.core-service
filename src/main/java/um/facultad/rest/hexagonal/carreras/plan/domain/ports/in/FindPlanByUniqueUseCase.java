package um.facultad.rest.hexagonal.carreras.plan.domain.ports.in;

import java.util.Optional;

import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;

public interface FindPlanByUniqueUseCase {

    Optional<Plan> findByUnique(Integer facultadId, Integer planId);

}
