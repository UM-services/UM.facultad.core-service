package um.facultad.rest.hexagonal.carreras.carrera.application.usecases;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in.FindCarreraByUniqueUseCase;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.out.CarreraRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCarreraByUniqueUseCaseImpl implements FindCarreraByUniqueUseCase {

    private final CarreraRepository carreraRepository;

    @Override
    public Optional<Carrera> findByUnique(Integer facultadId, Integer planId, Integer carreraId) {
        return carreraRepository.findByUnique(facultadId, planId, carreraId);
    }
}
