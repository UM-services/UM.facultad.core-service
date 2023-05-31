/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import um.facultad.rest.model.pk.TituloEntregaPk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table(name = "titentrega")
@IdClass(TituloEntregaPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class TituloEntrega implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4044183344591453933L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	@Id
	@Column(name = "idplan")
	private Integer planId;

	@Id
	@Column(name = "idcarrera")
	private Integer carreraId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tit_id")
	private Long tituloentregaId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime inicio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime entrega;

	private Long folio;
	private Integer libro;

	@Column(name = "tit_ministerio")
	private String ministerio;

	@Column(name = "tit_formula")
	private String formula;

	@Column(name = "tit_titulo_grado")
	private String titulogrado;

	@Column(name = "tit_titulo_trabajo")
	private String titulotrabajo;

	@Column(name = "tit_per_id_asesor")
	private BigDecimal personaIdasesor;

	@Column(name = "tit_doc_id_asesor")
	private Integer documentoIdasesor;

	@Column(name = "tit_fecha_ultima")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fechaultima;

	@Column(name = "tit_mat_id_ultima")
	private String materiaIdultima;

	@Column(name = "tit_libro_ultima")
	private String libroultima;

	@Column(name = "tit_folio_ultima")
	private Long folioultima;

	@Column(name = "tit_geo_id")
	private Integer geograficaId;

}
