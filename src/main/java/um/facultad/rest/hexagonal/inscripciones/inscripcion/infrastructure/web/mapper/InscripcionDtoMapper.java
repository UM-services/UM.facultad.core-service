package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.dto.InscripcionResponse;

@Component
public class InscripcionDtoMapper {

    public InscripcionResponse toResponse(Inscripcion domain) {
        if (domain == null) return null;
        return InscripcionResponse.builder()
                .facultadId(domain.getFacultadId())
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .lectivoId(domain.getLectivoId())
                .inscripcionId(domain.getInscripcionId())
                .fecha(domain.getFecha())
                .chequera(domain.getChequera())
                .matricula(domain.getMatricula())
                .factura(domain.getFactura())
                .curso(domain.getCurso())
                .planId(domain.getPlanId())
                .carreraId(domain.getCarreraId())
                .geograficaId(domain.getGeograficaId())
                .asentado(domain.getAsentado())
                .provisoria(domain.getProvisoria())
                .cohorte(domain.getCohorte())
                .remota(domain.getRemota())
                .imprimir(domain.getImprimir())
                .edad(domain.getEdad())
                .observaciones(domain.getObservaciones())
                .offsetpago(domain.getOffsetpago())
                .libre(domain.getLibre())
                .divisionId(domain.getDivisionId())
                .debematricula(domain.getDebematricula())
                .build();
    }

}
