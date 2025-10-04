package um.facultad.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "aluleg", uniqueConstraints = {@UniqueConstraint(columnNames = {"iddocumento", "idtipodoc", "idfacultad"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Legajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long legajoId;

    @Column(name = "iddocumento")
    private BigDecimal personaId;

    @Column(name = "idtipodoc")
    private Integer documentoId;

    @Column(name = "idfacultad")
    private Integer facultadId;

    @Column(name = "ale_geo_id")
    private Integer geograficaId;

    @Column(name = "idlegajo")
    private Long numeroLegajo = 0L;

    @Column(name = "ale_lec_id")
    private Integer lectivoId;

    @Column(name = "ale_fecha")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fecha;

    @Column(name = "ale_pla_id")
    private Integer planId;

    @Column(name = "ale_car_id")
    private Integer carreraId;

    @Column(name = "ale_clave")
    private String contrasenha;

    @Column(name = "ale_intercambio")
    private Byte intercambio = 0;

}
