/**
 * 
 */
package um.facultad.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import um.facultad.rest.model.ProvinciaEntity;
import um.facultad.rest.model.pk.ProvinciaPk;

/**
 * @author daniel
 *
 */
@Repository
public interface ProvinciaRepository extends JpaRepository<ProvinciaEntity, ProvinciaPk> {

	public Optional<ProvinciaEntity> findByFacultadIdAndProvinciaId(Integer facultadId, Integer provinciaId);

}
