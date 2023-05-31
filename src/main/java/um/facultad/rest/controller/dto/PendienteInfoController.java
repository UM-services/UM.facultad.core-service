/**
 * 
 */
package um.facultad.rest.controller.dto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.dto.PendienteInfo;
import um.facultad.rest.service.dto.PendienteInfoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/pendienteinfo")
public class PendienteInfoController {

	@Autowired
	private PendienteInfoService service;

	@GetMapping("/info/{facultadId}/{lectivoId}/{geograficaId}/{personaId}/{documentoId}")
	public ResponseEntity<PendienteInfo> findByAlumno(@PathVariable Integer facultadId, @PathVariable Integer lectivoId,
			@PathVariable Integer geograficaId, @PathVariable BigDecimal personaId, @PathVariable Integer documentoId) {
		return new ResponseEntity<PendienteInfo>(
				service.findByAlumno(facultadId, lectivoId, geograficaId, personaId, documentoId), HttpStatus.OK);
	}
}
