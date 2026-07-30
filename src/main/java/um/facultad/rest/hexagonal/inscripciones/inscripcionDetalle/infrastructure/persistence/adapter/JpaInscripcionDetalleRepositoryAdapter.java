package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.adapter;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.out.InscripcionDetalleRepository;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.mapper.InscripcionDetalleMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.repository.JpaInscripcionDetalleRepository;

@Component
@RequiredArgsConstructor
public class JpaInscripcionDetalleRepositoryAdapter implements InscripcionDetalleRepository {

    private final JpaInscripcionDetalleRepository jpaRepository;
    private final InscripcionDetalleMapper mapper;

    @Override
    public List<InscripcionDetalle> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return jpaRepository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(personaId, documentoId, facultadId, lectivoId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<InscripcionDetalle> saveAll(List<InscripcionDetalle> inscripcionesDetalle) {
        return jpaRepository.saveAll(inscripcionesDetalle.stream().map(mapper::toEntity).toList())
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

}
