/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LegajoException;
import um.facultad.rest.model.InscripcionEntity;
import um.facultad.rest.model.LegajoEntity;
import um.facultad.rest.model.PreInscripcionEntity;
import um.facultad.rest.model.view.LegajoKey;
import um.facultad.rest.repository.LegajoRepository;
import um.facultad.rest.service.view.LegajoKeyService;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class LegajoService {

	private final LegajoRepository repository;
	private final InscripcionService inscripcionService;
	private final LegajoKeyService legajokeyService;
	private final PreInscripcionService preinscripcionService;

	public List<LegajoEntity> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId) {
		return repository.findAllByPersonaIdInAndFacultadId(numeros, facultadId);
	}

	public List<LegajoKey> findAllByPreuniversitario(Integer facultadId, Integer lectivoId, Integer geograficaId) {
		List<String> preinscriptoKeys = preinscripcionService.findAllBySede(facultadId, lectivoId, geograficaId)
				.stream().map(PreInscripcionEntity::getPersonaKey).collect(Collectors.toList());
		return legajokeyService.findAllByFacultadAndPersonaKeys(facultadId, preinscriptoKeys);
	}

	public List<LegajoEntity> numeraByLectivoId(Integer facultadId, Integer lectivoId) {
		Map<String, InscripcionEntity> inscripciones = inscripcionService.findAllByLectivo(facultadId, lectivoId).stream()
				.collect(Collectors.toMap(InscripcionEntity::getKey, inscripcion -> inscripcion));
		List<LegajoKey> sin_legajos = legajokeyService.findAllByFacultadIdAndIntercambioAndNumerolegajoAndPersonakeyIn(
				facultadId, (byte) 0, 0L, inscripciones.keySet());
		List<LegajoEntity> legajos = new ArrayList<LegajoEntity>();
		for (LegajoKey legajo : sin_legajos) {
			legajos.add(asignaNumeroLegajo(facultadId, lectivoId, legajo.getPersonaId(), legajo.getDocumentoId()));
		}
		return legajos;
	}

	public LegajoEntity findByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId) {
		return repository.findByPersonaIdAndDocumentoIdAndFacultadId(personaId, documentoId, facultadId)
				.orElseThrow(() -> new LegajoException(personaId, documentoId, facultadId));
	}

	public LegajoEntity asignaNumeroLegajo(Integer facultadId, Integer lectivoId, BigDecimal personaId, Integer documentoId) {
		// Verifica si ya tiene número de legajo
		LegajoEntity legajo;
		try {
			legajo = findByPersona(personaId, documentoId, facultadId);
		} catch (LegajoException e) {
			return null;
		}
		if (legajo.getNumeroLegajo() > 0) {
			return legajo;
		}
		legajo.setLectivoId(lectivoId);
		legajo.setNumeroLegajo(newByLectivoId(facultadId, lectivoId));
		legajo = repository.save(legajo);
		return legajo;
	}

	private Long newByLectivoId(Integer facultadId, Integer lectivoId) {
		long minimo = 1 + (lectivoId + 29L) * 1000L;
		Long maximo = minimo + 998;

		Map<Long, LegajoEntity> ocupados = repository.findAllByFacultadIdAndNumeroLegajoBetween(facultadId, minimo, maximo)
				.stream().collect(Collectors.toMap(LegajoEntity::getNumeroLegajo, legajo -> legajo));

		List<Long> disponibles = new ArrayList<Long>();
		for (Long posible = minimo; posible <= maximo; posible++) {
			if (!ocupados.containsKey(posible)) {
				disponibles.add(posible);
			}
		}
		return disponibles.getFirst();
	}

}
