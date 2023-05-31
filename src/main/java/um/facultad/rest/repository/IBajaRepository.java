/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Baja;
import um.facultad.rest.model.pk.BajaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IBajaRepository extends JpaRepository<Baja, BajaPk> {

	public Optional<Baja> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId,
			Integer documentoId, Integer lectivoId);

}
