/**
 * 
 */
package um.facultad.rest.service.facade;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import um.facultad.rest.kotlin.model.Legajo;
import um.facultad.rest.kotlin.model.Persona;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.Carrera;
import um.facultad.rest.model.Estado;
import um.facultad.rest.model.Facultad;
import um.facultad.rest.model.Geografica;
import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.Lectivo;
import um.facultad.rest.service.CarreraService;
import um.facultad.rest.service.EstadoAlumnoService;
import um.facultad.rest.service.EstadoService;
import um.facultad.rest.service.FacultadService;
import um.facultad.rest.service.GeograficaService;
import um.facultad.rest.service.InscripcionService;
import um.facultad.rest.service.LectivoService;
import um.facultad.rest.service.LegajoService;
import um.facultad.rest.service.PersonaService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class SheetService {

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private LectivoService lectivoService;

	@Autowired
	private GeograficaService geograficaService;

	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private PersonaService personaService;

	@Autowired
	private LegajoService legajoService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private EstadoAlumnoService estadoAlumnoService;

	@Autowired
	private CarreraService carreraService;

	public String generateMatriculaCurso(Integer facultadId, Integer lectivoId, Integer geograficaId, Integer curso) {

		Facultad facultad = facultadService.findByFacultadId(facultadId);
		Lectivo lectivo = lectivoService.findByLectivoId(lectivoId);
		Geografica geografica = geograficaService.findByGeograficaId(geograficaId);

		String filename = "matriculas." + facultadId + "." + lectivoId + "." + geograficaId + "." + curso + ".xlsx";

		Workbook book = new XSSFWorkbook();
		CellStyle style_normal = book.createCellStyle();
		Font font_normal = book.createFont();
		font_normal.setBold(false);
		style_normal.setFont(font_normal);

		Sheet sheet = book.createSheet("Matriculas");
		Row row = null;
		Integer fila = -1;
		row = sheet.createRow(++fila);
		this.setCellString(row, 2, "Universidad de Mendoza", style_normal);
		row = sheet.createRow(++fila);
		this.setCellString(row, 2, "Facultad de " + facultad.getNombre(), style_normal);
		row = sheet.createRow(++fila);
		this.setCellString(row, 2, lectivo.getNombre(), style_normal);
		row = sheet.createRow(++fila);
		this.setCellString(row, 2, "Sede: " + geografica.getNombre(), style_normal);
		++fila;
		row = sheet.createRow(++fila);
		this.setCellString(row, 2, "Alumnos por Curso", style_normal);
		row = sheet.createRow(++fila);
		this.setCellString(row, 0, "Curso: " + curso, style_normal);
		++fila;
		row = sheet.createRow(++fila);
		this.setCellString(row, 0, "Orden", style_normal);
		this.setCellString(row, 1, "Legajo", style_normal);
		this.setCellString(row, 2, "Apellido, Nombre", style_normal);
		this.setCellString(row, 3, "Estado", style_normal);
		this.setCellString(row, 4, "Documento", style_normal);
		this.setCellString(row, 5, "Carrera", style_normal);

		Map<BigDecimal, Inscripcion> inscriptos = inscripcionService
				.findAllByCurso(facultadId, lectivoId, geograficaId, curso).stream()
				.collect(Collectors.toMap(Inscripcion::getPersonaId, inscripcion -> inscripcion));
		List<BigDecimal> numeros = new ArrayList<BigDecimal>(inscriptos.keySet());
		Map<BigDecimal, Legajo> legajos = legajoService.findAllByPersonaIdInAndFacultadId(numeros, facultadId).stream()
				.collect(Collectors.toMap(Legajo::getPersonaId, legajo -> legajo));
		Map<BigDecimal, Estado> estados = estadoService.findAllByPersonaIdInAndFacultadId(numeros, facultadId).stream()
				.collect(Collectors.toMap(Estado::getPersonaId, estado -> estado));
		// Carreras
		Map<String, Carrera> carreras = carreraService.findAll().stream()
				.collect(Collectors.toMap(Carrera::getKey, carrera -> carrera));

		Integer orden = 0;
		for (Persona persona : personaService.findAllByPersonaIdIn(numeros)) {
			row = sheet.createRow(++fila);
			Long numero_legajo = 0L;
			if (legajos.containsKey(persona.getPersonaId()))
				numero_legajo = legajos.get(persona.getPersonaId()).getNumeroLegajo();
			String estado = "";
			if (estados.containsKey(persona.getPersonaId())) {
				estado = estadoAlumnoService.findByEstadoId(estados.get(persona.getPersonaId()).getEstadoId())
						.getIniciales();
			}
			Inscripcion inscripcion = inscriptos.get(persona.getPersonaId());
			String key = inscripcion.getFacultadId() + "." + inscripcion.getPlanId() + "." + inscripcion.getCarreraId();
			String carrera = "";
			if (carreras.containsKey(key))
				carrera = carreras.get(key).getNombre();
			this.setCellInteger(row, 0, ++orden, style_normal);
			this.setCellLong(row, 1, numero_legajo, style_normal);
			this.setCellString(row, 2, persona.getApellido() + ", " + persona.getNombre(), style_normal);
			this.setCellString(row, 3, estado, style_normal);
			this.setCellBigDecimal(row, 4, persona.getPersonaId(), style_normal);
			this.setCellString(row, 5, carrera, style_normal);
		}

		for (Integer column = 0; column < sheet.getRow(8).getPhysicalNumberOfCells(); column++)
			sheet.autoSizeColumn(column);

		try {
			File file = new File(filename);
			FileOutputStream output = new FileOutputStream(file);
			book.write(output);
			output.flush();
			output.close();
			log.debug(file.getAbsolutePath());
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}

	private void setCellBigDecimal(Row row, int column, BigDecimal value, CellStyle style) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value.doubleValue());
		cell.setCellStyle(style);
	}

	private void setCellString(Row row, int column, String value, CellStyle style) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	private void setCellLong(Row row, int column, Long value, CellStyle style) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	private void setCellInteger(Row row, int column, Integer value, CellStyle style) {
		Cell cell = row.createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

}
