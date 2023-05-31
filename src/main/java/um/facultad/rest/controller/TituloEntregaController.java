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

import um.facultad.rest.model.TituloEntrega;
import um.facultad.rest.service.TituloEntregaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/tituloentrega")
public class TituloEntregaController {

	@Autowired
	private TituloEntregaService service;

	@GetMapping("/unique/{personaId}/{documentoId}/{facultadId}/{planId}/{carreraId}")
	public ResponseEntity<TituloEntrega> findByUnique(@PathVariable BigDecimal personaId,
                                                      @PathVariable Integer documentoId, @PathVariable Integer facultadId, @PathVariable Integer planId,
                                                      @PathVariable Integer carreraId) {
		return new ResponseEntity<TituloEntrega>(
				service.findByUnique(personaId, documentoId, facultadId, planId, carreraId), HttpStatus.OK);
	}
	
}
