package um.facultad.rest.kotlin.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.OffsetDateTime

@Entity
@Table(name = "aluleg", uniqueConstraints = [UniqueConstraint(columnNames = ["iddocumento", "idtipodoc", "idfacultad"])])
data class Legajo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var legajoId: Long? = null,

    @Column(name = "iddocumento")
    var personaId: BigDecimal? = null,

    @Column(name = "idtipodoc")
    var documentoId: Int? = null,

    @Column(name = "idfacultad")
    var facultadId: Int? = null,

    @Column(name = "ale_geo_id")
    var geograficaId: Int? = null,

    @Column(name = "idlegajo")
    var numeroLegajo: Long = 0L,

    @Column(name = "ale_lec_id")
    var lectivoId: Int? = null,

    @Column(name = "ale_fecha")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    var fecha: OffsetDateTime? = null,

    @Column(name = "ale_pla_id")
    var planId: Int? = null,

    @Column(name = "ale_car_id")
    var carreraId: Int? = null,

    @Column(name = "ale_clave")
    var contrasenha: String? = null,

    @Column(name = "ale_intercambio")
    var intercambio: Byte = 0,

    )
