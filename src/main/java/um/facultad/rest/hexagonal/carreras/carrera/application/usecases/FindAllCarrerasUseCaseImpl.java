package um.facultad.rest.hexagonal.carreras.carrera.application.usecases;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.in.FindAllCarrerasUseCase;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.out.CarreraRepository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllCarrerasUseCaseImpl implements FindAllCarrerasUseCase {

    private final CarreraRepository carreraRepository;

    @Override
    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }
}
