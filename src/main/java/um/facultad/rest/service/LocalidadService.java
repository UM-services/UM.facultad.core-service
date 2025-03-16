/**
 * 
 */
package um.facultad.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LocalidadException;
import um.facultad.rest.model.Localidad;
import um.facultad.rest.repository.LocalidadRepository;

/**
 * @author daniel
 *
 */
@Service
public class LocalidadService {

	@Autowired
	private LocalidadRepository repository;

	public Localidad findByUnique(Integer facultadId, Integer provinciaId, Integer localidadId) {
		return repository.findByFacultadIdAndProvinciaIdAndLocalidadId(facultadId, provinciaId, localidadId)
				.orElseThrow(() -> new LocalidadException(facultadId, provinciaId, localidadId));
	}

}
