package um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Materia;
import um.facultad.rest.model.MateriaEntity;

@Component
@RequiredArgsConstructor
public class MateriaMapper {

    private final PlanMapper planMapper;

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
