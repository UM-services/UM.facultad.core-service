package um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Component
public class PlanMapper {

    public PlanEntity toEntity(Plan domain) {
        if (domain == null)
            return null;
        var builder = PlanEntity.builder()
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

    public Plan toDomain(PlanEntity entity) {
        if (entity == null)
            return null;
        var builder = Plan.builder()
                .uniqueId(entity.getUniqueId())
                .facultadId(entity.getFacultadId())
                .planId(entity.getPlanId())
                .nombre(entity.getNombre())
                .fecha(entity.getFecha());
        if (entity.getPublicar() != null)
            builder.publicar(entity.getPublicar());
        if (entity.getSemanas() != null)
            builder.semanas(entity.getSemanas());
        return builder.build();
    }

}
