package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.entity.CarreraEntity;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Component
public class CarreraMapper {

    public CarreraEntity toEntity(Carrera domain) {
        if (domain == null) return null;
        CarreraEntity.CarreraEntityBuilder builder = CarreraEntity.builder()
                .uniqueId(null)
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .carreraId(domain.getCarreraId())
                .bloqueId(domain.getBloqueId())
                .plan(toPlanEntity(domain.getPlan()));
        if (domain.getNombre() != null) builder.nombre(domain.getNombre());
        if (domain.getIniciales() != null) builder.iniciales(domain.getIniciales());
        if (domain.getTitulo() != null) builder.titulo(domain.getTitulo());
        if (domain.getTrabajoFinal() != null) builder.trabajoFinal(domain.getTrabajoFinal());
        if (domain.getResolucion() != null) builder.resolucion(domain.getResolucion());
        if (domain.getChequeraUnica() != null) builder.chequeraUnica(domain.getChequeraUnica());
        if (domain.getObligatorias() != null) builder.obligatorias(domain.getObligatorias());
        if (domain.getOptativas() != null) builder.optativas(domain.getOptativas());
        if (domain.getVigente() != null) builder.vigente(domain.getVigente());
        return builder.build();
    }

    public Carrera toDomain(CarreraEntity entity) {
        if (entity == null) return null;
        Carrera.CarreraBuilder builder = Carrera.builder()
                .facultadId(entity.getFacultadId())
                .planId(entity.getPlanId())
                .carreraId(entity.getCarreraId())
                .bloqueId(entity.getBloqueId())
                .plan(toPlan(entity.getPlan()));
        if (entity.getNombre() != null) builder.nombre(entity.getNombre());
        if (entity.getIniciales() != null) builder.iniciales(entity.getIniciales());
        if (entity.getTitulo() != null) builder.titulo(entity.getTitulo());
        if (entity.getTrabajoFinal() != null) builder.trabajoFinal(entity.getTrabajoFinal());
        if (entity.getResolucion() != null) builder.resolucion(entity.getResolucion());
        if (entity.getChequeraUnica() != null) builder.chequeraUnica(entity.getChequeraUnica());
        if (entity.getObligatorias() != null) builder.obligatorias(entity.getObligatorias());
        if (entity.getOptativas() != null) builder.optativas(entity.getOptativas());
        if (entity.getVigente() != null) builder.vigente(entity.getVigente());
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
