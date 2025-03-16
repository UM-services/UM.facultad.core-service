/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Division;
import um.facultad.rest.model.pk.DivisionPk;

/**
 * @author daniel
 *
 */
@Repository
public interface DivisionRepository extends JpaRepository<Division, DivisionPk> {

	public Optional<Division> findByFacultadIdAndDivisionId(Integer facultadId, Integer divisionId);

}
