/**
 * 
 */
package ar.edu.um.facultad.rest.service.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.view.AlumnoExamen;
import ar.edu.um.facultad.rest.repository.view.IAlumnoExamenRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class AlumnoExamenService {
	@Autowired
	private IAlumnoExamenRepository repository;

	public List<AlumnoExamen> findAllByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer days) {
		LocalDate start = LocalDate.now();
		log.debug(start.toString());
		LocalDate end = start.plusDays(days);
		log.debug(end.toString());
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndFechaBetween(personaId, documentoId, facultadId, start, end);
	}
}
