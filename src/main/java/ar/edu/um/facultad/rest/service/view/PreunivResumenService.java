/**
 * 
 */
package ar.edu.um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.view.PreunivResumen;
import ar.edu.um.facultad.rest.repository.view.IPreunivResumenRepository;

/**
 * @author daniel
 *
 */
@Service
public class PreunivResumenService {

	@Autowired
	private IPreunivResumenRepository repository;

	public List<PreunivResumen> findAllByLectivo(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId, Sort.by("geograficaId").ascending()
				.and(Sort.by("planId").ascending()).and(Sort.by("carreraId").ascending()).and(Sort.by("turnoId")));
	}

}
