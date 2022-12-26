/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.InscripcionPago;

/**
 * @author daniel
 *
 */
@Repository
public interface IInscripcionPagoRepository extends JpaRepository<InscripcionPago, Long> {

	public Optional<InscripcionPago> findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(BigDecimal personaId,
			Integer documentoId);

}
