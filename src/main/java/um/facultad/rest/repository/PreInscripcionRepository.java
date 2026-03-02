/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.PreInscripcionEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface PreInscripcionRepository extends JpaRepository<PreInscripcionEntity, Long> {

	public List<PreInscripcionEntity> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

	public List<PreInscripcionEntity> findAllByFacultadIdAndLectivoIdAndGeograficaId(Integer facultadId, Integer lectivoId,
                                                                                     Integer geograficaId);

	public List<PreInscripcionEntity> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndTurnoId(Integer facultadId,
                                                                                               Integer lectivoId, Integer geograficaId, Integer turnoId);

	public Optional<PreInscripcionEntity> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId,
                                                                                                 BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
