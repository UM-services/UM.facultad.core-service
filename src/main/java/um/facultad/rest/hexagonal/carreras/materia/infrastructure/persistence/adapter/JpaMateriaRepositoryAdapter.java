package um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.materia.domain.model.Materia;
import um.facultad.rest.hexagonal.carreras.materia.domain.ports.out.MateriaRepository;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.mapper.MateriaMapper;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.repository.JpaMateriaRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaMateriaRepositoryAdapter implements MateriaRepository {

    private final JpaMateriaRepository jpaMateriaRepository;
    private final MateriaMapper materiaMapper;

    @Override
    public List<Materia> findAllByPlan(Integer facultadId, Integer planId) {
        return jpaMateriaRepository.findAllByFacultadIdAndPlanId(facultadId, planId).stream()
                .map(materiaMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Materia> findByUnique(Integer facultadId, Integer planId, String materiaId) {
        return jpaMateriaRepository.findByFacultadIdAndPlanIdAndMateriaId(facultadId, planId, materiaId)
                .map(materiaMapper::toDomain);
    }

}
