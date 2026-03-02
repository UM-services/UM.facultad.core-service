/**
 * 
 */
package um.facultad.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LectivoController {

	@Autowired
	private LectivoService service;

	@GetMapping("/")
	public ResponseEntity<List<LectivoEntity>> findAll() {
		return new ResponseEntity<List<LectivoEntity>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/reverse")
	public ResponseEntity<List<LectivoEntity>> findAllReverse() {
		return new ResponseEntity<List<LectivoEntity>>(service.findAllReverse(), HttpStatus.OK);
	}

}
