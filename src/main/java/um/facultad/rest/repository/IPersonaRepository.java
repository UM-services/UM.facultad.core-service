/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import um.facultad.rest.kotlin.model.Persona;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.kotlin.model.Persona;

/**
 * @author daniel
 *
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

	public List<Persona> findAllByPersonaIdIn(List<BigDecimal> numeros, Sort sort);

	public Optional<Persona> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
