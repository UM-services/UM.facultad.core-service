package um.facultad.rest.hexagonal.personas.domicilio.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.AddDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.TesoreriaSincronizePort;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class AddDomicilioUseCaseImpl implements AddDomicilioUseCase {

    private final DomicilioRepository domicilioRepository;
    private final TesoreriaSincronizePort tesoreriaSincronizePort;

    @Override
    public Domicilio add(Domicilio domicilio, Boolean sincronize) {
        domicilio.setFecha(OffsetDateTime.now());
        domicilioRepository.save(domicilio);
        if (Boolean.TRUE.equals(sincronize)) {
            tesoreriaSincronizePort.sincronize(domicilio);
        }
        return domicilio;
    }

}
