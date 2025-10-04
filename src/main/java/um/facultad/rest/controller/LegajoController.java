/**
 * 
 */
package um.facultad.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import um.facultad.rest.exception.LegajoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.Legajo;
import um.facultad.rest.model.view.LegajoKey;
import um.facultad.rest.service.LegajoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/legajo")
@RequiredArgsConstructor
public class LegajoController {

	private final LegajoService service;

	@GetMapping("/persona/{personaId}/{documentoId}/{facultadId}")
	public ResponseEntity<Legajo> findByPersona(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId,
                                                @PathVariable Integer facultadId) {
		// agregar respuesta para evitar la excepcion
		try {
			return new ResponseEntity<>(service.findByPersona(personaId, documentoId, facultadId), HttpStatus.OK);
		} catch (LegajoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@GetMapping("/asigna/{facultadId}/{lectivoId}/{personaId}/{documentoId}")
	public ResponseEntity<Legajo> asignaNumeroLegajo(@PathVariable Integer facultadId, @PathVariable Integer lectivoId,
													 @PathVariable BigDecimal personaId, @PathVariable Integer documentoId) {
		return new ResponseEntity<>(service.asignaNumeroLegajo(facultadId, lectivoId, personaId, documentoId),
				HttpStatus.OK);
	}

	@GetMapping("/numera/{facultadId}/{lectivoId}")
	public ResponseEntity<List<Legajo>> numeraByLectivoId(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId) {
		return new ResponseEntity<>(service.numeraByLectivoId(facultadId, lectivoId), HttpStatus.OK);
	}

	@GetMapping("/pre/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<LegajoKey>> findAllByPreuniversitario(@PathVariable Integer facultadId,
                                                                     @PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
		return new ResponseEntity<>(service.findAllByPreuniversitario(facultadId, lectivoId, geograficaId),
				HttpStatus.OK);
	}

}
