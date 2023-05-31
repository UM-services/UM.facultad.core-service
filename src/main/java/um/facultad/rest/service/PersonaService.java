/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import um.facultad.rest.kotlin.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import um.facultad.rest.repository.IPersonaRepository;

/**
 * @author daniel
 *
 */
@Service
public class PersonaService {
	
	@Autowired
	private IPersonaRepository repository;

	public List<Persona> findAllByPersonaIdIn(List<BigDecimal> numeros) {
		return repository.findAllByPersonaIdIn(numeros, Sort.by("apellido").ascending().and(Sort.by("nombre").ascending()));
	}

	public Persona findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
		return repository.findByPersonaIdAndDocumentoId(personaId, documentoId).orElse(new Persona());
	}

}
