/**
 * 
 */
package um.facultad.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.SetupApi;
import um.facultad.rest.service.SetupApiService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/setupapi")
public class SetupApiController {
	
	@Autowired
	private SetupApiService service;
	
	@GetMapping("/last")
	public ResponseEntity<SetupApi> findLast() {
		return new ResponseEntity<SetupApi>(service.findLast(), HttpStatus.OK);
	}
	
}
