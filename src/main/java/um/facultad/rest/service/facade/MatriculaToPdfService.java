/**
 * 
 */
package um.facultad.rest.service.facade;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;
import org.openpdf.text.*;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.CarreraException;
import um.facultad.rest.exception.DomicilioException;
import um.facultad.rest.exception.FacultadException;
import um.facultad.rest.exception.InscripcionException;
import um.facultad.rest.exception.LegajoException;
import um.facultad.rest.exception.LocalidadException;
import um.facultad.rest.exception.MateriaException;
import um.facultad.rest.exception.NacimientoException;
import um.facultad.rest.exception.ProvinciaException;
import um.facultad.rest.model.*;
import um.facultad.rest.service.CarreraService;
import um.facultad.rest.service.DocumentoService;
import um.facultad.rest.service.DomicilioService;
import um.facultad.rest.service.FacultadService;
import um.facultad.rest.service.GeograficaService;
import um.facultad.rest.service.InscripcionDetalleService;
import um.facultad.rest.service.InscripcionService;
import um.facultad.rest.service.LectivoService;
import um.facultad.rest.service.LegajoService;
import um.facultad.rest.service.LocalidadService;
import um.facultad.rest.service.MateriaService;
import um.facultad.rest.service.NacimientoService;
import um.facultad.rest.service.PersonaService;
import um.facultad.rest.service.ProvinciaService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MatriculaToPdfService {

	private final InscripcionService inscripcionService;
	private final FacultadService facultadService;
	private final GeograficaService geograficaService;
	private final PersonaService personaService;
	private final LectivoService lectivoService;
	private final DocumentoService documentoService;
	private final NacimientoService nacimientoService;
	private final LegajoService legajoService;
	private final DomicilioService domicilioService;
	private final LocalidadService localidadService;
	private final ProvinciaService provinciaService;
	private final CarreraService carreraService;
	private final MateriaService materiaService;
	private final InscripcionDetalleService inscripcionDetalleService;
	private final Environment env;

	public String generateMatriculaPdf(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer lectivoId) {
		Inscripcion inscripcion = null;
		try {
			inscripcion = inscripcionService.findByUnique(facultadId, personaId, documentoId, lectivoId);
		} catch (InscripcionException e) {
			return "";
		}
		log.debug("Inscripcion -> {}", inscripcion);

		Facultad facultad = null;
		try {
			facultad = facultadService.findByFacultadId(facultadId);
		} catch (FacultadException e) {
			return "";
		}
		log.debug("Facultad -> {}", facultad);

		Geografica geografica = geograficaService.findByGeograficaId(inscripcion.getGeograficaId());
		log.debug("Geografica -> {}", geografica);
		Persona persona = personaService.findByPersonaIdAndDocumentoId(personaId, documentoId);
		log.debug("Persona -> {}", persona);
		Lectivo lectivo = lectivoService.findByLectivoId(lectivoId);
		log.debug("Lectivo -> {}", lectivo);
		Documento documento = documentoService.findByDocumentoId(documentoId);
		log.debug("Documento -> {}", documento);

		Nacimiento nacimiento = null;
		try {
			nacimiento = nacimientoService.findByUnique(personaId, documentoId);
		} catch (NacimientoException e) {
			nacimiento = new Nacimiento();
		}
		log.debug("Nacimiento -> {}", nacimiento);

		Legajo legajo = null;
		try {
			legajo = legajoService.findByPersona(personaId, documentoId, facultadId);
		} catch (LegajoException e) {
			legajo = new Legajo();
		}
		log.debug("Legajo -> {}", legajo);

		Domicilio domicilio = null;
		try {
			domicilio = domicilioService.findByPersonaIdAndDocumentoId(personaId, documentoId);
		} catch (DomicilioException e) {
			domicilio = new Domicilio();
		}
		log.debug("Domicilio -> {}", domicilio);

		Localidad localidad = null;
		try {
			localidad = localidadService.findByUnique(domicilio.getFacultadId(), domicilio.getProvinciaId(),
					domicilio.getLocalidadId());
		} catch (LocalidadException e) {
			localidad = new Localidad();
		}
		log.debug("Localidad -> {}", localidad);

		Provincia provincia = null;
		try {
			provincia = provinciaService.findByUnique(domicilio.getFacultadId(), domicilio.getProvinciaId());
		} catch (ProvinciaException e) {
			provincia = new Provincia();
		}
		log.debug("Provincia -> {}", provincia);

		Carrera carrera = null;
		try {
			carrera = carreraService.findByUnique(inscripcion.getFacultadId(), inscripcion.getPlanId(),
					inscripcion.getCarreraId());
		} catch (CarreraException e) {
			carrera = new Carrera();
		}
		log.debug("Carrera -> {}", carrera);

		String path = env.getProperty("path.files");

		String filename = path + "matricula-" + personaId + "-" + documentoId + "-" + facultadId + "-" + lectivoId
				+ ".pdf";

		try {
			Document document = new Document(new Rectangle(PageSize.A4));
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.setMargins(80, 30, 50, 50);
			document.open();

			float[] columnHeader = { 1, 9 };
			PdfPTable table = new PdfPTable(columnHeader);
			table.setWidthPercentage(100);

			Image image = null;
			if (facultadId == 15)
				image = Image.getInstance("marca_etec.png");
			else
				image = Image.getInstance("marca_um.png");
			image.scalePercent(80);
			PdfPCell cell = new PdfPCell(image);
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);
			Paragraph paragraph = new Paragraph("UNIVERSIDAD DE MENDOZA", new Font(Font.HELVETICA, 16, Font.BOLD));
			paragraph.add(new Phrase("\nFacultad de " + facultad.getNombre(), new Font(Font.HELVETICA, 14, Font.BOLD)));
			cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			document.add(table);

			paragraph = new Paragraph("Constancia de Matriculación", new Font(Font.HELVETICA, 14, Font.BOLD));
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			paragraph = new Paragraph(" ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph("    Señor/a Decano/a", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph("    Facultad de " + facultad.getNombre(),
					new Font(Font.HELVETICA, 11, Font.BOLD));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph(" ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			Phrase phrase = new Phrase("Se deja constancia que ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph = new Paragraph(phrase);
			phrase = new Phrase(persona.getApellido() + ", " + persona.getNombre(),
					new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", con ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(documento.getNombre() + " " + persona.getPersonaId(),
					new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(" nacido/a el ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			log.debug("Antes del nacimiento");
			if (nacimiento.getFecha() != null) {
				phrase = new Phrase(nacimiento.getFecha().toInstant().atZone(ZoneId.of("UTC")).toLocalDate()
						.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Font(Font.HELVETICA, 10, Font.BOLD));
				paragraph.add(phrase);
			}
			phrase = new Phrase(", legajo ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(String.valueOf(legajo.getNumeroLegajo()), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", con domicilio en ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(domicilio.getCalle() + " " + domicilio.getPuerta() + " " + domicilio.getPiso() + " "
					+ domicilio.getDpto() + " " + domicilio.getObservaciones() + " - " + localidad.getNombre() + " - "
					+ provincia.getNombre(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", Tel. ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(domicilio.getTelefono(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(" - Móvil: ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(domicilio.getMovil(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(" - e-mail Personal: ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(domicilio.getEmailPersonal(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(" - e-mail Institucional: ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(domicilio.getEmailInstitucional(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase("; ha sido matriculado en el ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(lectivo.getNombre(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", en la carrera de ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(carrera.getNombre(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", en el ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			phrase = new Phrase(inscripcion.getCurso().toString(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(" año. A continuación de detallan las materias a cursar:",
					new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph);

			paragraph = new Paragraph(" ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			Integer orden = 1;

			for (InscripcionDetalle inscripciondetalle : inscripcionDetalleService.findAllByPersona(
					inscripcion.getPersonaId(), inscripcion.getDocumentoId(), inscripcion.getFacultadId(),
					inscripcion.getLectivoId())) {
				Materia materia = null;
				try {
					materia = materiaService.findByUnique(inscripciondetalle.getFacultadId(),
							inscripciondetalle.getPlanId(), inscripciondetalle.getMateriaId());
				} catch (MateriaException e) {
					materia = new Materia();
				}

				table = new PdfPTable(1);
				table.setWidthPercentage(60);

				cell = new PdfPCell();
				phrase = new Phrase(orden++ + ". (" + inscripciondetalle.getMateriaId() + ") ",
						new Font(Font.HELVETICA, 8, Font.NORMAL));
				paragraph = new Paragraph(phrase);
				phrase = new Phrase(materia.getNombre(), new Font(Font.HELVETICA, 8, Font.BOLD));
				paragraph.add(phrase);
				if (inscripciondetalle.getRecursa() == 1) {
					phrase = new Phrase(" ( recursa )", new Font(Font.HELVETICA, 8, Font.NORMAL));
					paragraph.add(phrase);
				}
				paragraph.setAlignment(Element.ALIGN_CENTER);
				cell.addElement(paragraph);
				cell.setBorderWidth(1);
				table.addCell(cell);
				document.add(table);
			}

			paragraph = new Paragraph(" ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph("Declaro conocer el Reglamento de la Facultad y el Estatuto de la Universidad.",
					new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph("Declaro conocer y aceptar que:", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);

			paragraph = new Paragraph("Los aranceles aprobados por el HCS para el " + lectivo.getNombre()
					+ ", podrán experimentar reajustes parciales a lo largo del año si las circunstancias así lo aconsejaren.",
					new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph);

			phrase = new Phrase("En ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph = new Paragraph(phrase);
			phrase = new Phrase(geografica.getNombre(), new Font(Font.HELVETICA, 10, Font.BOLD));
			paragraph.add(phrase);
			phrase = new Phrase(", a los ", new Font(Font.HELVETICA, 10, Font.NORMAL));
			paragraph.add(phrase);
			if (inscripcion.getFecha() != null) {
				phrase = new Phrase(inscripcion.getFecha().toInstant().atZone(ZoneId.of("UTC")).toLocalDate()
						.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), new Font(Font.HELVETICA, 10, Font.BOLD));
				paragraph.add(phrase);
			}
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph);

			document.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return filename;
	}
}
