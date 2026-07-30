package um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.entity.MateriaEntity;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Component
public class MateriaMapper {

    public MateriaEntity toEntity(Materia domain) {
        if (domain == null) return null;
        var builder = MateriaEntity.builder()
                .uniqueId(null)
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .materiaId(domain.getMateriaId())
                .catedraId(domain.getCatedraId())
                .materiaIdReal(domain.getMateriaIdReal())
                .plan(toPlanEntity(domain.getPlan()));
        if (domain.getNombre() != null) builder.nombre(domain.getNombre());
        if (domain.getOptativa() != null) builder.optativa(domain.getOptativa());
        if (domain.getVirtual() != null) builder.virtual(domain.getVirtual());
        if (domain.getDias() != null) builder.dias(domain.getDias());
        if (domain.getPeriodoId() != null) builder.periodoId(domain.getPeriodoId());
        if (domain.getEspecial() != null) builder.especial(domain.getEspecial());
        if (domain.getTaller() != null) builder.taller(domain.getTaller());
        if (domain.getSoloAnalitico() != null) builder.soloAnalitico(domain.getSoloAnalitico());
        if (domain.getCurso() != null) builder.curso(domain.getCurso());
        return builder.build();
    }

    public Materia toDomain(MateriaEntity entity) {
        if (entity == null) return null;
        var builder = Materia.builder()
                .facultadId(entity.getFacultadId())
                .planId(entity.getPlanId())
                .materiaId(entity.getMateriaId())
                .catedraId(entity.getCatedraId())
                .materiaIdReal(entity.getMateriaIdReal())
                .plan(toPlan(entity.getPlan()));
        if (entity.getNombre() != null) builder.nombre(entity.getNombre());
        if (entity.getOptativa() != null) builder.optativa(entity.getOptativa());
        if (entity.getVirtual() != null) builder.virtual(entity.getVirtual());
        if (entity.getDias() != null) builder.dias(entity.getDias());
        if (entity.getPeriodoId() != null) builder.periodoId(entity.getPeriodoId());
        if (entity.getEspecial() != null) builder.especial(entity.getEspecial());
        if (entity.getTaller() != null) builder.taller(entity.getTaller());
        if (entity.getSoloAnalitico() != null) builder.soloAnalitico(entity.getSoloAnalitico());
        if (entity.getCurso() != null) builder.curso(entity.getCurso());
        return builder.build();
    }

    private PlanEntity toPlanEntity(Plan domain) {
        if (domain == null) return null;
        PlanEntity entity = new PlanEntity();
        entity.setPlanId(domain.getPlanId());
        entity.setNombre(domain.getNombre());
        return entity;
    }

    private Plan toPlan(PlanEntity entity) {
        if (entity == null) return null;
        return Plan.builder()
                .planId(entity.getPlanId())
                .nombre(entity.getNombre())
                .build();
    }

}
