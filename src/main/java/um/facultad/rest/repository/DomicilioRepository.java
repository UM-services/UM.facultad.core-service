/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.DomicilioEntity;
import um.facultad.rest.model.pk.DomicilioPk;

/**
 * @author daniel
 *
 */
@Repository
public interface DomicilioRepository extends JpaRepository<DomicilioEntity, DomicilioPk> {

	public Optional<DomicilioEntity> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
