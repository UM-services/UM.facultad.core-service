/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import um.facultad.rest.model.EstadoEntity;
import um.facultad.rest.repository.EstadoRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class EstadoService {

	private final EstadoRepository repository;

	public List<EstadoEntity> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId) {
		return repository.findAllByPersonaIdInAndFacultadId(numeros, facultadId);
	}

}
