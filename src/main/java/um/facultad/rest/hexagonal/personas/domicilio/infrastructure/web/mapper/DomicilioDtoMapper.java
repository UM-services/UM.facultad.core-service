package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.dto.DomicilioRequest;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.dto.DomicilioResponse;

@Component
public class DomicilioDtoMapper {

    public Domicilio toDomain(DomicilioRequest request) {
        if (request == null) return null;
        var builder = Domicilio.builder()
                .personaId(request.getPersonaId())
                .documentoId(request.getDocumentoId())
                .domicilioId(request.getDomicilioId())
                .facultadId(request.getFacultadId())
                .provinciaId(request.getProvinciaId())
                .localidadId(request.getLocalidadId());
        if (request.getFecha() != null) builder.fecha(request.getFecha());
        if (request.getCalle() != null) builder.calle(request.getCalle());
        if (request.getPuerta() != null) builder.puerta(request.getPuerta());
        if (request.getPiso() != null) builder.piso(request.getPiso());
        if (request.getDpto() != null) builder.dpto(request.getDpto());
        if (request.getTelefono() != null) builder.telefono(request.getTelefono());
        if (request.getMovil() != null) builder.movil(request.getMovil());
        if (request.getObservaciones() != null) builder.observaciones(request.getObservaciones());
        if (request.getCodigoPostal() != null) builder.codigoPostal(request.getCodigoPostal());
        if (request.getEmailPersonal() != null) builder.emailPersonal(request.getEmailPersonal());
        if (request.getEmailInstitucional() != null) builder.emailInstitucional(request.getEmailInstitucional());
        if (request.getLaboral() != null) builder.laboral(request.getLaboral());
        return builder.build();
    }

    public DomicilioResponse toResponse(Domicilio domain) {
        if (domain == null) return null;
        var builder = DomicilioResponse.builder()
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

}
