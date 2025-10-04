/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.Persona;
import um.facultad.rest.repository.PersonaRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class PersonaService {
	
	private final PersonaRepository repository;

	public List<Persona> findAllByPersonaIdIn(List<BigDecimal> numeros) {
		return repository.findAllByPersonaIdIn(numeros, Sort.by("apellido").ascending().and(Sort.by("nombre").ascending()));
	}

	public Persona findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
		return repository.findByPersonaIdAndDocumentoId(personaId, documentoId).orElse(new Persona());
	}

}
