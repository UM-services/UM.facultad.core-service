package um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.mapper;

import org.springframework.stereotype.Component;

import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.dto.PlanResponse;

@Component
public class PlanDtoMapper {

    public PlanResponse toResponse(Plan domain) {
        if (domain == null)
            return null;
        var builder = PlanResponse.builder()
                .uniqueId(domain.getUniqueId())
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .nombre(domain.getNombre())
                .fecha(domain.getFecha());
        if (domain.getPublicar() != null)
            builder.publicar(domain.getPublicar());
        if (domain.getSemanas() != null)
            builder.semanas(domain.getSemanas());
        return builder.build();
    }

}
