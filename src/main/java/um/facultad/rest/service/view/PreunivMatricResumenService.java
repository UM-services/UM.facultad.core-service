/**
 * 
 */
package um.facultad.rest.service.view;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.PreunivMatricResumen;
import um.facultad.rest.repository.view.IPreunivMatricResumenRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class PreunivMatricResumenService {

	private final IPreunivMatricResumenRepository repository;

	public List<PreunivMatricResumen> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId);
	}

}
