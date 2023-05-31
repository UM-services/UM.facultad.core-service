/**
 * 
 */
package um.facultad.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.Provincia;
import um.facultad.rest.service.ProvinciaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/provincia")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaService service;

	@GetMapping("/unique/{facultadId}/{provinciaId}")
	public ResponseEntity<Provincia> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer provinciaId) {
		return new ResponseEntity<Provincia>(service.findByUnique(facultadId, provinciaId), HttpStatus.OK);
	}

}
