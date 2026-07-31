/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.TituloEntregaEntity;
import um.facultad.rest.service.TituloEntregaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/tituloentrega")
@RequiredArgsConstructor
public class TituloEntregaController {

	private final TituloEntregaService service;

	@GetMapping("/unique/{personaId}/{documentoId}/{facultadId}/{planId}/{carreraId}")
	public ResponseEntity<TituloEntregaEntity> findByUnique(@PathVariable BigDecimal personaId,
                                                            @PathVariable Integer documentoId, @PathVariable Integer facultadId, @PathVariable Integer planId,
                                                            @PathVariable Integer carreraId) {
		return ResponseEntity.ok(service.findByUnique(personaId, documentoId, facultadId, planId, carreraId));
	}
	
}
