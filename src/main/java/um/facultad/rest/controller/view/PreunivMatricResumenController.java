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

import um.facultad.rest.model.view.PreunivMatricResumen;
import um.facultad.rest.service.view.PreunivMatricResumenService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preunivmatricresumen")
public class PreunivMatricResumenController {

	@Autowired
	private PreunivMatricResumenService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreunivMatricResumen>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                       @PathVariable Integer lectivoId) {
		return new ResponseEntity<List<PreunivMatricResumen>>(service.findAllByLectivo(facultadId, lectivoId),
				HttpStatus.OK);
	}

}
