package um.facultad.rest.hexagonal.carreras.carrera.application.service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.carrera.application.exception.CarreraException;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in.FindAllCarrerasUseCase;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in.FindCarreraByUniqueUseCase;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final FindAllCarrerasUseCase findAllCarrerasUseCase;
    private final FindCarreraByUniqueUseCase findCarreraByUniqueUseCase;

    public List<Carrera> findAll() {
        return findAllCarrerasUseCase.findAll();
    }

    public Carrera findByUnique(Integer facultadId, Integer planId, Integer carreraId) {
        return findCarreraByUniqueUseCase.findByUnique(facultadId, planId, carreraId)
                .orElseThrow(() -> new CarreraException(facultadId, planId, carreraId));
    }

}
