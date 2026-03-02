package um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Carrera;
import um.facultad.rest.model.CarreraEntity;

@Component
public class CarreraMapper {

    private final PlanMapper planMapper;

    public CarreraMapper(PlanMapper planMapper) {
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
