package um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Plan;
import um.facultad.rest.model.PlanEntity;

@Component
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
