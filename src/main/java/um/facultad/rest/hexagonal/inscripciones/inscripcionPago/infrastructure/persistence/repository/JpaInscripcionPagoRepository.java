/**
 * 
 */
package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.entity.InscripcionPagoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface JpaInscripcionPagoRepository extends JpaRepository<InscripcionPagoEntity, Long> {

	Optional<InscripcionPagoEntity> findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(BigDecimal personaId,
                                                                                         Integer documentoId);

    Optional<InscripcionPagoEntity> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
