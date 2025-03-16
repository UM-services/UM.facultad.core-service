/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.Estado;
import um.facultad.rest.repository.EstadoRepository;

/**
 * @author daniel
 *
 */
@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId) {
		return repository.findAllByPersonaIdInAndFacultadId(numeros, facultadId);
	}

}
