/**
 * 
 */
package um.facultad.rest.controller.view;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.view.AlumnoExamen;
import um.facultad.rest.service.view.AlumnoExamenService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/alumnoexamen")
@RequiredArgsConstructor
public class AlumnoExamenController {

	private final AlumnoExamenService service;
	
	@GetMapping("/48horas/{personaId}/{documentoId}/{facultadId}")
	public ResponseEntity<List<AlumnoExamen>> findAllByPersona(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer facultadId) {
		return ResponseEntity.ok(service.findAllByPersona(personaId, documentoId, facultadId, 2));
	}
	
	@GetMapping("/48horascantidad/{personaId}/{documentoId}/{facultadId}")
	public ResponseEntity<Integer> countAllByPersona(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer facultadId) {
		return ResponseEntity.ok(service.findAllByPersona(personaId, documentoId, facultadId, 2).size());
	}
	
	@GetMapping("/days/{personaId}/{documentoId}/{facultadId}/{days}")
	public ResponseEntity<List<AlumnoExamen>> findAllByPersonaDays(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer facultadId, @PathVariable Integer days) {
		return ResponseEntity.ok(service.findAllByPersona(personaId, documentoId, facultadId, days));
	}
	
}
