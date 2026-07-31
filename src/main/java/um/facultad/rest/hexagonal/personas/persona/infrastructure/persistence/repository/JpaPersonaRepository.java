/**
 * 
 */
package um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.entity.PersonaEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface JpaPersonaRepository extends JpaRepository<PersonaEntity, Long> {

	List<PersonaEntity> findAllByPersonaIdIn(List<BigDecimal> numeros, Sort sort);

	Optional<PersonaEntity> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
