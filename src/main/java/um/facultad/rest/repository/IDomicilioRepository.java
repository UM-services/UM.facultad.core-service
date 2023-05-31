/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Domicilio;
import um.facultad.rest.model.pk.DomicilioPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, DomicilioPk> {

	public Optional<Domicilio> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
