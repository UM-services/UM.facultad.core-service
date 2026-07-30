package um.facultad.rest.hexagonal.carreras.materia.application.usecases;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.in.FindMateriaByUniqueUseCase;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.out.MateriaRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindMateriaByUniqueUseCaseImpl implements FindMateriaByUniqueUseCase {

    private final MateriaRepository materiaRepository;

    @Override
    public Optional<Materia> findByUnique(Integer facultadId, Integer planId, String materiaId) {
        return materiaRepository.findByUnique(facultadId, planId, materiaId);
    }

}
