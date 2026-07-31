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

import um.facultad.rest.model.LegajoEntity;
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
	public ResponseEntity<LegajoEntity> findByPersona(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId,
                                                       @PathVariable Integer facultadId) {
		// agregar respuesta para evitar la excepcion
		try {
			return ResponseEntity.ok(service.findByPersona(personaId, documentoId, facultadId));
		} catch (LegajoException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@GetMapping("/asigna/{facultadId}/{lectivoId}/{personaId}/{documentoId}")
	public ResponseEntity<LegajoEntity> asignaNumeroLegajo(@PathVariable Integer facultadId, @PathVariable Integer lectivoId,
                                                            @PathVariable BigDecimal personaId, @PathVariable Integer documentoId) {
		return ResponseEntity.ok(service.asignaNumeroLegajo(facultadId, lectivoId, personaId, documentoId));
	}

	@GetMapping("/numera/{facultadId}/{lectivoId}")
	public ResponseEntity<List<LegajoEntity>> numeraByLectivoId(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId) {
		return ResponseEntity.ok(service.numeraByLectivoId(facultadId, lectivoId));
	}

	@GetMapping("/pre/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<LegajoKey>> findAllByPreuniversitario(@PathVariable Integer facultadId,
                                                                      @PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
		return ResponseEntity.ok(service.findAllByPreuniversitario(facultadId, lectivoId, geograficaId));
	}

}
