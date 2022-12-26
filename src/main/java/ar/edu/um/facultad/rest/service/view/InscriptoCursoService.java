/**
 * 
 */
package ar.edu.um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.view.InscriptoCurso;
import ar.edu.um.facultad.rest.repository.view.IInscriptoCursoRepository;

/**
 * @author daniel
 *
 */
@Service
public class InscriptoCursoService {

	@Autowired
	private IInscriptoCursoRepository repository;

	public List<InscriptoCurso> findAllByLectivo(Integer facultadId, Integer lectivoId, Integer geograficaId) {
		return repository.findAllByFacultadIdAndLectivoIdAndGeograficaId(facultadId, lectivoId, geograficaId,
				Sort.by("planId").descending().and(Sort.by("carreraId").ascending()).and(Sort.by("curso").ascending()));
	}

	public List<InscriptoCurso> findAllByCurso(Integer facultadId, Integer lectivoId) {
		return repository.findAllByFacultadIdAndLectivoId(facultadId, lectivoId,
				Sort.by("geograficaId").ascending().and(Sort.by("planId").descending()
						.and(Sort.by("carreraId").ascending()).and(Sort.by("curso").ascending())));
	}

}
