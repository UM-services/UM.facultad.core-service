package um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.dto.MateriaResponse;

@Component
public class MateriaDtoMapper {

    public MateriaResponse toResponse(Materia domain) {
        if (domain == null) return null;
        var builder = MateriaResponse.builder()
                .facultadId(domain.getFacultadId())
                .planId(domain.getPlanId())
                .materiaId(domain.getMateriaId())
                .catedraId(domain.getCatedraId())
                .materiaIdReal(domain.getMateriaIdReal())
                .planNombre(domain.getPlan() != null ? domain.getPlan().getNombre() : null);
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

}
