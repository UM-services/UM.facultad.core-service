/**
 * 
 */
package um.facultad.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.PreInscripcion;
import um.facultad.rest.service.PreInscripcionService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preinscripcion")
public class PreInscripcionController {

	@Autowired
	private PreInscripcionService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreInscripcion>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId) {
		return new ResponseEntity<List<PreInscripcion>>(service.findAllByLectivo(facultadId, lectivoId), HttpStatus.OK);
	}

	@GetMapping("/sede/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<PreInscripcion>> findAllBySede(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
		return new ResponseEntity<List<PreInscripcion>>(service.findAllBySede(facultadId, lectivoId, geograficaId),
				HttpStatus.OK);
	}

	@GetMapping("/turno/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}")
	public ResponseEntity<List<PreInscripcion>> findAllByTurnoKey(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId) {
		return new ResponseEntity<List<PreInscripcion>>(
				service.findAllByTurno(facultadId, lectivoId, geograficaId, turnoId), HttpStatus.OK);
	}

	@GetMapping("/personalectivo/{facultadId}/{personaId}/{documentoId}/{lectivoId}")
	public ResponseEntity<PreInscripcion> findPersonaByLectivo(@PathVariable Integer facultadId,
			@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer lectivoId) {
		return new ResponseEntity<PreInscripcion>(
				service.findPersonaByLectivo(facultadId, personaId, documentoId, lectivoId), HttpStatus.OK);
	}
	
}
