/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.PreInscripcionEntity;
import um.facultad.rest.service.PreInscripcionService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preinscripcion")
@RequiredArgsConstructor
public class PreInscripcionController {

	private final PreInscripcionService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreInscripcionEntity>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                       @PathVariable Integer lectivoId) {
        return ResponseEntity.ok(service.findAllByLectivo(facultadId, lectivoId));
	}

	@GetMapping("/sede/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<PreInscripcionEntity>> findAllBySede(@PathVariable Integer facultadId,
                                                                    @PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
        return ResponseEntity.ok(service.findAllBySede(facultadId, lectivoId, geograficaId));
	}

	@GetMapping("/turno/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}")
	public ResponseEntity<List<PreInscripcionEntity>> findAllByTurnoKey(@PathVariable Integer facultadId,
                                                                        @PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId) {
        return ResponseEntity.ok(service.findAllByTurno(facultadId, lectivoId, geograficaId, turnoId));
	}

	@GetMapping("/personalectivo/{facultadId}/{personaId}/{documentoId}/{lectivoId}")
	public ResponseEntity<PreInscripcionEntity> findPersonaByLectivo(@PathVariable Integer facultadId,
                                                                     @PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer lectivoId) {
        return ResponseEntity.ok(service.findPersonaByLectivo(facultadId, personaId, documentoId, lectivoId));
	}
	
}
