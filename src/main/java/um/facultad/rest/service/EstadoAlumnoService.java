/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.EstadoAlumnoException;
import um.facultad.rest.model.EstadoAlumno;
import um.facultad.rest.repository.EstadoAlumnoRepository;

/**
 * @author daniel
 *
 */
@Service
public class EstadoAlumnoService {

	@Autowired
	private EstadoAlumnoRepository repository;

	public EstadoAlumno findByEstadoId(Integer estadoId) {
		return repository.findByEstadoId(estadoId).orElseThrow(() -> new EstadoAlumnoException(estadoId));
	}

}
