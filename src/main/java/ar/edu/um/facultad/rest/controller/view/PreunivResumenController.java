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

import ar.edu.um.facultad.rest.model.view.PreunivResumen;
import ar.edu.um.facultad.rest.service.view.PreunivResumenService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preunivresumen")
public class PreunivResumenController {

	@Autowired
	private PreunivResumenService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreunivResumen>> findAllByLectivo(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId) {
		return new ResponseEntity<List<PreunivResumen>>(service.findAllByLectivo(facultadId, lectivoId), HttpStatus.OK);
	}
	
}
