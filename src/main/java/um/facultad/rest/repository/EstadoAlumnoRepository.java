/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.EstadoAlumnoEntity;

/**
 * @author daniel
 *
 */
@Repository
public interface EstadoAlumnoRepository extends JpaRepository<EstadoAlumnoEntity, Integer> {

	public Optional<EstadoAlumnoEntity> findByEstadoId(Integer estadoId);

}
