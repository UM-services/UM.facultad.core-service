package ar.edu.um.facultad.rest.kotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.math.BigDecimal

@Entity
@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["iddocumento", "idtipodoc"])])
data class Persona(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var uniqueId: Long? = null,

    @Column(name = "iddocumento")
    var personaId: BigDecimal? = null,

    @Column(name = "idtipodoc")
    var documentoId: Int? = null,

    var apellido: String? = null,
    var nombre: String? = null,
    var sexo: String? = null,

    @Column(name = "per_pro_id")
    var profesionId: Int? = null,

    @Column(name = "per_mascara")
    var mascara: String? = null,

    )
