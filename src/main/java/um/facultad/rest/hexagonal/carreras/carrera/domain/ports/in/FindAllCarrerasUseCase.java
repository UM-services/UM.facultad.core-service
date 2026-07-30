package um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in;

import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;

import java.util.List;

public interface FindAllCarrerasUseCase {
    List<Carrera> findAll();
}
