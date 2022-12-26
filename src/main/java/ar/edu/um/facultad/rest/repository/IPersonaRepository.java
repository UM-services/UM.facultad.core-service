/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Persona;
import ar.edu.um.facultad.rest.model.pk.PersonaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, PersonaPk> {

	public List<Persona> findAllByPersonaIdIn(List<BigDecimal> numeros, Sort sort);

	public Optional<Persona> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
