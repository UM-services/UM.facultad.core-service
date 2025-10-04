/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.InscripcionException;
import um.facultad.rest.exception.InscripcionPagoException;
import um.facultad.rest.model.Domicilio;
import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.InscripcionPago;
import um.facultad.rest.model.Persona;
import um.facultad.rest.model.dto.InscripcionFullDto;
import um.facultad.rest.repository.InscripcionRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class InscripcionService {

	private final InscripcionRepository repository;
	private final InscripcionPagoService inscripcionPagoService;
	private final PersonaService personaService;
	private final DomicilioService domicilioService;

	public List<Inscripcion> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

	public List<Inscripcion> findAllByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(facultadId, lectivoId, geograficaId,
				curso);
	}

	public List<Inscripcion> findAllByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId,
			Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(facultadId, lectivoId, geograficaId,
				curso, (byte) 0);
	}

	public List<Inscripcion> findAllAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer lectivoId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(
				personaId, documentoId, facultadId, lectivoId);
	}

	public Inscripcion findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository
				.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
				.orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
	}

	public List<Inscripcion> saveAll(List<Inscripcion> inscriptos) {
		return repository.saveAll(inscriptos);
	}

    public InscripcionFullDto findInscripcionFull(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		Inscripcion inscripcion;
		try {
			inscripcion = findByUnique(facultadId, personaId, documentoId, lectivoId);
		} catch (InscripcionException e) {
			inscripcion = null;
		}
		InscripcionPago inscripcionPago;
		Persona personaPago;
		Domicilio domicilioPago;
		try {
			inscripcionPago = inscripcionPagoService.findByUnique(facultadId, personaId, documentoId, lectivoId);
			personaPago = personaService.findByPersonaIdAndDocumentoId(inscripcionPago.getPersonaIdPagador(), inscripcionPago.getDocumentoId());
			domicilioPago = domicilioService.findByPersonaIdAndDocumentoId(personaPago.getPersonaId(), personaPago.getDocumentoId());
		} catch (InscripcionPagoException e) {
			inscripcionPago = null;
			personaPago = null;
			domicilioPago = null;
		}

		return InscripcionFullDto.builder()
				.inscripcion(inscripcion)
				.inscripcionPago(inscripcionPago)
				.personaPago(personaPago)
				.domicilioPago(domicilioPago)
				.build();
    }

}
