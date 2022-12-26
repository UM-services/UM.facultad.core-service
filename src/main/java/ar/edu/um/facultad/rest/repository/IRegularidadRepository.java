/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Regularidad;

/**
 * @author daniel
 *
 */
@Repository
public interface IRegularidadRepository extends JpaRepository<Regularidad, Long> {

	public List<Regularidad> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdInOrderByFechaDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId, List<String> materiaIds);

	public List<Regularidad> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdOrderByFechaDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId, String materiaId);

}
