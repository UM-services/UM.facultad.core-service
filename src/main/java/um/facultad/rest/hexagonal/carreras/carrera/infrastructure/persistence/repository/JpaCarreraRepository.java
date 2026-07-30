package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.entity.CarreraEntity;

import java.util.Optional;

@Repository
public interface JpaCarreraRepository extends JpaRepository<CarreraEntity, Long> {

    Optional<CarreraEntity> findByFacultadIdAndPlanIdAndCarreraId(Integer facultadId, Integer planId, Integer carreraId);
}
