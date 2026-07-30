package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.usecases;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in.FindInscripcionesDetalleByPersonaUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.out.InscripcionDetalleRepository;

@Component
@RequiredArgsConstructor
public class FindInscripcionesDetalleByPersonaUseCaseImpl implements FindInscripcionesDetalleByPersonaUseCase {

    private final InscripcionDetalleRepository repository;

    @Override
    public List<InscripcionDetalle> findByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId) {
        return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoId(personaId, documentoId, facultadId, lectivoId);
    }

}
