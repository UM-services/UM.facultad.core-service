/**
 * 
 */
package um.facultad.rest.service.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.AlumnoExamen;
import um.facultad.rest.repository.view.IAlumnoExamenRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AlumnoExamenService {

	private final IAlumnoExamenRepository repository;

	public List<AlumnoExamen> findAllByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer days) {
		LocalDate start = LocalDate.now();
		LocalDate end = start.plusDays(days);
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndFechaBetween(personaId, documentoId, facultadId, start, end);
	}
}
