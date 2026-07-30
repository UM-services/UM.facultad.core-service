package um.facultad.rest.hexagonal.tesoreriaEstado.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import um.facultad.rest.model.Auditable;

@Getter
@Setter
@Builder
@Entity
@Table(name = "tesestado", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "Tes_Fac_ID", "Tes_Per_ID", "Tes_Doc_ID" }) })
@NoArgsConstructor
@AllArgsConstructor
public class TesoreriaEstadoEntity extends Auditable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tes_ID")
    private Long tesoreriaEstadoId;

    @Column(name = "Tes_Fac_ID")
    private Integer facultadId;

    @Column(name = "Tes_Per_ID")
    private BigDecimal personaId;

    @Column(name = "Tes_Doc_ID")
    private Integer documentoId;

    @Column(name = "Tes_Deuda")
    private BigDecimal deuda;

    @Builder.Default
    @Column(name = "Tes_Manual")
    private Byte manual = 0;

    @Builder.Default
    @Column(name = "Tes_Importado")
    private Byte importado = 0;

    @Builder.Default
    @Column(name = "Tes_Observaciones")
    private String observaciones = "";

    @Column(name = "Tes_Fecha")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
    private OffsetDateTime fechaTope;

    @Builder.Default
    private String uuid = "";

}
