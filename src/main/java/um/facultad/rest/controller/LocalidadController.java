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

import um.facultad.rest.model.LocalidadEntity;
import um.facultad.rest.service.LocalidadService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/localidad")
@RequiredArgsConstructor
public class LocalidadController {
	
	private final LocalidadService service;

@GetMapping("/unique/{facultadId}/{provinciaId}/{localidadId}")
	public ResponseEntity<LocalidadEntity> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer provinciaId,
                                                         @PathVariable Integer localidadId) {
		return ResponseEntity.ok(service.findByUnique(facultadId, provinciaId, localidadId));
	}
	
}
