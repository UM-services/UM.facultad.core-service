/**
 * 
 */
package um.facultad.rest.repository.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.view.AlumnoExamen;

/**
 * @author daniel
 *
 */
@Repository
public interface IAlumnoExamenRepository extends JpaRepository<AlumnoExamen, Long> {

	public List<AlumnoExamen> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndFechaBetween(BigDecimal personaId,
			Integer documentoId, Integer facultadId, LocalDate start, LocalDate end);

}
