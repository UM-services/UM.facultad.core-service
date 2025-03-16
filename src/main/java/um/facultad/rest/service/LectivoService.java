/**
 * 
 */
package um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import um.facultad.rest.exception.LectivoException;
import um.facultad.rest.model.Lectivo;
import um.facultad.rest.repository.LectivoRepository;

/**
 * @author daniel
 *
 */
@Service
public class LectivoService {

	@Autowired
	private LectivoRepository repository;

	public List<Lectivo> findAll() {
		return repository.findAll(Sort.by("lectivoId").ascending());
	}

	public List<Lectivo> findAllReverse() {
		return repository.findAll(Sort.by("lectivoId").descending());
	}

	public Lectivo findByLectivoId(Integer lectivoId) {
		return repository.findByLectivoId(lectivoId).orElseThrow(() -> new LectivoException(lectivoId));
	}

}
