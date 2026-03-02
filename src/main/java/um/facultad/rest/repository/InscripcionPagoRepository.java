/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.InscripcionPagoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface InscripcionPagoRepository extends JpaRepository<InscripcionPagoEntity, Long> {

	Optional<InscripcionPagoEntity> findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(BigDecimal personaId,
                                                                                         Integer documentoId);

    Optional<InscripcionPagoEntity> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
