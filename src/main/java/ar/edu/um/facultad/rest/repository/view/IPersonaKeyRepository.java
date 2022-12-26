/**
 * 
 */
package ar.edu.um.facultad.rest.repository.view;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.view.PersonaKey;

/**
 * @author daniel
 *
 */
@Repository
public interface IPersonaKeyRepository extends JpaRepository<PersonaKey, Long> {

	public List<PersonaKey> findAllByUnifiedIn(List<String> unifieds);

}
