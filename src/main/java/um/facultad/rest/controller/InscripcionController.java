/**
 * 
 */
package um.facultad.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.service.InscripcionService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

	@Autowired
	private InscripcionService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<Inscripcion>> findAllByLectivo(@PathVariable Integer facultadId,
                                                              @PathVariable Integer lectivoId) {
		return new ResponseEntity<List<Inscripcion>>(service.findAllByLectivo(facultadId, lectivoId), HttpStatus.OK);
	}

	@GetMapping("/curso/{facultadId}/{lectivoId}/{geograficaId}/{curso}")
	public ResponseEntity<List<Inscripcion>> findAllByCurso(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer curso) {
		return new ResponseEntity<List<Inscripcion>>(service.findAllByCurso(facultadId, lectivoId, geograficaId, curso),
				HttpStatus.OK);
	}

	@GetMapping("/cursosinprovisoria/{facultadId}/{lectivoId}/{geograficaId}/{curso}")
	public ResponseEntity<List<Inscripcion>> findAllByCursoSinProvisoria(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId, @PathVariable Integer geograficaId, @PathVariable Integer curso) {
		return new ResponseEntity<List<Inscripcion>>(service.findAllByCursoSinProvisoria(facultadId, lectivoId, geograficaId, curso),
				HttpStatus.OK);
	}

	@GetMapping("/unique/{facultadId}/{personaId}/{documentoId}/{lectivoId}")
	public ResponseEntity<Inscripcion> findByUnique(@PathVariable Integer facultadId,
			@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer lectivoId) {
		return new ResponseEntity<Inscripcion>(service.findByUnique(facultadId, personaId, documentoId, lectivoId),
				HttpStatus.OK);
	}

}