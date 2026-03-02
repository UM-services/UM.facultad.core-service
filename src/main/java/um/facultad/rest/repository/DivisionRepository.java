/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.DivisionEntity;
import um.facultad.rest.model.pk.DivisionPk;

/**
 * @author daniel
 *
 */
@Repository
public interface DivisionRepository extends JpaRepository<DivisionEntity, DivisionPk> {

	public Optional<DivisionEntity> findByFacultadIdAndDivisionId(Integer facultadId, Integer divisionId);

}
