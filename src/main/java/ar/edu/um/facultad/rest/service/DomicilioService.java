/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ar.edu.um.facultad.rest.exception.DomicilioNotFoundException;
import ar.edu.um.facultad.rest.exception.SetupApiNotFoundException;
import ar.edu.um.facultad.rest.model.Domicilio;
import ar.edu.um.facultad.rest.model.InscripcionPago;
import ar.edu.um.facultad.rest.model.SetupApi;
import ar.edu.um.facultad.rest.repository.IDomicilioRepository;
import ar.edu.um.facultad.rest.repository.IInscripcionPagoRepository;
import ar.edu.um.facultad.rest.repository.ISetupApiRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author daniel
 *
 */
@Service
@Slf4j
public class DomicilioService {
	@Autowired
	private IDomicilioRepository repository;

	@Autowired
	private ISetupApiRepository setupApiRepository;

	@Autowired
	private IInscripcionPagoRepository inscripcionPagoRepository;

	public Domicilio findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
		Domicilio domicilio = repository.findByPersonaIdAndDocumentoId(personaId, documentoId).orElse(new Domicilio());
		log.debug("Domicilio -> {}", domicilio);
		return domicilio;
	}

	public Domicilio findByPagador(BigDecimal personaId, Integer documentoId) {
		InscripcionPago inscripcionPago = inscripcionPagoRepository
				.findTopByPersonaIdAndDocumentoIdOrderByLectivoIdDesc(personaId, documentoId).orElse(null);
		if (inscripcionPago == null)
			return new Domicilio();
		log.debug("InscripcionPago -> " + inscripcionPago);
		return repository
				.findByPersonaIdAndDocumentoId(inscripcionPago.getPersonaIdpagador(),
						inscripcionPago.getDocumentoIdpagador())
				.orElseThrow(() -> new DomicilioNotFoundException(personaId, documentoId));
	}

	@Transactional
	public Domicilio add(Domicilio domicilio, Boolean sincronize) {
		domicilio.setFecha(OffsetDateTime.now());
		repository.save(domicilio);

		if (sincronize)
			this.sincronizeTesoreria(domicilio);

		return domicilio;
	}

	@Transactional
	public Domicilio update(Domicilio newDomicilio, BigDecimal personaId, Integer documentoId, Boolean sincronize) {
		return repository.findByPersonaIdAndDocumentoId(personaId, documentoId).map(domicilio -> {
			domicilio.setCalle(newDomicilio.getCalle());
			domicilio.setPuerta(newDomicilio.getPuerta());
			domicilio.setPiso(newDomicilio.getPiso());
			domicilio.setDpto(newDomicilio.getDpto());
			domicilio.setTelefono(newDomicilio.getTelefono());
			domicilio.setMovil(newDomicilio.getMovil());
			domicilio.setObservaciones(newDomicilio.getObservaciones());
			domicilio.setCodigoPostal(newDomicilio.getCodigoPostal());
			domicilio.setProvinciaId(newDomicilio.getProvinciaId());
			domicilio.setFacultadId(newDomicilio.getFacultadId());
			domicilio.setLocalidadId(newDomicilio.getLocalidadId());
			domicilio.setEmailPersonal(newDomicilio.getEmailPersonal());
			domicilio.setEmailInstitucional(newDomicilio.getEmailInstitucional());
			domicilio.setLaboral(newDomicilio.getLaboral());
			domicilio.setFecha(OffsetDateTime.now());
			repository.save(domicilio);

			if (sincronize)
				this.sincronizeTesoreria(domicilio);

			return domicilio;
		}).orElseThrow(() -> new DomicilioNotFoundException(personaId, documentoId));
	}

	private void sincronizeTesoreria(Domicilio domicilio) {
		RestTemplate restTemplate = new RestTemplate();
		SetupApi setupapi = setupApiRepository.findTopByOrderBySetupId()
				.orElseThrow(() -> new SetupApiNotFoundException());
		String url = "http://" + setupapi.getApiservertesoreria() + ":" + setupapi.getApiporttesoreria()
				+ "/domicilio/sincronize";
		Domicilio otro_domicilio = restTemplate.postForObject(url, domicilio, Domicilio.class);
		log.debug(otro_domicilio.toString());
	}

	public Domicilio sincronize(Domicilio domicilio) {
		Domicilio otro_domicilio = repository
				.findByPersonaIdAndDocumentoId(domicilio.getPersonaId(), domicilio.getDocumentoId())
				.orElse(new Domicilio());
		if (otro_domicilio.getDomicilioId() == null)
			otro_domicilio = this.add(domicilio, false);
		else
			otro_domicilio = this.update(domicilio, otro_domicilio.getPersonaId(), otro_domicilio.getDocumentoId(),
					false);
		return otro_domicilio;
	}

}
