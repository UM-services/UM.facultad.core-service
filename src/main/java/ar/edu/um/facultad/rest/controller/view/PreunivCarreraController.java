/**
 * 
 */
package ar.edu.um.facultad.rest.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.view.PreunivCarrera;
import ar.edu.um.facultad.rest.service.view.PreunivCarreraService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preunivcarrera")
public class PreunivCarreraController {

	@Autowired
	private PreunivCarreraService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreunivCarrera>> findAllByLectivo(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId) {
		return new ResponseEntity<List<PreunivCarrera>>(service.findAllByLectivo(facultadId, lectivoId), HttpStatus.OK);
	}

	@GetMapping("/carrera/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}/{planId}/{carreraId}")
	public ResponseEntity<List<PreunivCarrera>> findAllByCarrera(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId,
			@PathVariable Integer planId, @PathVariable Integer carreraId) {
		return new ResponseEntity<List<PreunivCarrera>>(
				service.findAllByCarrera(facultadId, lectivoId, geograficaId, turnoId, planId, carreraId),
				HttpStatus.OK);
	}

}
