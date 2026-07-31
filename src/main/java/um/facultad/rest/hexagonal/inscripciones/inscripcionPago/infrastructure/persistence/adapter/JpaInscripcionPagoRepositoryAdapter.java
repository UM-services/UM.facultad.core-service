package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.adapter;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.out.InscripcionPagoRepository;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.mapper.InscripcionPagoMapper;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.infrastructure.persistence.repository.JpaInscripcionPagoRepository;

@Component
@RequiredArgsConstructor
public class JpaInscripcionPagoRepositoryAdapter implements InscripcionPagoRepository {

    private final JpaInscripcionPagoRepository jpaRepository;
    private final InscripcionPagoMapper mapper;

    @Override
    public Optional<InscripcionPago> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return jpaRepository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
                .map(mapper::toDomain);
    }

}
