/**
 * 
 */
package um.facultad.rest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.RegularidadEntity;
import um.facultad.rest.repository.RegularidadRepository;

/**
 * @author daniel
 *
 */
@Service
public class RegularidadService {

	@Autowired
	private RegularidadRepository repository;

	public List<RegularidadEntity> findAllByMaterias(BigDecimal personaId, Integer documentoId, Integer facultadId,
                                                     Integer planId, List<String> materiaIds) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdInOrderByFechaDesc(
				personaId, documentoId, facultadId, planId, materiaIds);
	}

	public List<RegularidadEntity> findAllByMateria(BigDecimal personaId, Integer documentoId, Integer facultadId,
                                                    Integer planId, String materiaId) {
		return repository.findAllByPersonaIdAndDocumentoIdAndFacultadIdAndPlanIdAndMateriaIdOrderByFechaDesc(personaId,
				documentoId, facultadId, planId, materiaId);
	}

}
