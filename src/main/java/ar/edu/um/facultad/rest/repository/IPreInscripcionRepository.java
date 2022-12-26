/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.PreInscripcion;

/**
 * @author daniel
 *
 */
@Repository
public interface IPreInscripcionRepository extends JpaRepository<PreInscripcion, Long> {

	public List<PreInscripcion> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

	public List<PreInscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaId(Integer facultadId, Integer lectivoId,
			Integer geograficaId);

	public List<PreInscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoId(Integer facultadId,
			Integer lectivoId, Integer geograficaId, Integer turnoId);

	public Optional<PreInscripcion> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId,
			BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
