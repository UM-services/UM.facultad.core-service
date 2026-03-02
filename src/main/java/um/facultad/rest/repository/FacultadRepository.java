/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.FacultadEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface FacultadRepository extends JpaRepository<FacultadEntity, Integer> {

	public Optional<FacultadEntity> findByFacultadId(Integer facultadId);

}
