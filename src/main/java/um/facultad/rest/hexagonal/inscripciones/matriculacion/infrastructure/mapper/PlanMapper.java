package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Component("matriculacionPlanMapper")
public class PlanMapper {

    public Plan toModel(PlanEntity planEntity) {
        if (planEntity == null) {
            return null;
        }
        return Plan.builder()
                .planId(planEntity.getPlanId())
                .nombre(planEntity.getNombre())
                .build();
    }

}
