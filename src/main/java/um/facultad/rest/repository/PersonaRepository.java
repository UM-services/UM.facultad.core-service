/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.model.Persona;

/**
 * @author daniel
 *
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	List<Persona> findAllByPersonaIdIn(List<BigDecimal> numeros, Sort sort);

	Optional<Persona> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
