package um.facultad.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"iddocumento", "idtipodoc"})})
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long uniqueId;

    @Column(name = "iddocumento")
    private BigDecimal personaId;

    @Column(name = "idtipodoc")
    private Integer documentoId;

    private String apellido;
    private String nombre;
    private String sexo;

    @Column(name = "per_pro_id")
    private Integer profesionId;

    @Column(name = "per_mascara")
    private String mascara;

}
