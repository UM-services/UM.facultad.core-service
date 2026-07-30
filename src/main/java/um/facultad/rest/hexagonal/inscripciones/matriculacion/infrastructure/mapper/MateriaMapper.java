package um.facultad.rest.hexagonal.inscripciones.matriculacion.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.entity.MateriaEntity;

@Component("matriculacionMateriaMapper")
public class MateriaMapper {

    private final PlanMapper planMapper;

    @Autowired
    public MateriaMapper(@Qualifier("matriculacionPlanMapper") PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    public Materia toModel(MateriaEntity materiaEntity) {
        if (materiaEntity == null) {
            return null;
        }
        return Materia.builder()
                .plan(planMapper.toModel(materiaEntity.getPlan()))
                .materiaId(materiaEntity.getMateriaId())
                .nombre(materiaEntity.getNombre())
                .build();
    }

}
