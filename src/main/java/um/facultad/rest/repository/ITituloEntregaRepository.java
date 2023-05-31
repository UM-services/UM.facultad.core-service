/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.TituloEntrega;
import um.facultad.rest.model.pk.TituloEntregaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface ITituloEntregaRepository extends JpaRepository<TituloEntrega, TituloEntregaPk> {

	public Optional<TituloEntrega> findByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndCarreraId(BigDecimal personaId,
			Integer documentoId, Integer facultadId, Integer planId, Integer carreraId);

}
