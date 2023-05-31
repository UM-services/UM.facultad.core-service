/**
 * 
 */
package um.facultad.rest.service.facade;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.MateriaNotFoundException;
import um.facultad.rest.model.Materia;
import um.facultad.rest.model.extern.NotificacionExamen;
import um.facultad.rest.model.view.AlumnoExamen;
import um.facultad.rest.service.MateriaService;
import um.facultad.rest.service.view.AlumnoExamenService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class MailService {

	@Autowired
	private InscriptosToXlsService xlsService;

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private AlumnoExamenService alumnoExamenService;

	public String sendLista(Integer facultadId, Integer lectivoId, Integer planId, String materiaId, Integer cursoId,
			Integer periodoId, Integer divisionId, Integer geograficaId, String email) throws MessagingException {
		// Genera PDF
		String filename_list = xlsService.generateListaXls(facultadId, lectivoId, planId, materiaId, cursoId, periodoId,
				divisionId, geograficaId);
		String data = "";

		Materia materia = new Materia();
		try {
			materia = materiaService.findByUnique(facultadId, planId, materiaId);
		} catch (MateriaNotFoundException e) {

		}

		data = "Estimado Profesor:" + (char) 10;
		data = data + (char) 10;
		data = data + "Le enviamos como archivo adjunto la lista de alumnos de " + materia.getNombre() + " ("
				+ materia.getMateriaId() + ")." + (char) 10;
		data = data + (char) 10;
		data = data + "Atentamente." + (char) 10;
		data = data + (char) 10;
		data = data + "Universidad de Mendoza" + (char) 10;
		data = data + (char) 10;
		data = data + (char) 10;
		data = data + (char) 10;
		data = data + (char) 10;
		data = data + (char) 10
				+ "Por favor no responda este mail, fue generado automáticamente. Su respuesta no será leída."
				+ (char) 10;

		// Envia correo
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		try {
			helper.setTo(email);
			helper.setText(data);
			helper.setReplyTo("no-reply@um.edu.ar");
			helper.setSubject("Envío Automático de Lista de Alumnos -> " + materia.getNombre() + " ("
					+ materia.getMateriaId() + ")");
			FileSystemResource file_list = new FileSystemResource(filename_list);
			helper.addAttachment(filename_list, file_list);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "ERROR: No pudo ENVIARSE";
		}
		sender.send(message);

		return "Envío de Lista Ok!!";
	}

	public void sendExamen48Horas(BigDecimal personaId, Integer documentoId, Integer facultadId,
			List<NotificacionExamen> emails) throws MessagingException {
		log.debug("Iniciando envío");
		for (AlumnoExamen examen : alumnoExamenService.findAllByPersona(personaId, documentoId, facultadId, 2)) {
			String data = "";

			data = "A continuación se informa la carga o habilitación de pago/s de : " + (char) 10;
			data = data + (char) 10;
			data = data + "Legajo: " + examen.getNumeroLegajo() + (char) 10;
			data = data + (char) 10;
			data = data + "Alumno: " + examen.getNombre() + " " + examen.getApellido() + " Doc: "
					+ examen.getPersonaId() + (char) 10;
			data = data + (char) 10;
			data = data + "Carrera: " + examen.getCarrera() + (char) 10;
			data = data + (char) 10;
			data = data + "Sede: " + examen.getSede() + (char) 10;
			data = data + (char) 10;
			data = data + "Llamado: " + examen.getLlamado() + (char) 10;
			data = data + (char) 10;
			data = data + "Materia: " + examen.getPlan() + " / " + examen.getMateria() + (char) 10;
			data = data + (char) 10;
			data = data + "Fecha / Hora: " + examen.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " / "
					+ DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("UTC")).format(examen.getHora())
					+ (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + "Tesorería - Universidad de Mendoza" + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10;
			data = data + (char) 10
					+ "Por favor no responda este mail, fue generado automáticamente. Su respuesta no será leída."
					+ (char) 10;

			// Envia correo
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			List<String> to = new ArrayList<String>();
			for (NotificacionExamen notificacionexamen : emails)
				if (notificacionexamen.getGeograficaId() == examen.getGeograficaId())
					to.add(notificacionexamen.getEmail());
			if (to.size() > 0) {
				try {
					helper.setTo(to.toArray(new String[to.size()]));
					helper.setText(data);
					helper.setReplyTo("no-reply@um.edu.ar");
					helper.setSubject("Envío Automático por Carga o Habilitación de Pago/s de " + examen.getNombre()
							+ " " + examen.getApellido() + " Examen: "
							+ examen.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				} catch (MessagingException e) {
					e.printStackTrace();
					return;
				}
				sender.send(message);
			}
		}
	}

}
