/**
 * 
 */
package ar.edu.um.facultad.rest.service.facade;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.DivisionNotFoundException;
import ar.edu.um.facultad.rest.exception.DomicilioNotFoundException;
import ar.edu.um.facultad.rest.exception.MateriaNotFoundException;
import ar.edu.um.facultad.rest.model.Division;
import ar.edu.um.facultad.rest.model.Domicilio;
import ar.edu.um.facultad.rest.model.Materia;
import ar.edu.um.facultad.rest.model.view.InscriptoMateria;
import ar.edu.um.facultad.rest.service.DivisionService;
import ar.edu.um.facultad.rest.service.DomicilioService;
import ar.edu.um.facultad.rest.service.MateriaService;
import ar.edu.um.facultad.rest.service.view.InscriptoMateriaService;

/**
 * @author daniel
 *
 */
@Service
public class InscriptosToXlsService {

	@Autowired
	private InscriptoMateriaService inscriptoMateriaService;

	@Autowired
	private DomicilioService domicilioService;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private DivisionService divisionService;

	@Autowired
	private Environment env;

	public String generateListaXls(Integer facultadId, Integer lectivoId, Integer planId, String materiaId,
			Integer cursoId, Integer periodoId, Integer divisionId, Integer geograficaId) {
		String path = env.getProperty("path.files");

		String filename = path + "lista-" + facultadId + "-" + lectivoId + "-" + planId + "-" + materiaId + "-"
				+ cursoId + "-" + periodoId + "-" + divisionId + "-" + geograficaId + ".xls";

		Materia materia = new Materia();
		try {
			materia = materiaService.findByUnique(facultadId, planId, materiaId);
		} catch (MateriaNotFoundException e) {

		}
		Division division = new Division();
		try {
			division = divisionService.findByUnique(facultadId, divisionId);
		} catch (DivisionNotFoundException e) {

		}
		Workbook book = new HSSFWorkbook();
		CellStyle style_bold = book.createCellStyle();
		CellStyle style_normal = book.createCellStyle();
		Font font_bold = book.createFont();
		font_bold.setBold(true);
		style_bold.setFont(font_bold);
		Font font_normal = book.createFont();
		font_normal.setBold(false);
		style_normal.setFont(font_normal);

		Sheet sheet = book.createSheet("Lista");
		Row row = null;
		Cell cell = null;
		Integer fila = 0;
		row = sheet.createRow(fila);
		cell = row.createCell(2);
		cell.setCellValue(materia.getNombre() + " (" + materia.getMateriaId() + ")");
		cell.setCellStyle(style_bold);
		String periodo[] = { "Anual", "1er Semestre", "2do Semestre" };
		cell = row.createCell(3);
		cell.setCellValue(periodo[periodoId]);
		cell.setCellStyle(style_bold);
		cell = row.createCell(4);
		cell.setCellValue(division.getNombre());
		cell.setCellStyle(style_bold);

		row = sheet.createRow(++fila);
		cell = row.createCell(0);
		cell.setCellValue("Orden");
		cell.setCellStyle(style_bold);
		cell = row.createCell(1);
		cell.setCellValue("Legajo");
		cell.setCellStyle(style_bold);
		cell = row.createCell(2);
		cell.setCellValue("Apellido, Nombre");
		cell.setCellStyle(style_bold);
		cell = row.createCell(3);
		cell.setCellValue("Carrera");
		cell.setCellStyle(style_bold);
		cell = row.createCell(4);
		cell.setCellValue("Curso");
		cell.setCellStyle(style_bold);
		cell = row.createCell(5);
		cell.setCellValue("Recursa");
		cell.setCellStyle(style_bold);
		cell = row.createCell(6);
		cell.setCellValue("Condicional");
		cell.setCellStyle(style_bold);
		cell = row.createCell(7);
		cell.setCellValue("e-mail Institucional");
		cell.setCellStyle(style_bold);
		cell = row.createCell(8);
		cell.setCellValue("e-mail Personal");
		cell.setCellStyle(style_bold);
		for (InscriptoMateria inscripto : inscriptoMateriaService.findAllByDivision(facultadId, lectivoId, planId,
				materiaId, cursoId, periodoId, divisionId, geograficaId)) {
			Domicilio domicilio = new Domicilio();
			try {
				domicilio = domicilioService.findByPersonaIdAndDocumentoId(inscripto.getPersonaId(),
						inscripto.getDocumentoId());
			} catch (DomicilioNotFoundException e) {

			}
			row = sheet.createRow(++fila);
			cell = row.createCell(0);
			cell.setCellValue(fila - 1);
			cell.setCellStyle(style_normal);
			cell = row.createCell(1);
			cell.setCellValue(inscripto.getNumerolegajo());
			cell.setCellStyle(style_normal);
			cell = row.createCell(2);
			cell.setCellValue(inscripto.getApellido() + ", " + inscripto.getNombre());
			cell.setCellStyle(style_normal);
			cell = row.createCell(3);
			cell.setCellValue(inscripto.getCarreranombre());
			cell.setCellStyle(style_normal);
			cell = row.createCell(4);
			cell.setCellValue(inscripto.getCurso());
			cell.setCellStyle(style_normal);
			cell = row.createCell(5);
			cell.setCellValue(inscripto.getRecursa() == 1 ? "Sí" : "");
			cell.setCellStyle(style_normal);
			cell = row.createCell(6);
			cell.setCellValue(inscripto.getCondicional() == 1 ? "Sí" : "");
			cell.setCellStyle(style_normal);
			cell = row.createCell(7);
			cell.setCellValue(domicilio.getEmailInstitucional());
			cell.setCellStyle(style_normal);
			cell = row.createCell(8);
			cell.setCellValue(domicilio.getEmailPersonal());
			cell.setCellStyle(style_normal);
		}

		for (Integer column = 0; column < sheet.getRow(1).getPhysicalNumberOfCells(); column++)
			sheet.autoSizeColumn(column);

		try {
			FileOutputStream output = new FileOutputStream(new File(filename));
			book.write(output);
			output.flush();
			output.close();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}

}
