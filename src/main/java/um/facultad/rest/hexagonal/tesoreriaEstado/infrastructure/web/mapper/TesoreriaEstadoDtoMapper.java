package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.web.dto.TesoreriaEstadoResponse;

@Component
public class TesoreriaEstadoDtoMapper {

    public TesoreriaEstadoResponse toResponse(TesoreriaEstado domain) {
        if (domain == null) return null;
        TesoreriaEstadoResponse.TesoreriaEstadoResponseBuilder builder = TesoreriaEstadoResponse.builder()
                .tesoreriaEstadoId(domain.getTesoreriaEstadoId())
                .facultadId(domain.getFacultadId())
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .fechaTope(domain.getFechaTope());
        if (domain.getDeuda() != null) builder.deuda(domain.getDeuda());
        if (domain.getManual() != null) builder.manual(domain.getManual());
        if (domain.getImportado() != null) builder.importado(domain.getImportado());
        if (domain.getObservaciones() != null) builder.observaciones(domain.getObservaciones());
        if (domain.getUuid() != null) builder.uuid(domain.getUuid());
        return builder.build();
    }
}
