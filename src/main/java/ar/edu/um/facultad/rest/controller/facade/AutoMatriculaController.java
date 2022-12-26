/**
 * 
 */
package ar.edu.um.facultad.rest.controller.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.Inscripcion;
import ar.edu.um.facultad.rest.service.facade.AutoMatriculaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/automatricula")
public class AutoMatriculaController {

	@Autowired
	private AutoMatriculaService service;

	@GetMapping("/pre/{facultadId}/{lectivoId}/{geograficaId}/{turnoId}")
	public ResponseEntity<List<Inscripcion>> auto_matricula_pre(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer turnoId) {
		return new ResponseEntity<List<Inscripcion>>(
				service.auto_matricula_pre(facultadId, lectivoId, geograficaId, turnoId), HttpStatus.OK);
	}
	
}
