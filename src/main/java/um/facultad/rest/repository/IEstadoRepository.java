/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Estado;

/**
 * @author daniel
 *
 */
@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Long> {

	public List<Estado> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

}
