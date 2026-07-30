package um.facultad.rest.hexagonal.carreras.plan.domain.ports.out;

import java.util.List;
import java.util.Optional;

import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;

public interface PlanRepository {

    List<Plan> findAll();

    Optional<Plan> findByUnique(Integer facultadId, Integer planId);

}
