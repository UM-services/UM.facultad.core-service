/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Nacimiento;
import ar.edu.um.facultad.rest.model.pk.NacimientoPk;

/**
 * @author daniel
 *
 */
@Repository
public interface INacimientoRepository extends JpaRepository<Nacimiento, NacimientoPk> {

	public Optional<Nacimiento> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
