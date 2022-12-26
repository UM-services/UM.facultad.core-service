/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.MateriaCurso;
import ar.edu.um.facultad.rest.repository.IMateriaCursoRepository;

/**
 * @author daniel
 *
 */
@Service
public class MateriaCursoService {

	@Autowired
	private IMateriaCursoRepository repository;

	public List<MateriaCurso> findAllByCurso(Integer facultadId, Integer planId, Integer carreraId, Integer curso) {
		return repository.findAllByFacultadIdAndPlanIdAndCarreraIdAndCurso(facultadId, planId, carreraId, curso);
	}

	public List<MateriaCurso> findAllByCarrera(Integer facultadId, Integer planId, Integer carreraId) {
		return repository.findAllByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId);
	}

}
