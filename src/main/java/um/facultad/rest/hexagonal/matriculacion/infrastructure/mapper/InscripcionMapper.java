package um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;
import um.facultad.rest.model.CarreraEntity;
import um.facultad.rest.model.InscripcionEntity;
import um.facultad.rest.model.MateriaEntity;

import java.util.List;

@Component
public class InscripcionMapper {

    private final CarreraMapper carreraMapper;
    private final MateriaMapper materiaMapper;

    public InscripcionMapper(CarreraMapper carreraMapper, MateriaMapper materiaMapper) {
        this.carreraMapper = carreraMapper;
        this.materiaMapper = materiaMapper;
    }

    public Inscripcion toModel(InscripcionEntity inscripcionEntity, CarreraEntity carreraEntity, List<MateriaEntity> materiaEntityList) {
        if (inscripcionEntity == null) {
            return null;
        }
        return Inscripcion.builder()
                .fecha(inscripcionEntity.getFecha())
                .carrera(carreraMapper.toModel(carreraEntity))
                .materias(materiaEntityList.stream()
                        .map(materiaMapper::toModel)
                        .toList())
                .build();
    }

}
