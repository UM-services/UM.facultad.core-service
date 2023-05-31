/**
 * 
 */
package um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.PreunivMatricResumen;
import um.facultad.rest.repository.view.IPreunivMatricResumenRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreunivMatricResumenService {

	@Autowired
	private IPreunivMatricResumenRepository repository;

	public List<PreunivMatricResumen> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
