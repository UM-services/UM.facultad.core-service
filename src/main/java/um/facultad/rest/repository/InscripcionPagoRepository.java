/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.InscripcionPago;

/**
 * @author daniel
 *
 */
@Repository
public interface InscripcionPagoRepository extends JpaRepository<InscripcionPago, Long> {

	public Optional<InscripcionPago> findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(BigDecimal personaId,
			Integer documentoId);

}
