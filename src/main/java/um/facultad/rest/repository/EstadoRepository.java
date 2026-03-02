/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.EstadoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {

	public List<EstadoEntity> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

}
