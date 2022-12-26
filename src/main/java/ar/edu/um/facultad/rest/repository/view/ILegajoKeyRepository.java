/**
 * 
 */
package ar.edu.um.facultad.rest.repository.view;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.view.LegajoKey;

/**
 * @author daniel
 *
 */
@Repository
public interface ILegajoKeyRepository extends JpaRepository<LegajoKey, Long> {

	public List<LegajoKey> findAllByFacultadIdAndIntercambioAndNumerolegajoAndPersonakeyIn(Integer facultadId,
			Byte intercambio, Long numerolegajo, Set<String> keys);

	public List<LegajoKey> findAllByFacultadIdAndPersonakeyIn(Integer facultadId, List<String> keys);

}
