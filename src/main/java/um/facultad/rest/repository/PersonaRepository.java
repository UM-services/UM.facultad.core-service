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
import um.facultad.rest.model.PersonaEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

	List<PersonaEntity> findAllByPersonaIdIn(List<BigDecimal> numeros, Sort sort);

	Optional<PersonaEntity> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
