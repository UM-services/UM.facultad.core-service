/**
 * 
 */
package um.facultad.rest.service.view;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.LegajoKey;
import um.facultad.rest.repository.view.ILegajoKeyRepository;

/**
 * @author daniel
 *
 */
@Service
public class LegajoKeyService {

	@Autowired
	private ILegajoKeyRepository repository;

	public List<LegajoKey> findAllByFacultadIdAndIntercambioAndNumerolegajoAndPersonakeyIn(Integer facultadId,
			Byte intercambio, Long numerolegajo, Set<String> keys) {
		return repository.findAllByFacultadIdAndIntercambioAndNumerolegajoAndPersonakeyIn(facultadId, intercambio,
				numerolegajo, keys);
	}

	public List<LegajoKey> findAllByFacultadAndPersonaKeys(Integer facultadId, List<String> personaKeys) {
		return repository.findAllByFacultadIdAndPersonakeyIn(facultadId, personaKeys);
	}

}
