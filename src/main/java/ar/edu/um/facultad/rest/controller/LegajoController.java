/**
 * 
 */
package ar.edu.um.facultad.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import ar.edu.um.facultad.rest.kotlin.model.Legajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.view.LegajoKey;
import ar.edu.um.facultad.rest.service.LegajoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/legajo")
public class LegajoController {

	@Autowired
	private LegajoService service;

	@GetMapping("/persona/{personaId}/{documentoId}/{facultadId}")
	public ResponseEntity<Legajo> findByPersona(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId,
			@PathVariable Integer facultadId) {
		return new ResponseEntity<Legajo>(service.findByPersona(personaId, documentoId, facultadId), HttpStatus.OK);
	}

	@GetMapping("/asigna/{facultadId}/{lectivoId}/{personaId}/{documentoId}")
	public ResponseEntity<Legajo> asignaNumeroLegajo(@PathVariable Integer facultadId, @PathVariable Integer lectivoId,
													 @PathVariable BigDecimal personaId, @PathVariable Integer documentoId) {
		return new ResponseEntity<Legajo>(service.asignaNumeroLegajo(facultadId, lectivoId, personaId, documentoId),
				HttpStatus.OK);
	}

	@GetMapping("/numera/{facultadId}/{lectivoId}")
	public ResponseEntity<List<Legajo>> numeraByLectivoId(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId) {
		return new ResponseEntity<List<Legajo>>(service.numeraByLectivoId(facultadId, lectivoId), HttpStatus.OK);
	}

	@GetMapping("/pre/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<LegajoKey>> findAllByPreuniversitario(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
		return new ResponseEntity<List<LegajoKey>>(service.findAllByPreuniversitario(facultadId, lectivoId, geograficaId),
				HttpStatus.OK);
	}

}
