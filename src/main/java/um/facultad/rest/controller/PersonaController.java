/**
 * 
 */
package um.facultad.rest.controller;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.Persona;
import um.facultad.rest.service.PersonaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
	
	private final PersonaService service;
	
	@GetMapping("/{personaId}/{documentoId}")
	public ResponseEntity<Persona> findByPersonaIdAndDocumentoId(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId) {
		return new ResponseEntity<Persona>(service.findByPersonaIdAndDocumentoId(personaId, documentoId), HttpStatus.OK);
	}
	
}
