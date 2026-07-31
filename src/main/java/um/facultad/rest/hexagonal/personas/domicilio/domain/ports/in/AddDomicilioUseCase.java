package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

public interface AddDomicilioUseCase {

    Domicilio add(Domicilio domicilio, Boolean sincronize);

}
