/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.EstadoAlumno;

/**
 * @author daniel
 *
 */
@Repository
public interface EstadoAlumnoRepository extends JpaRepository<EstadoAlumno, Integer> {

	public Optional<EstadoAlumno> findByEstadoId(Integer estadoId);

}
