package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

public interface SincronizeDomicilioUseCase {

    Domicilio sincronize(Domicilio domicilio);

}
