package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.application.exception.InscripcionPagoException;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.ports.in.FindInscripcionPagoByUniqueUseCase;

@Service
@RequiredArgsConstructor
public class InscripcionPagoService {

    private final FindInscripcionPagoByUniqueUseCase findInscripcionPagoByUniqueUseCase;

    public InscripcionPago findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
        return findInscripcionPagoByUniqueUseCase.findByUnique(facultadId, personaId, documentoId, lectivoId)
                .orElseThrow(() -> new InscripcionPagoException(facultadId, personaId, documentoId, lectivoId));
    }

}
