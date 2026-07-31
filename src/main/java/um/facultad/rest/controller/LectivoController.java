/**
 * 
 */
package um.facultad.rest.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.LectivoEntity;
import um.facultad.rest.service.LectivoService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/lectivo")
@RequiredArgsConstructor
public class LectivoController {

	private final LectivoService service;

	@GetMapping("/")
	public ResponseEntity<List<LectivoEntity>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/reverse")
	public ResponseEntity<List<LectivoEntity>> findAllReverse() {
		return ResponseEntity.ok(service.findAllReverse());
	}

}
