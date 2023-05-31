/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.EstadoAlumnoNotFoundException;
import um.facultad.rest.model.EstadoAlumno;
import um.facultad.rest.repository.IEstadoAlumnoRepository;

/**
 * @author daniel
 *
 */
@Service
public class EstadoAlumnoService {

	@Autowired
	private IEstadoAlumnoRepository repository;

	public EstadoAlumno findByEstadoId(Integer estadoId) {
		return repository.findByEstadoId(estadoId).orElseThrow(() -> new EstadoAlumnoNotFoundException(estadoId));
	}

}
