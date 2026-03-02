/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.BajaEntity;
import um.facultad.rest.model.pk.BajaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface BajaRepository extends JpaRepository<BajaEntity, BajaPk> {

	public Optional<BajaEntity> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId, BigDecimal personaId,
                                                                                       Integer documentoId, Integer lectivoId);

}
