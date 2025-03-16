/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.InscripcionDetalle;
import um.facultad.rest.model.pk.InscripcionDetallePk;

/**
 * @author daniel
 *
 */
@Repository
public interface InscripcionDetalleRepository extends JpaRepository<InscripcionDetalle, InscripcionDetallePk> {

	public List<InscripcionDetalle> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(BigDecimal personaId,
			Integer documentoId, Integer facultadId, Integer lectivoId);

}
