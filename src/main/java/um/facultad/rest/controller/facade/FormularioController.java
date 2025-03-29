/**
 * 
 */
package um.facultad.rest.controller.facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import um.facultad.rest.model.dto.DivisionDto;
import um.facultad.rest.service.facade.MailService;
import um.facultad.rest.service.facade.MatriculaToPdfService;
import jakarta.mail.MessagingException;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/formularios")
public class FormularioController {

	private final MatriculaToPdfService matriculaToPdfService;
	private final MailService mailing;

	public FormularioController(MatriculaToPdfService matriculaToPdfService, MailService mailing) {
		this.matriculaToPdfService = matriculaToPdfService;
		this.mailing = mailing;
	}

	@GetMapping("/matricula/{personaId}/{documentoId}/{facultadId}/{lectivoId}")
	public ResponseEntity<Resource> generateMatricula(@PathVariable BigDecimal personaId, @PathVariable Integer documentoId,
			@PathVariable Integer facultadId, @PathVariable Integer lectivoId) throws IOException {
		String filename = matriculaToPdfService.generateMatriculaPdf(personaId, documentoId, facultadId, lectivoId);
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=matricula.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	@PostMapping("/lista")
	public String sendLista(@RequestBody DivisionDto division) throws MessagingException {
		return mailing.sendLista(division.getFacultadId(), division.getLectivoId(), division.getPlanId(),
				division.getMateriaId(), division.getCursoId(), division.getPeriodoId(), division.getDivisionId(),
				division.getGeograficaId(), division.getEmail());
	}
	
}
