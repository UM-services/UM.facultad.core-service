package um.facultad.rest.hexagonal.personas.domicilio.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.UpdateDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.TesoreriaSincronizePort;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateDomicilioUseCaseImpl implements UpdateDomicilioUseCase {

    private final DomicilioRepository domicilioRepository;
    private final TesoreriaSincronizePort tesoreriaSincronizePort;

    @Override
    public Optional<Domicilio> update(Domicilio domicilio, BigDecimal personaId, Integer documentoId, Boolean sincronize) {
        Optional<Domicilio> existing = domicilioRepository.findByPersonaIdAndDocumentoId(personaId, documentoId);
        if (existing.isEmpty()) {
            return Optional.empty();
        }
        Domicilio current = existing.get();
        current.setCalle(domicilio.getCalle());
        current.setPuerta(domicilio.getPuerta());
        current.setPiso(domicilio.getPiso());
        current.setDpto(domicilio.getDpto());
        current.setTelefono(domicilio.getTelefono());
        current.setMovil(domicilio.getMovil());
        current.setObservaciones(domicilio.getObservaciones());
        current.setCodigoPostal(domicilio.getCodigoPostal());
        current.setProvinciaId(domicilio.getProvinciaId());
        current.setFacultadId(domicilio.getFacultadId());
        current.setLocalidadId(domicilio.getLocalidadId());
        current.setEmailPersonal(domicilio.getEmailPersonal());
        current.setEmailInstitucional(domicilio.getEmailInstitucional());
        current.setLaboral(domicilio.getLaboral());
        current.setFecha(OffsetDateTime.now());
        domicilioRepository.save(current);
        if (Boolean.TRUE.equals(sincronize)) {
            tesoreriaSincronizePort.sincronize(current);
        }
        return Optional.of(current);
    }

}
