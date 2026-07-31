/**
 * 
 */
package um.facultad.rest.service.view;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

import um.facultad.rest.model.view.PersonaKey;
import um.facultad.rest.repository.view.IPersonaKeyRepository;

/**
 * @author daniel
 *
 */
@Service
@RequiredArgsConstructor
public class PersonaKeyService {

	private final IPersonaKeyRepository repository;

	public List<PersonaKey> findAllByUnifieds(List<String> unifieds) {
		return repository.findAllByUnifiedIn(unifieds);
	}

}
