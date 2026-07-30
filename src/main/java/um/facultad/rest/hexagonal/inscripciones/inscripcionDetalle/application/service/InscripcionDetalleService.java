package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.model.InscripcionDetalle;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in.FindInscripcionesDetalleByPersonaUseCase;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.domain.ports.in.SaveAllInscripcionesDetalleUseCase;

@Service
@RequiredArgsConstructor
public class InscripcionDetalleService {

	private final FindInscripcionesDetalleByPersonaUseCase findInscripcionesDetalleByPersonaUseCase;
	private final SaveAllInscripcionesDetalleUseCase saveAllInscripcionesDetalleUseCase;

	public List<InscripcionDetalle> findAllByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId,
													 Integer lectivoId) {
		return findInscripcionesDetalleByPersonaUseCase.findByPersona(personaId, documentoId, facultadId, lectivoId);
	}

	public List<InscripcionDetalle> saveAll(List<InscripcionDetalle> inscripcionesDetalle) {
		return saveAllInscripcionesDetalleUseCase.saveAll(inscripcionesDetalle);
	}

}
