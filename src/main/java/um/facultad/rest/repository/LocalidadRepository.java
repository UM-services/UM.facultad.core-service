/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.Localidad;
import um.facultad.rest.model.pk.LocalidadPk;

/**
 * @author daniel
 *
 */
@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, LocalidadPk> {

	public Optional<Localidad> findByFacultadIdAndProvinciaIdAndLocalidadId(Integer facultadId, Integer provinciaId,
			Integer localidadId);

}
