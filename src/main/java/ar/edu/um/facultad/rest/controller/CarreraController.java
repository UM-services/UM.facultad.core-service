/**
 * 
 */
package ar.edu.um.facultad.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.Carrera;
import ar.edu.um.facultad.rest.service.CarreraService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraService service;

	@GetMapping("/")
	public ResponseEntity<List<Carrera>> findAll() {
		return new ResponseEntity<List<Carrera>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/unique/{facultadId}/{planId}/{carreraId}")
	public ResponseEntity<Carrera> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer planId,
			@PathVariable Integer carreraId) {
		return new ResponseEntity<Carrera>(service.findByUnique(facultadId, planId, carreraId), HttpStatus.OK);
	}

}
