/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Provincia;
import ar.edu.um.facultad.rest.model.pk.ProvinciaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface IProvinciaRepository extends JpaRepository<Provincia, ProvinciaPk> {

	public Optional<Provincia> findByFacultadIdAndProvinciaId(Integer facultadId, Integer provinciaId);

}
