/**
 * 
 */
package um.facultad.rest.controller.facade;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.service.facade.AutoMatriculaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/automatricula")
@RequiredArgsConstructor
public class AutoMatriculaController {

	private final AutoMatriculaService service;

	@GetMapping("/pre/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}")
	public ResponseEntity<List<Inscripcion>> auto_matricula_pre(@PathVariable Integer facultadId,
                                                                      @PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId) {
        return ResponseEntity.ok(service.auto_matricula_pre(facultadId, lectivoId, geograficaId, turnoId));
	}
	
}
