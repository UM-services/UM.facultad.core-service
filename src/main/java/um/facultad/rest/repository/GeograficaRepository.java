/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.GeograficaEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface GeograficaRepository extends JpaRepository<GeograficaEntity, Integer> {

	public Optional<GeograficaEntity> findByGeograficaId(Integer geograficaId);

}
