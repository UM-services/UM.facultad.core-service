package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.entity.InscripcionDetalleEntity;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.entity.pk.InscripcionDetallePk;

@Repository
public interface JpaInscripcionDetalleRepository extends JpaRepository<InscripcionDetalleEntity, InscripcionDetallePk> {

    List<InscripcionDetalleEntity> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(BigDecimal personaId,
                                                                                             Integer documentoId, Integer facultadId, Integer lectivoId);

}
