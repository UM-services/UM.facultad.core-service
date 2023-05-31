/**
 * 
 */
package um.facultad.rest.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import um.facultad.rest.exception.BajaNotFoundException;
import um.facultad.rest.model.Baja;
import um.facultad.rest.service.BajaService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/baja")
@Slf4j
public class BajaController {

	@Autowired
	private BajaService service;

	@GetMapping("/unique/{facultadId}/{personaId}/{documentoId}/{lectivoId}")
	public ResponseEntity<Baja> findByUnique(@PathVariable Integer facultadId, @PathVariable BigDecimal personaId,
                                             @PathVariable Integer documentoId, @PathVariable Integer lectivoId) {
		log.info("Baja Controller Facultad Request");
		try {
			return new ResponseEntity<Baja>(service.findByUnique(facultadId, personaId, documentoId, lectivoId),
					HttpStatus.OK);
		} catch (BajaNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
