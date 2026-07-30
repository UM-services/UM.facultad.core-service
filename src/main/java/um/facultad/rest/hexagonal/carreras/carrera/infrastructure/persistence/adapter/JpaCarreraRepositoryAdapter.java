package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.carrera.domain.model.Carrera;
import um.facultad.rest.hexagonal.carreras.carrera.domain.ports.out.CarreraRepository;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.mapper.CarreraMapper;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.repository.JpaCarreraRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaCarreraRepositoryAdapter implements CarreraRepository {

    private final JpaCarreraRepository jpaCarreraRepository;
    private final CarreraMapper carreraMapper;

    @Override
    public List<Carrera> findAll() {
        return jpaCarreraRepository.findAll().stream()
                .map(carreraMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Carrera> findByUnique(Integer facultadId, Integer planId, Integer carreraId) {
        return jpaCarreraRepository.findByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId)
                .map(carreraMapper::toDomain);
    }
}
