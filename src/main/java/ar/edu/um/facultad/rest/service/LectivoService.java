/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.exception.LectivoNotFoundException;
import ar.edu.um.facultad.rest.model.Lectivo;
import ar.edu.um.facultad.rest.repository.ILectivoRepository;

/**
 * @author daniel
 *
 */
@Service
public class LectivoService {

	@Autowired
	private ILectivoRepository repository;

	public List<Lectivo> findAll() {
		return repository.findAll(Sort.by("lectivoId").ascending());
	}

	public List<Lectivo> findAllReverse() {
		return repository.findAll(Sort.by("lectivoId").descending());
	}

	public Lectivo findByLectivoId(Integer lectivoId) {
		return repository.findByLectivoId(lectivoId).orElseThrow(() -> new LectivoNotFoundException(lectivoId));
	}

}
