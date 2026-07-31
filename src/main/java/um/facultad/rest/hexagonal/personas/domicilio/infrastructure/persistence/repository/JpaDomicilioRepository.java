/**
 * 
 */
package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.entity.DomicilioEntity;
import um.facultad.rest.model.pk.DomicilioPk;

/**
 * @author daniel
 *
 */
@Repository
public interface JpaDomicilioRepository extends JpaRepository<DomicilioEntity, DomicilioPk> {

	public Optional<DomicilioEntity> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
