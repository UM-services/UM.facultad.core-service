/**
 * 
 */
package um.facultad.rest.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.view.PersonaKey;
import um.facultad.rest.service.view.PersonaKeyService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/personakey")
public class PersonaKeyController {

	@Autowired
	private PersonaKeyService service;

	@PostMapping("/unifieds")
	public ResponseEntity<List<PersonaKey>> findAllByUnifieds(@RequestBody List<String> unifieds) {
		return new ResponseEntity<List<PersonaKey>>(service.findAllByUnifieds(unifieds), HttpStatus.OK);
	}
}
