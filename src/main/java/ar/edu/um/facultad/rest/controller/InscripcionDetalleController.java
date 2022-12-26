/**
 * 
 */
package ar.edu.um.facultad.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.InscripcionDetalle;
import ar.edu.um.facultad.rest.service.InscripcionDetalleService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/inscripciondetalle")
public class InscripcionDetalleController {
	
	@Autowired
	private InscripcionDetalleService service;

	@GetMapping("/persona/{personaId}/{documentoId}/{facultadId}/{lectivoId}")
	public ResponseEntity<List<InscripcionDetalle>> findAllByPersona(@PathVariable BigDecimal personaId,
			@PathVariable Integer documentoId, @PathVariable Integer facultadId, @PathVariable Integer lectivoId) {
		return new ResponseEntity<List<InscripcionDetalle>>(
				service.findAllByPersona(personaId, documentoId, facultadId, lectivoId), HttpStatus.OK);
	}
}
