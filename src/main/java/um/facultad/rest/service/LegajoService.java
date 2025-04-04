/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import um.facultad.rest.kotlin.model.Legajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LegajoException;
import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.PreInscripcion;
import um.facultad.rest.model.view.LegajoKey;
import um.facultad.rest.repository.LegajoRepository;
import um.facultad.rest.service.view.LegajoKeyService;

/**
 * @author daniel
 *
 */
@Service
public class LegajoService {

	private final LegajoRepository repository;
	private final InscripcionService inscripcionService;
	private final LegajoKeyService legajokeyService;
	private final PreInscripcionService preinscripcionService;

	public LegajoService(LegajoRepository repository,
						 InscripcionService inscripcionService,
						 LegajoKeyService legajokeyService,
						 PreInscripcionService preinscripcionService) {
		this.repository = repository;
		this.inscripcionService = inscripcionService;
		this.legajokeyService = legajokeyService;
		this.preinscripcionService = preinscripcionService;
	}

	public List<Legajo> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId) {
		return repository.findAllByPersonaIdInAndFacultadId(numeros, facultadId);
	}

	public List<LegajoKey> findAllByPreuniversitario(Integer facultadId, Integer lectivoId, Integer geograficaId) {
		List<String> preinscriptoKeys = preinscripcionService.findAllBySede(facultadId, lectivoId, geograficaId)
				.stream().map(PreInscripcion::getPersonaKey).collect(Collectors.toList());
		return legajokeyService.findAllByFacultadAndPersonaKeys(facultadId, preinscriptoKeys);
	}

	public List<Legajo> numeraByLectivoId(Integer facultadId, Integer lectivoId) {
		Map<String, Inscripcion> inscripciones = inscripcionService.findAllByLectivo(facultadId, lectivoId).stream()
				.collect(Collectors.toMap(Inscripcion::getKey, inscripcion -> inscripcion));
		List<LegajoKey> sin_legajos = legajokeyService.findAllByFacultadIdAndIntercambioAndNumerolegajoAndPersonakeyIn(
				facultadId, (byte) 0, 0L, inscripciones.keySet());
		List<Legajo> legajos = new ArrayList<Legajo>();
		for (LegajoKey legajo : sin_legajos) {
			legajos.add(asignaNumeroLegajo(facultadId, lectivoId, legajo.getPersonaId(), legajo.getDocumentoId()));
		}
		return legajos;
	}

	public Legajo findByPersona(BigDecimal personaId, Integer documentoId, Integer facultadId) {
		return repository.findByPersonaIdAndDocumentoIdAndFacultadId(personaId, documentoId, facultadId)
				.orElseThrow(() -> new LegajoException(personaId, documentoId, facultadId));
	}

	public Legajo asignaNumeroLegajo(Integer facultadId, Integer lectivoId, BigDecimal personaId, Integer documentoId) {
		// Verifica si ya tiene número de legajo
		Legajo legajo;
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

		Map<Long, Legajo> ocupados = repository.findAllByFacultadIdAndNumeroLegajoBetween(facultadId, minimo, maximo)
				.stream().collect(Collectors.toMap(Legajo::getNumeroLegajo, legajo -> legajo));

		List<Long> disponibles = new ArrayList<Long>();
		for (Long posible = minimo; posible <= maximo; posible++) {
			if (!ocupados.containsKey(posible)) {
				disponibles.add(posible);
			}
		}
		return disponibles.getFirst();
	}

}
