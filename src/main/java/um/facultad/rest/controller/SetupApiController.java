/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.SetupApiEntity;
import um.facultad.rest.service.SetupApiService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/setupapi")
@RequiredArgsConstructor
public class SetupApiController {
	
	private final SetupApiService service;
	
	@GetMapping("/last")
	public ResponseEntity<SetupApiEntity> findLast() {
		return ResponseEntity.ok(service.findLast());
	}
	
}
