/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import um.facultad.rest.kotlin.model.Legajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daniel
 *
 */
@Repository
public interface LegajoRepository extends JpaRepository<Legajo, Long> {

	List<Legajo> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

	List<Legajo> findAllByFacultadIdAndNumeroLegajoBetween(Integer facultadId, Long minimo, Long maximo);

	Optional<Legajo> findByPersonaIdAndDocumentoIdAndFacultadId(BigDecimal personaId, Integer documentoId,
			Integer facultadId);

	Optional<Legajo> findTopByFacultadIdAndIntercambioAndNumeroLegajoBetweenOrderByNumeroLegajoDesc(
			Integer facultadId, Byte intercambio, Long minimo, Long maximo);

}
