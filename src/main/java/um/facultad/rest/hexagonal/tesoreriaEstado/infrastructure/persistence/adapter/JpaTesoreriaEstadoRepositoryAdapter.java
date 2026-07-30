package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.ports.out.TesoreriaEstadoRepository;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.mapper.TesoreriaEstadoMapper;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.repository.JpaTesoreriaEstadoRepository;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaTesoreriaEstadoRepositoryAdapter implements TesoreriaEstadoRepository {

    private final JpaTesoreriaEstadoRepository jpaTesoreriaEstadoRepository;
    private final TesoreriaEstadoMapper tesoreriaEstadoMapper;

    @Override
    public Optional<TesoreriaEstado> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId) {
        return jpaTesoreriaEstadoRepository.findByFacultadIdAndPersonaIdAndDocumentoId(facultadId, personaId, documentoId)
                .map(tesoreriaEstadoMapper::toDomain);
    }
}
