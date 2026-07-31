/**
 * 
 */
package um.facultad.rest.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import um.facultad.rest.model.MateriaCarreraEntity;
import um.facultad.rest.repository.MateriaCarreraRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class MateriaCarreraService {

	private final MateriaCarreraRepository repository;

	public List<MateriaCarreraEntity> findAllByCarrera(Integer facultadId, Integer planId, Integer carreraId) {
		return repository.findAllByFacultadIdAndPlanIdAndCarreraId(facultadId, planId, carreraId);
	}

}
