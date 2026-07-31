/**
 * 
 */
package um.facultad.rest.controller.view;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.view.PreunivResumen;
import um.facultad.rest.service.view.PreunivResumenService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/preunivresumen")
@RequiredArgsConstructor
public class PreunivResumenController {

	private final PreunivResumenService service;

	@GetMapping("/lectivo/{facultadId}/{lectivoId}")
	public ResponseEntity<List<PreunivResumen>> findAllByLectivo(@PathVariable Integer facultadId,
                                                                 @PathVariable Integer lectivoId) {
        return ResponseEntity.ok(service.findAllByLectivo(facultadId, lectivoId));
	}
	
}
