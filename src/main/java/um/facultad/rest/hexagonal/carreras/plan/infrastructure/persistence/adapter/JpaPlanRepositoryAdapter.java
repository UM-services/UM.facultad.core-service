package um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;
import um.facultad.rest.hexagonal.carreras.plan.domain.ports.out.PlanRepository;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.mapper.PlanMapper;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.repository.JpaPlanRepository;

@Component
@RequiredArgsConstructor
public class JpaPlanRepositoryAdapter implements PlanRepository {

    private final JpaPlanRepository jpaPlanRepository;
    private final PlanMapper planMapper;

    @Override
    public List<Plan> findAll() {
        return jpaPlanRepository.findAll().stream()
                .map(planMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Plan> findByUnique(Integer facultadId, Integer planId) {
        return jpaPlanRepository.findByFacultadIdAndPlanId(facultadId, planId)
                .map(planMapper::toDomain);
    }

}
