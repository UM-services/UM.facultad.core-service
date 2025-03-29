/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.pk.InscripcionPk;

/**
 * @author daniel
 *
 */
@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionPk> {

	List<Inscripcion> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

	List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(Integer facultadId,
			Integer lectivoId, Integer geograficaId, Integer curso);

	List<Inscripcion> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(Integer facultadId,
			Integer lectivoId, Integer geograficaId, Integer curso, Byte provisoria);

	List<Inscripcion> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

	Optional<Inscripcion> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId,
			BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
