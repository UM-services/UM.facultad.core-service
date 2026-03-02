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
import um.facultad.rest.model.DomicilioEntity;
import um.facultad.rest.model.InscripcionEntity;
import um.facultad.rest.model.InscripcionPagoEntity;
import um.facultad.rest.model.PersonaEntity;
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

	public List<InscripcionEntity> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

	public List<InscripcionEntity> findAllByCurso(Integer facultadId, Integer lectivoId, Integer geograficaId,
												  Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(facultadId, lectivoId, geograficaId,
				curso);
	}

	public List<InscripcionEntity> findAllByCursoSinProvisoria(Integer facultadId, Integer lectivoId, Integer geograficaId,
															   Integer curso) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(facultadId, lectivoId, geograficaId,
				curso, (byte) 0);
	}

	public List<InscripcionEntity> findAllAnteriores(BigDecimal personaId, Integer documentoId, Integer facultadId,
													 Integer lectivoId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(
				personaId, documentoId, facultadId, lectivoId);
	}

	public InscripcionEntity findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		return repository
				.findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(facultadId, personaId, documentoId, lectivoId)
				.orElseThrow(() -> new InscripcionException(facultadId, personaId, documentoId, lectivoId));
	}

	public List<InscripcionEntity> saveAll(List<InscripcionEntity> inscriptos) {
		return repository.saveAll(inscriptos);
	}

    public InscripcionFullDto findInscripcionFull(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		InscripcionEntity inscripcion;
		try {
			inscripcion = findByUnique(facultadId, personaId, documentoId, lectivoId);
		} catch (InscripcionException e) {
			inscripcion = null;
		}
		InscripcionPagoEntity inscripcionPago;
		PersonaEntity personaPago;
		DomicilioEntity domicilioPago;
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
