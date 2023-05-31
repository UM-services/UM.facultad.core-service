/**
 * 
 */
package um.facultad.rest.model.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table(name = "vw_alumno_examen")
@Immutable
public class AlumnoExamen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2177145633616263565L;

	@Id
	private Long examenId;
	
	private Integer facultadId;
	private BigDecimal personaId;
	private Integer documentoId;
	private String apellido;
	private String nombre;
	private Long numeroLegajo;
	private String carrera;
	private String llamado;
	private Integer geograficaId;
	private String sede;
	private String plan;
	private String materiaId;
	private String materia;
	private LocalDate fecha;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "UTC")
	private Instant hora;
}
