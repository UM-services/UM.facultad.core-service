/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Geografica;

/**
 * @author daniel
 *
 */
@Repository
public interface GeograficaRepository extends JpaRepository<Geografica, Integer> {

	public Optional<Geografica> findByGeograficaId(Integer geograficaId);

}
