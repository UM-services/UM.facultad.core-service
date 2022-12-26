/**
 * 
 */
package ar.edu.um.facultad.rest.controller.facade;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.um.facultad.rest.model.extern.NotificacionExamen;
import ar.edu.um.facultad.rest.service.facade.MailService;
import jakarta.mail.MessagingException;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/notificacion")
public class NotificacionController {

	@Autowired
	private MailService service;

	/**
	 * Este endpoint envía una notificacion por mail en caso que el alumno rinda
	 * entre hoy y 2 días para adelante
	 */
	@PostMapping("/examen48horas/{personaId}/{documentoId}/{facultadId}")
	public ResponseEntity<Void> notificacionExamen48Horas(@RequestBody List<NotificacionExamen> emails,
			@PathVariable BigDecimal personaId, @PathVariable Integer documentoId, @PathVariable Integer facultadId)
			throws MessagingException {
		service.sendExamen48Horas(personaId, documentoId, facultadId, emails);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
