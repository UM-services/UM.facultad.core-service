/**
 * 
 */
package um.facultad.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.PlanEntity;
import um.facultad.rest.service.PlanService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService service;

	@GetMapping("/")
	public ResponseEntity<List<PlanEntity>> findAll() {
		return new ResponseEntity<List<PlanEntity>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/unique/{facultadId}/{planId}")
	public ResponseEntity<PlanEntity> findByUnique(@PathVariable Integer facultadId, @PathVariable Integer planId) {
		return new ResponseEntity<PlanEntity>(service.findByUnique(facultadId, planId), HttpStatus.OK);
	}

}
