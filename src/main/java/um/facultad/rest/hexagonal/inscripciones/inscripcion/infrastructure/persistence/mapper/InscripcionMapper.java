package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity.InscripcionEntity;

@Component
public class InscripcionMapper {

    public InscripcionEntity toEntity(Inscripcion domain) {
        if (domain == null) return null;
        return InscripcionEntity.builder()
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

    public Inscripcion toDomain(InscripcionEntity entity) {
        if (entity == null) return null;
        var builder = Inscripcion.builder()
                .facultadId(entity.getFacultadId())
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .lectivoId(entity.getLectivoId())
                .inscripcionId(entity.getInscripcionId())
                .fecha(entity.getFecha())
                .planId(entity.getPlanId())
                .carreraId(entity.getCarreraId())
                .geograficaId(entity.getGeograficaId())
                .divisionId(entity.getDivisionId());
        if (entity.getChequera() != null) builder.chequera(entity.getChequera());
        if (entity.getMatricula() != null) builder.matricula(entity.getMatricula());
        if (entity.getFactura() != null) builder.factura(entity.getFactura());
        if (entity.getCurso() != null) builder.curso(entity.getCurso());
        if (entity.getAsentado() != null) builder.asentado(entity.getAsentado());
        if (entity.getProvisoria() != null) builder.provisoria(entity.getProvisoria());
        if (entity.getCohorte() != null) builder.cohorte(entity.getCohorte());
        if (entity.getRemota() != null) builder.remota(entity.getRemota());
        if (entity.getImprimir() != null) builder.imprimir(entity.getImprimir());
        if (entity.getEdad() != null) builder.edad(entity.getEdad());
        if (entity.getObservaciones() != null) builder.observaciones(entity.getObservaciones());
        if (entity.getOffsetpago() != null) builder.offsetpago(entity.getOffsetpago());
        if (entity.getLibre() != null) builder.libre(entity.getLibre());
        if (entity.getDebematricula() != null) builder.debematricula(entity.getDebematricula());
        return builder.build();
    }

}
