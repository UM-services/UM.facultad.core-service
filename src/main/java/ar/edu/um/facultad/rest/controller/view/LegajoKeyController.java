/**
 * 
 */
package ar.edu.um.facultad.rest.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.view.LegajoKey;
import ar.edu.um.facultad.rest.service.view.LegajoKeyService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/legajokey")
public class LegajoKeyController {

	@Autowired
	private LegajoKeyService service;

	@PostMapping("/unifieds/{facultadId}")
	public ResponseEntity<List<LegajoKey>> findAllByFacultadAndPersonaKeys(@PathVariable Integer facultadId,
			@RequestBody List<String> personaKeys) {
		return new ResponseEntity<List<LegajoKey>>(service.findAllByFacultadAndPersonaKeys(facultadId, personaKeys),
				HttpStatus.OK);
	}

}
