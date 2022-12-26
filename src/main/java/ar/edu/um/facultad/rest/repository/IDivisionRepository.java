/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Division;
import ar.edu.um.facultad.rest.model.pk.DivisionPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IDivisionRepository extends JpaRepository<Division, DivisionPk> {

	public Optional<Division> findByFacultadIdAndDivisionId(Integer facultadId, Integer divisionId);

}
