/**
 * 
 */
package um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.InscriptoMateria;
import um.facultad.rest.repository.view.IInscriptoMateriaRepository;

/**
 * @author daniel
 *
 */
@Service
public class InscriptoMateriaService {
	@Autowired
	private IInscriptoMateriaRepository repository;

	public List<InscriptoMateria> findAllByDivision(Integer facultadId, Integer lectivoId, Integer planId,
			String materiaId, Integer cursoId, Integer periodoId, Integer divisionId, Integer geograficaId) {
		return repository
				.findAllByFacultadIdAndLectivoIdAndPlanIdAndMateriaIdAndCursoIdAndPeriodoIdAndDivisionIdAndGeograficaId(
						facultadId, lectivoId, planId, materiaId, cursoId, periodoId, divisionId, geograficaId,
						Sort.by("apellido").ascending().and(Sort.by("nombre").ascending()));
	}
}
