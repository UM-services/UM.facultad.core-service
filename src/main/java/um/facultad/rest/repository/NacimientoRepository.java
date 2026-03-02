/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.NacimientoEntity;
import um.facultad.rest.model.pk.NacimientoPk;

/**
 * @author daniel
 *
 */
@Repository
public interface NacimientoRepository extends JpaRepository<NacimientoEntity, NacimientoPk> {

	public Optional<NacimientoEntity> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
