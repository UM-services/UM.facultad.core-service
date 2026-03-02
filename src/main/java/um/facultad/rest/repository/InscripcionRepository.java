/**
 * 
 */
package um.facultad.rest.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.InscripcionEntity;
import um.facultad.rest.model.pk.InscripcionPk;

/**
 * @author daniel
 *
 */
@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionEntity, InscripcionPk> {

	List<InscripcionEntity> findAllByFacultadIdAndLectivoId(Integer facultadId, Integer lectivoId);

	List<InscripcionEntity> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCurso(Integer facultadId,
                                                                                   Integer lectivoId, Integer geograficaId, Integer curso);

	List<InscripcionEntity> findAllByFacultadIdAndLectivoIdAndGeograficaIdAndCursoAndProvisoria(Integer facultadId,
                                                                                                Integer lectivoId, Integer geograficaId, Integer curso, Byte provisoria);

	List<InscripcionEntity> findAllByPersonaIdAndDocumentoIdAndFacultadIdAndLectivoIdLessThanOrderByLectivoIdDesc(
			BigDecimal personaId, Integer documentoId, Integer facultadId, Integer lectivoId);

	Optional<InscripcionEntity> findByFacultadIdAndPersonaIdAndDocumentoIdAndLectivoId(Integer facultadId,
                                                                                       BigDecimal personaId, Integer documentoId, Integer lectivoId);

}
