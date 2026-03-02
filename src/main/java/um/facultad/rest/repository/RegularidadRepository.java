/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.RegularidadEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface RegularidadRepository extends JpaRepository<RegularidadEntity, Long> {

	public List<RegularidadEntity> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdInOrderByFechaDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId, List<String> materiaIds);

	public List<RegularidadEntity> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdOrderByFechaDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId, String materiaId);

}
