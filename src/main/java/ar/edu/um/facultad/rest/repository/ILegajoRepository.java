/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Legajo;
import ar.edu.um.facultad.rest.model.pk.LegajoPk;

/**
 * @author daniel
 *
 */
@Repository
public interface ILegajoRepository extends JpaRepository<Legajo, LegajoPk> {

	public List<Legajo> findAllByPersonaIdInAndFacultadId(List<BigDecimal> numeros, Integer facultadId);

	public List<Legajo> findAllByFacultadIdAndNumeroLegajoBetween(Integer facultadId, Long minimo, Long maximo);

	public Optional<Legajo> findByPersonaIdAndDocumentoIdAndFacultadId(BigDecimal personaId, Integer documentoId,
			Integer facultadId);

	public Optional<Legajo> findTopByFacultadIdAndIntercambioAndNumeroLegajoBetweenOrderByNumeroLegajoDesc(
			Integer facultadId, Byte intercambio, Long minimo, Long maximo);

}
