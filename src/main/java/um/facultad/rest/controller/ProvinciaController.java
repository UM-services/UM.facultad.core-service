/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.ProvinciaEntity;
import um.facultad.rest.service.ProvinciaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/provincia")
@RequiredArgsConstructor
public class ProvinciaController {
	
	private final ProvinciaService service;

	@GetMapping("/unique/{facultadId}/{provinciaId}")
	public ResponseEntity<ProvinciaEntity> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer provinciaId) {
		return ResponseEntity.ok(service.findByUnique(facultadId, provinciaId));
	}

}
