/**
 * 
 */
package um.facultad.rest.controller.view;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.view.PreunivCarrera;
import um.facultad.rest.service.view.PreunivCarreraService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preunivcarrera")
@RequiredArgsConstructor
public class PreunivCarreraController {

	private final PreunivCarreraService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreunivCarrera>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId) {
        return ResponseEntity.ok(service.findAllByLectivo(facultadId, lectivoId));
	}

	@GetMapping("/carrera/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}/{planId}/{carreraId}")
	public ResponseEntity<List<PreunivCarrera>> findAllByCarrera(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId,
			@PathVariable Integer planId, @PathVariable Integer carreraId) {
        return ResponseEntity.ok(service.findAllByCarrera(facultadId, lectivoId, geograficaId, turnoId, planId, carreraId));
	}

}
