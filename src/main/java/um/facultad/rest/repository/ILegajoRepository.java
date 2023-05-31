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
import um.facultad.rest.kotlin.model.Legajo;

/**
 * @author daniel
 *
 */
@Repository
public interface ILegajoRepository extends JpaRepository<Legajo, Long> {

	public List<Legajo> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

	public List<Legajo> findAllByFacultadIdAndNumeroLegajoBetween(Integer facultadId, Long minimo, Long maximo);

	public Optional<Legajo> findByPersonaIdAndDocumentoIdAndFacultadId(BigDecimal personaId, Integer documentoId,
			Integer facultadId);

	public Optional<Legajo> findTopByFacultadIdAndIntercambioAndNumeroLegajoBetweenOrderByNumeroLegajoDesc(
			Integer facultadId, Byte intercambio, Long minimo, Long maximo);

}
