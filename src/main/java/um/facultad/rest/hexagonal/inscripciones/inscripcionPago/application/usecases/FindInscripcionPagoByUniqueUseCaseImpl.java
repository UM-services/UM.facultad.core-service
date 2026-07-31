package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.usecases;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.in.FindInscripcionPagoByUniqueUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.out.InscripcionPagoRepository;

@Component
@RequiredArgsConstructor
public class FindInscripcionPagoByUniqueUseCaseImpl implements FindInscripcionPagoByUniqueUseCase {

    private final InscripcionPagoRepository repository;

    @Override
    public Optional<InscripcionPago> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return repository.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId);
    }

}
