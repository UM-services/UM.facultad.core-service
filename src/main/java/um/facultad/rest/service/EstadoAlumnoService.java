/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.EstadoAlumnoException;
import um.facultad.rest.model.EstadoAlumnoEntity;
import um.facultad.rest.repository.EstadoAlumnoRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class EstadoAlumnoService {

	private final EstadoAlumnoRepository repository;

	public EstadoAlumnoEntity findByEstadoId(Integer estadoId) {
		return repository.findByEstadoId(estadoId).orElseThrow(() -> new EstadoAlumnoException(estadoId));
	}

}
