package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.entity.TesoreriaEstadoEntity;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface JpaTesoreriaEstadoRepository extends JpaRepository<TesoreriaEstadoEntity, Long> {

    Optional<TesoreriaEstadoEntity> findByFacultadIdAndPersonaIdAndDocumentoId(Integer facultadId, BigDecimal personaId, Integer documentoId);
}
