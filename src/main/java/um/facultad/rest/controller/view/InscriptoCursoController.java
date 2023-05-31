/**
 * 
 */
package um.facultad.rest.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.view.InscriptoCurso;
import um.facultad.rest.service.view.InscriptoCursoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/inscriptocurso")
public class InscriptoCursoController {

	@Autowired
	private InscriptoCursoService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}/{geograficaId}")
	public ResponseEntity<List<InscriptoCurso>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId, @PathVariable Integer geograficaId) {
		return new ResponseEntity<List<InscriptoCurso>>(service.findAllByLectivo(facultadId, lectivoId, geograficaId),
				HttpStatus.OK);
	}

	@GetMapping("/curso/{facultadId}/{lectivoId}")
	public ResponseEntity<List<InscriptoCurso>> findAllByCurso(@PathVariable Integer facultadId,
			@PathVariable Integer lectivoId) {
		return new ResponseEntity<List<InscriptoCurso>>(service.findAllByCurso(facultadId, lectivoId), HttpStatus.OK);
	}

}
