/**
 * 
 */
package ar.edu.um.facultad.rest.controller.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.service.facade.SheetService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/sheet")
public class SheetController {

	@Autowired
	private SheetService service;

	@GetMapping("/matriculacurso/{facultadId}/{lectivoId}/{geograficaId}/{curso}")
	public ResponseEntity<Resource> generateCargos(@PathVariable Integer facultadId, @PathVariable Integer lectivoId,
			@PathVariable Integer geograficaId, @PathVariable Integer curso) throws IOException {
		String filename = service.generateMatriculaCurso(facultadId, lectivoId, geograficaId, curso);
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=matriculas.xlsx");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

}
