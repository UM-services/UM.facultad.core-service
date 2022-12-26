/**
 * 
 */
package ar.edu.um.facultad.rest.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.Domicilio;
import ar.edu.um.facultad.rest.service.DomicilioService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/domicilio")
public class DomicilioController {
	
	@Autowired
	private DomicilioService service;

	@GetMapping("/{personaId}/{documentoId}")
	public ResponseEntity<Domicilio> findByPersonaIdAndDocumentoId(@PathVariable BigDecimal personaId,
			@PathVariable Integer documentoId) {
		return new ResponseEntity<Domicilio>(service.findByPersonaIdAndDocumentoId(personaId, documentoId),
				HttpStatus.OK);
	}

	@GetMapping("/pagador/{personaId}/{documentoId}")
	public ResponseEntity<Domicilio> findByPagador(@PathVariable BigDecimal personaId,
			@PathVariable Integer documentoId) {
		return new ResponseEntity<Domicilio>(service.findByPagador(personaId, documentoId), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Domicilio> add(@RequestBody Domicilio domicilio) {
		return new ResponseEntity<Domicilio>(service.add(domicilio, true), HttpStatus.OK);
	}

	@PutMapping("/{personaId}/{documentoId}")
	public ResponseEntity<Domicilio> update(@RequestBody Domicilio domicilio, @PathVariable BigDecimal personaId,
			@PathVariable Integer documentoId) {
		return new ResponseEntity<Domicilio>(service.update(domicilio, personaId, documentoId, true), HttpStatus.OK);
	}

	@PostMapping("/sincronize")
	public ResponseEntity<Domicilio> sincronize(@RequestBody Domicilio domicilio) {
		return new ResponseEntity<Domicilio>(service.sincronize(domicilio), HttpStatus.OK);
	}
}
