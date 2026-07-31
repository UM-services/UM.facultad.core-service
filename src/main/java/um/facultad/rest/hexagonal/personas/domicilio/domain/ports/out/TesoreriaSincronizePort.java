package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

public interface TesoreriaSincronizePort {

    void sincronize(Domicilio domicilio);

}
