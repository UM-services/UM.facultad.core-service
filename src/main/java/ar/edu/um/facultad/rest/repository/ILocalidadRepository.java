/**
 * 
 */
package ar.edu.um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.facultad.rest.model.Localidad;
import ar.edu.um.facultad.rest.model.pk.LocalidadPk;

/**
 * @author daniel
 *
 */
@Repository
public interface ILocalidadRepository extends JpaRepository<Localidad, LocalidadPk> {

	public Optional<Localidad> findByFacultadIdAndProvinciaIdAndLocalidadId(Integer facultadId, Integer provinciaId,
			Integer localidadId);

}
