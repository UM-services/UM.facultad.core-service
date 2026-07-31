/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.PreTurnoEntity;
import um.facultad.rest.service.PreTurnoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preturno")
@RequiredArgsConstructor
public class PreTurnoController {

	private final PreTurnoService service;

@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreTurnoEntity>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId) {
		return ResponseEntity.ok(service.findAllByLectivo(facultadId, lectivoId));
	}
	
}
