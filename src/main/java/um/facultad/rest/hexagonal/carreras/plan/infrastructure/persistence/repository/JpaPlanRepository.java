package um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Repository
public interface JpaPlanRepository extends JpaRepository<PlanEntity, Long> {

    Optional<PlanEntity> findByFacultadIdAndPlanId(Integer facultadId, Integer planId);

}
