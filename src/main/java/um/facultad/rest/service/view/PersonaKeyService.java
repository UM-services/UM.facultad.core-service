/**
 * 
 */
package um.facultad.rest.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.PersonaKey;
import um.facultad.rest.repository.view.IPersonaKeyRepository;

/**
 * @author daniel
 *
 */
@Service
public class PersonaKeyService {

	@Autowired
	private IPersonaKeyRepository repository;

	public List<PersonaKey> findAllByUnifieds(List<String> unifieds) {
		return repository.findAllByUnifiedIn(unifieds);
	}

}
