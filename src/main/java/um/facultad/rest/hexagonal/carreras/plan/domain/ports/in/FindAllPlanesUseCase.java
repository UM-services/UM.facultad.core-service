package um.facultad.rest.hexagonal.carreras.plan.domain.ports.in;

import java.util.List;

import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;

public interface FindAllPlanesUseCase {

    List<Plan> findAll();

}
