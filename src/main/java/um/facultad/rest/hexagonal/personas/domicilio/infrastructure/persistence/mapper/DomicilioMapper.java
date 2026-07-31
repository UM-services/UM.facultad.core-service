package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.entity.DomicilioEntity;

@Component
public class DomicilioMapper {

    public DomicilioEntity toEntity(Domicilio domain) {
        if (domain == null) return null;
        var builder = DomicilioEntity.builder()
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .domicilioId(domain.getDomicilioId())
                .facultadId(domain.getFacultadId())
                .provinciaId(domain.getProvinciaId())
                .localidadId(domain.getLocalidadId());
        if (domain.getFecha() != null) builder.fecha(domain.getFecha());
        if (domain.getCalle() != null) builder.calle(domain.getCalle());
        if (domain.getPuerta() != null) builder.puerta(domain.getPuerta());
        if (domain.getPiso() != null) builder.piso(domain.getPiso());
        if (domain.getDpto() != null) builder.dpto(domain.getDpto());
        if (domain.getTelefono() != null) builder.telefono(domain.getTelefono());
        if (domain.getMovil() != null) builder.movil(domain.getMovil());
        if (domain.getObservaciones() != null) builder.observaciones(domain.getObservaciones());
        if (domain.getCodigoPostal() != null) builder.codigoPostal(domain.getCodigoPostal());
        if (domain.getEmailPersonal() != null) builder.emailPersonal(domain.getEmailPersonal());
        if (domain.getEmailInstitucional() != null) builder.emailInstitucional(domain.getEmailInstitucional());
        if (domain.getLaboral() != null) builder.laboral(domain.getLaboral());
        return builder.build();
    }

    public Domicilio toDomain(DomicilioEntity entity) {
        if (entity == null) return null;
        var builder = Domicilio.builder()
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .domicilioId(entity.getDomicilioId())
                .facultadId(entity.getFacultadId())
                .provinciaId(entity.getProvinciaId())
                .localidadId(entity.getLocalidadId());
        if (entity.getFecha() != null) builder.fecha(entity.getFecha());
        if (entity.getCalle() != null) builder.calle(entity.getCalle());
        if (entity.getPuerta() != null) builder.puerta(entity.getPuerta());
        if (entity.getPiso() != null) builder.piso(entity.getPiso());
        if (entity.getDpto() != null) builder.dpto(entity.getDpto());
        if (entity.getTelefono() != null) builder.telefono(entity.getTelefono());
        if (entity.getMovil() != null) builder.movil(entity.getMovil());
        if (entity.getObservaciones() != null) builder.observaciones(entity.getObservaciones());
        if (entity.getCodigoPostal() != null) builder.codigoPostal(entity.getCodigoPostal());
        if (entity.getEmailPersonal() != null) builder.emailPersonal(entity.getEmailPersonal());
        if (entity.getEmailInstitucional() != null) builder.emailInstitucional(entity.getEmailInstitucional());
        if (entity.getLaboral() != null) builder.laboral(entity.getLaboral());
        return builder.build();
    }

}
