/**
 * 
 */
package ar.edu.um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.facultad.rest.model.Regularidad;
import ar.edu.um.facultad.rest.repository.IRegularidadRepository;

/**
 * @author daniel
 *
 */
@Service
public class RegularidadService {

	@Autowired
	private IRegularidadRepository repository;

	public List<Regularidad> findAllByMaterias(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer planId, List<String> materiaIds) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdInOrderByFechaDesc(
				personaId, documentoId, facultadId, planId, materiaIds);
	}

	public List<Regularidad> findAllByMateria(BigDecimal personaId, Integer documentoId, Integer facultadId,
			Integer planId, String materiaId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdOrderByFechaDesc(personaId,
				documentoId, facultadId, planId, materiaId);
	}

}
