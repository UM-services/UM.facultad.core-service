package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.entity.CarreraEntity;

@Component("matriculacionCarreraMapper")
public class CarreraMapper {

    private final PlanMapper planMapper;

    public CarreraMapper(@Qualifier("matriculacionPlanMapper") PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    public Carrera toModel(CarreraEntity carreraEntity) {
        if (carreraEntity == null) {
            return null;
        }
        return Carrera.builder()
                .plan(planMapper.toModel(carreraEntity.getPlan()))
                .carreraId(carreraEntity.getCarreraId())
                .nombre(carreraEntity.getNombre())
                .vigente(carreraEntity.getVigente())
                .build();
    }

}
