/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Facultad;

/**
 * @author daniel
 *
 */
@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Integer> {

	public Optional<Facultad> findByFacultadId(Integer facultadId);

}
