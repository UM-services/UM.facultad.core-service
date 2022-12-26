/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.EstadoAlumno;

/**
 * @author daniel
 *
 */
@Repository
public interface IEstadoAlumnoRepository extends JpaRepository<EstadoAlumno, Integer> {

	public Optional<EstadoAlumno> findByEstadoId(Integer estadoId);

}
