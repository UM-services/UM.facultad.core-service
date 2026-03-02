/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.model.LegajoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface LegajoRepository extends JpaRepository<LegajoEntity, Long> {

	List<LegajoEntity> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

	List<LegajoEntity> findAllByFacultadIdAndNumeroLegajoBetween(Integer facultadId, Long minimo, Long maximo);

	Optional<LegajoEntity> findByPersonaIdAndDocumentoIdAndFacultadId(BigDecimal personaId, Integer documentoId,
                                                                      Integer facultadId);

	Optional<LegajoEntity> findTopByFacultadIdAndIntercambioAndNumeroLegajoBetweenOrderByNumeroLegajoDesc(
			Integer facultadId, Byte intercambio, Long minimo, Long maximo);

}
